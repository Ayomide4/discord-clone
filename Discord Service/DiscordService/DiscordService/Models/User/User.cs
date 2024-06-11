using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DiscordService.Models.User
{
    [Table("user", Schema = "public")]
    public class User
    {
        public User(string username, string password, string email, string displayName, DateTime dob, bool? enabled = true , bool? locked = false, string? sessionToken = null,  DateTime? lastSignIn = null)
        {
            Dob = dob;
            LastSignIn = lastSignIn;
            DisplayName = displayName;
            Email = email;
            Password = password;
            SessionToken = sessionToken;
            Username = username;
            Enabled = enabled;
            Locked = locked;
        }

        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("id")]
        public int Id { get; set; }

        [Column("dob")]
        public DateTime Dob { get; set; }

        [Column("enabled")]
        public bool? Enabled { get; set; }

        [Column("locked")]
        public bool? Locked { get; set; }

        [Column("role")]
        [Range(0, 1, ErrorMessage = "Role must be between 0 and 1.")]
        public short? Role { get; set; }

        [Column("last_sign_in")]
        public DateTime? LastSignIn { get; set; }

        [Column("display_name")]
        [StringLength(255)]
        public string DisplayName { get; set; }

        [Column("email")]
        [StringLength(255)]
        public string Email { get; set; }

        [Column("password")]
        [StringLength(255)]
        public string Password { get; set; }

        [Column("session_token")]
        [StringLength(255)]
        public string? SessionToken { get; set; }

        [Column("username")]
        [StringLength(255)]
        public string Username { get; set; }
    }
}
