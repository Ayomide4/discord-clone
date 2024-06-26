﻿using DiscordService.Interfaces;
using DiscordService.Models.Login;
using DiscordService.Models.Signup;
using Microsoft.AspNetCore.Mvc;

namespace DiscordService.Controllers
{
    [ApiController]
    [Route("api/[Controller]/[Action]")]
    public class LoginController : Controller
    {
        private readonly ILogin _loginService;
        private readonly IJwt _jwt;
        public LoginController(ILogin loginService, IJwt jwt)
        {
            _loginService = loginService;
            _jwt = jwt;
        }

        [RequireHttps]
        [HttpPost]
        public IActionResult Login(LoginRequest loginRequest)
        {
            try
            {
                LoginResponse response = _loginService.Login(loginRequest);
                if (!response.Success)
                {
                    return BadRequest(response);
                }

                HttpContext.Response.Headers.Append("Authorization", "Bearer " + _jwt.GenerateToken(loginRequest.Username));
                return Ok(response.Success);
            }
            catch (Exception e)
            {
                return StatusCode(500, e.Message);
            }
        }

        [RequireHttps]
        [HttpPost]
        public IActionResult Signup(SignupRequest signupRequest)
        {
            try
            {
                SignupResponse response = _loginService.SignUp(signupRequest);
                if (!response.Success)
                {
                    return BadRequest(response);
                }
                return Ok(response.Success);
            }
            catch (Exception e)
            {
                return StatusCode(500, e.Message);
            }
        }
    }
}
