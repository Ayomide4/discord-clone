using DiscordService.Db;
using DiscordService.Interfaces;
using DiscordService.Models.Login;
using DiscordService.Models.Signup;
using DiscordService.Models.User;
using Microsoft.AspNetCore.Identity.Data;

namespace DiscordService.Services
{
    public class LoginService : ILogin
    {
        private readonly AppDbContext _context;
        public LoginService(AppDbContext context)
        {
            _context = context;
        }
        public LoginResponse Login(Models.Login.LoginRequest loginRequest)
        {
            try
            {
                User? user = _context.User.FirstOrDefault(u => u.Username == loginRequest.Username);
                if (user == null || !BCrypt.Net.BCrypt.Verify(loginRequest.Password, user.Password))
                {
                    return new LoginResponse
                    {
                        Success = false,
                        ErrorMessage = "Invalid username or password"
                    };
                }
                return new LoginResponse
                {
                    Success = true
                };
            }
            catch (Exception e)
            {
                return new LoginResponse
                {
                    Success = false,
                    ErrorMessage = e.Message
                };
            }
        }

        public SignupResponse SignUp(SignupRequest signupRequest)
        {
            if (string.IsNullOrEmpty(signupRequest.Username) || string.IsNullOrEmpty(signupRequest.Password) || string.IsNullOrEmpty(signupRequest.Email) ||
                string.IsNullOrEmpty(signupRequest.DisplayName))
            {
                return new SignupResponse
                {
                    Success = false,
                    ErrorMessage = "All fields are required"
                };
            }

            if (signupRequest.DateOfBirth > DateTime.Now.AddYears(-13))
            {
                return new SignupResponse
                {
                    Success = false,
                    ErrorMessage = "You must be at least 13 years old to sign up"
                };
            }
            try
            {
                User? signupEmailUser = _context.User.FirstOrDefault(u => u.Username == signupRequest.Username);
                if (signupEmailUser != null)
                {
                    return new SignupResponse
                    {
                        Success = false,
                        ErrorMessage = "Username already exists"
                    };
                }
            }
            catch (Exception e)
            {
                return new SignupResponse
                {
                    Success = false,
                    ErrorMessage = $"Error retrieving user details {e.Message}"
                };
            }


            try
            {
                string hashedPassword = BCrypt.Net.BCrypt.HashPassword(signupRequest.Password);
                User user = new(signupRequest.Username, hashedPassword, signupRequest.Email, signupRequest.DisplayName, signupRequest.DateOfBirth);
                _context.User.Add(user);
                _context.SaveChanges();
                return new SignupResponse
                {
                    Success = true
                };
            }
            catch (Exception e)
            {
                return new SignupResponse
                {
                    Success = false,
                    ErrorMessage = e.Message
                };
            }
        }
    }
}
