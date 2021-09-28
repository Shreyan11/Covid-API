
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class covidapi {

	public static void main(String[] args) {
		SpringApplication.run(covidapi.class, args);
	}

}
class Coffee{
	private final String id;
	private String name;
	
	public Coffee(String id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Coffee(String name){
		this(UUID.randomUUID.toString(),name);
	}
	
	
	public String getName(){
		return name;
	}
	
	
	public void setName(String name){
		this.name= name;
	}
	
}

	
@RestController
class RestApiDemoController {
	private List<Coffee> coffees = new ArrayList<>();
	public RestApiDemoController() {
	coffees.addAll(List.of(
		new covidapi("Espresso"); 
		new covidapi("Latte");
		new covidapi("Ghana");
		new covidapi("Columbia");
			 ));
	}
	
	
	@GetMapping
	Iterable<Coffee> getCoffees() {
		return coffees;
	}
	
	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id) {
		for (Coffee c: coffees) {
		if (c.getId().equals(id)) {
		return Optional.of(c);
	}
}
	return Optional.empty();
}
	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		coffees.add(coffee);
		return coffee;
}
	@PutMapping("/{id}")
	Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		int coffeeIndex = -1;
		for (Coffee c: coffees) {
		if (c.getId().equals(id)) {
		coffeeIndex = coffees.indexOf(c);
		coffees.set(coffeeIndex, coffee);
	}
}
	return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
	}
	@DeleteMapping("/{id}")
		void deleteCoffee(@PathVariable String id) {
		coffees.removeIf(c -> c.getId().equals(id));
}
}

	@PutMapping("/{id}")
		ResponseEntity<Coffee> putCoffee(@PathVariable String id,
		@RequestBody Coffee coffee) {
		int coffeeIndex = -1;
		for (Coffee c: coffees) {
		if (c.getId().equals(id)) {
		coffeeIndex = coffees.indexOf(c);
		coffees.set(coffeeIndex, coffee);
}
}
	return (coffeeIndex == -1) ?
	new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
	new ResponseEntity<>(coffee, HttpStatus.OK);
}
	
			 
		
		
		










