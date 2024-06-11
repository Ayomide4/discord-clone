namespace DiscordService.Models.Signup
{
    public class SignupRequest
    {
        public required string DisplayName { get; set; }
        public required string Email { get; set; }
        public required string Username { get; set; }
        public required string Password { get; set; }
        public required DateTime DateOfBirth { get; set; }
    }
}
