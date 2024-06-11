using DiscordService.Models.User;
using Microsoft.EntityFrameworkCore;

namespace DiscordService.Db
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

        public DbSet<User> User{ get; set; }
    }
}
