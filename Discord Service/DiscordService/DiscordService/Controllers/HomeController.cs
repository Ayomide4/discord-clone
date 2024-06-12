using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace DiscordService.Controllers
{
    [ApiController]
    [Route("api/[Controller]/[Action]")]
    public class HomeController : Controller
    {

        public HomeController()
        {
        }

        [RequireHttps]
        [HttpGet]
        [Authorize(AuthenticationSchemes = JwtBearerDefaults.AuthenticationScheme)]
        public IActionResult InitialLoad()
        {
            return Ok("Welcome to DiscordService");
        }
        
    }
}
