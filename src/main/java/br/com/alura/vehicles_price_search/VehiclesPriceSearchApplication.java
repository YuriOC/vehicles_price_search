package br.com.alura.vehicles_price_search;

import br.com.alura.vehicles_price_search.exceptions.InvalidInputException;
import br.com.alura.vehicles_price_search.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesPriceSearchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesPriceSearchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();

        try{
            main.test();
        } catch(InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
