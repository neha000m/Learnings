using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class CountryController : ControllerBase
    {
        HotellistDBContext _context;

        public CountryController(HotellistDBContext context)
        {
            _context = context;
        }
        // Example action method
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Countries>>> GetCountries()
        {
            List<Countries> countryList = await _context.Countries.ToListAsync();
            // Logic to retrieve countries would go here
            return Ok(countryList);
        }
        [HttpGet("{id}")]
public async Task<ActionResult<Countries>> GetCountryById(string id)
{
    var country = await _context.Countries.FindAsync(id);
    if (country == null)
        return NotFound();

    return Ok(country);
}

        [HttpPost]
        public async Task<ActionResult<Countries>> AddCountry([FromBody] Countries country)
        {

            _context.Countries.Add(country);
            await _context.SaveChangesAsync();


            return CreatedAtAction(nameof(GetCountryById), new { id = country.Id }, country);

        }

        [HttpPut("{id}")]
        public async Task<ActionResult<Countries>> UpdateCountry(string id, [FromBody] Countries country)
        {
            if (id != country.Id)
            {
                return BadRequest();
            }

            _context.Entry(country).State = EntityState.Modified;
            try
            {
               await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!_context.Countries.Any(c => c.Id == id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCountry(string id)
        {
            var country = await _context.Countries.FindAsync(id);
            if (country == null)
            {
                return NotFound();
            }

            _context.Countries.Remove(country);
            
            await _context.SaveChangesAsync();

            return NoContent();
        }
    }
}
