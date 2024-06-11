namespace DiscordService.Models.Login
{
    public class LoginResponse
    {
        public required bool Success { get; set; }
        public string? ErrorMessage { get; set; }
    }
}
