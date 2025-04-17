package ma.emsi.mvcspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.emsi.mvcspring.entities.Product;
import ma.emsi.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			Product product = Product.builder()
					.name("Computer").price(5400).quantity(50)
					.build();
			productRepository.save(product);
			productRepository.save(Product.builder()
					.name("Printer").price(4900).quantity(3)
					.build());
			productRepository.save(Product.builder()
					.name("Smartphone").price(12000).quantity(2)
					.build());

			productRepository.findAll().forEach(p->{
				System.out.println(p.toString());
			});
		};
	}
}
