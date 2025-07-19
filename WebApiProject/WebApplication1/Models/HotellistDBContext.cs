using Microsoft.EntityFrameworkCore;

public class HotellistDBContext : DbContext
{
    public HotellistDBContext(DbContextOptions<HotellistDBContext> options)
        : base(options)
        {
    }

    public DbSet<Hotels> Hotels { get; set; }
    public DbSet<Countries> Countries { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Countries>()
            .HasData(
                new Countries { Id = "1", Name = "USA", Code = "US" },
                new Countries { Id = "2", Name = "Canada", Code = "CA" }
            );

            modelBuilder.Entity<Hotels>()
            .HasData(
                new Hotels { Id = "1", Name = "Hotel California", Location = "Los Angeles", Rating = 5, CountryId = "1" },
                new Hotels { Id = "2", Name = "Hotel Toronto", Location = "Toronto", Rating = 4, CountryId = "2" }  
            );
    }
}