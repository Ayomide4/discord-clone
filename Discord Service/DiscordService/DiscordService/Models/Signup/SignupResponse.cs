namespace DiscordService.Models.Signup
{
    public class SignupResponse
    {
        public required bool Success { get; set; }
        public string? ErrorMessage { get; set; }
    }
}
