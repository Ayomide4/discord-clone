using DiscordService.Interfaces;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

public class Jwt : IJwt
{
    private readonly string _secretKey;
    private readonly string _issuer;
    private readonly string _audience;
    private readonly int _tokenExpiryMinutes;

    public Jwt(IConfiguration config)
    {
        _secretKey = config.GetValue<string>("Jwt:SecretKey") ?? throw new ArgumentNullException("Jwt:SecretKey");
        _issuer = config.GetValue<string>("Jwt:Issuer") ?? throw new ArgumentNullException("Jwt:Issuer");
        _audience = config.GetValue<string>("Jwt:Audience") ?? throw new ArgumentNullException("Jwt:Audience");
        _tokenExpiryMinutes = config.GetValue<int>("Jwt:TokenExpiryMinutes", 120);
    }

    /// <summary>
    /// Generates a JWT token for the given username and additional claims
    /// </summary>
    /// <param name="username">Username</param>
    /// <param name="additionalClaims">Additional Claims</param>
    /// <returns></returns>
    public string GenerateToken(string username, IDictionary<string, string>? additionalClaims = null)
    {
        var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_secretKey));
        var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

        var claims = new List<Claim>
        {
            new Claim(JwtRegisteredClaimNames.Sub, username),
            new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString())
        };

        if (additionalClaims != null)
        {
            foreach (var claim in additionalClaims)
            {
                claims.Add(new Claim(claim.Key, claim.Value));
            }
        }

        var token = new JwtSecurityToken(_issuer,
            _audience,
            claims,
            expires: DateTime.Now.AddMinutes(_tokenExpiryMinutes),
            signingCredentials: credentials);

        return new JwtSecurityTokenHandler().WriteToken(token);
    }
}
