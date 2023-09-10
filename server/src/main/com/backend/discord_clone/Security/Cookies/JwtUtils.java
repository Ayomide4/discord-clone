package com.backend.discord_clone.Security.Cookies;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseCookie;
import org.springframework.web.util.WebUtils;

import com.backend.discord_clone.AppUser.AppUser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

/**
 * JwtUtils handles JWT token generation and validation.
 */
@Configuration
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class); //Logger for logging events.
  
  @Value("${security.jwt.secret}")
  private String jwtSecret;

  @Value("${security.jwt.expiration}")
  private int jwtExpirationMs;

  @Value("${security.jwt.cookieName}")
  private String jwtCookie;

  /**
   * Gets JWT from HTTP Cookie.
   * @param request JWT being passed in HTTP Cookie.
   * @return Returns cookie value if cookie exists, else returns null.
   */
  public String getJwtFromCookies(HttpServletRequest request) {
    Cookie cookie = WebUtils.getCookie(request, jwtCookie);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }

    /**
     * Generates JWT cookie.
     * @param userPrincipal User principal.
     * @return Returns JWT cookie.
     */
    public ResponseCookie generateJwtCookie(AppUser userPrincipal) {
      String jwt = generateTokenFromUsername(userPrincipal.getUsername());
      ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
      return cookie;
    }

  /**
   * Generates clean JWT cookie.
   * @return Returns clean JWT cookie.
   */
  public ResponseCookie getCleanJwtCookie() {
    ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build(); //Generates clean JWT cookie.
    return cookie; //Returns clean JWT cookie.
  }

  /**
   * Gets username from JWT token.
   * @param token JWT token.
   * @return Returns username from JWT token.
   */
  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build() //Gets username from JWT token.
        .parseClaimsJws(token).getBody().getSubject(); //Gets username from JWT token.
  }
  
  /**
   * Generates JWT token.
   * @return Returns JWT token.
   */
  private Key key() { 
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)); //Generates JWT token.
  }

  /**
   * Validates JWT token.
   * @param authToken JWT token.
   * @return Returns true if JWT token is valid, else returns false.
   */
  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
  
  /**
   * Generates JWT token from username.
   * @param username Username.
   * @return Returns JWT token.
   */
  public String generateTokenFromUsername(String username) {   
    return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
              .signWith(key(), SignatureAlgorithm.HS256)
              .compact();
  }
}
