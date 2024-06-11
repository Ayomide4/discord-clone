using DiscordService.Interfaces;
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
        public LoginController(ILogin loginService)
        {
            _loginService = loginService;
        }

        [RequireHttps]
        [HttpPost]
        public IActionResult Login(LoginRequest loginRequest)
        {
            try
            {
                return Ok(_loginService.Login(loginRequest));
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
                return Ok(_loginService.SignUp(signupRequest));
            }
            catch (Exception e)
            {
                return StatusCode(500, e.Message);
            }
        }
    }
}
