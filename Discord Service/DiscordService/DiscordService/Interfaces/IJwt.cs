namespace DiscordService.Interfaces
{
    public interface IJwt
    {
        public string GenerateToken(string username, IDictionary<string, string>? additionalClaims = null);
    }
}
