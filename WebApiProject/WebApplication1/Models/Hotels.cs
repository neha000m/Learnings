using System.ComponentModel.DataAnnotations.Schema;

public class Hotels
{
    public string? Id { get; set; }
    public string? Name { get; set; }
    public string? Location { get; set; }
    public int? Rating { get; set; }

    public string? CountryId { get; set; }
    [ForeignKey("CountryId")]
    public Countries? Country { get; set; }
}