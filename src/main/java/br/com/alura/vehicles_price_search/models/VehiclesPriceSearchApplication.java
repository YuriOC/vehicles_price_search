package br.com.alura.vehicles_price_search.models;

import br.com.alura.vehicles_price_search.services.GetJsonFromURL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JsonParser;

@SpringBootApplication
public class VehiclesPriceSearchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesPriceSearchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        GetJsonFromURL JsonFromUrl = new GetJsonFromURL();
        System.out.println("hello world");

        String json = JsonFromUrl.getJsonFromURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
        System.out.println(json);


    }
}
