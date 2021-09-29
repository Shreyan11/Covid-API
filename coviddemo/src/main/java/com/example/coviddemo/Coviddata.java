import org.springframework.data.mongodb.CountryRepo.RequestMapping
import org.springframework.data.mongodb.CountryRepo.ReatController

@RestController
@RequestMapping
public class Coviddata{
    private final Coviddata covidrepo;

    @GetMapping
    public List<Country> fetchallcountries(){
        return CountryRepo.fetchallcountries();

    }
}
