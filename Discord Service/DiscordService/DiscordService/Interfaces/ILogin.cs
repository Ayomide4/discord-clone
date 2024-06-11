using DiscordService.Models.Login;
using DiscordService.Models.Signup;

namespace DiscordService.Interfaces
{
    public interface ILogin
    {
        public LoginResponse Login(LoginRequest loginRequest);
        public SignupResponse SignUp(SignupRequest signupRequest);
    }
}
