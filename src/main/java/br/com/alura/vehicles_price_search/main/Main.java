package br.com.alura.vehicles_price_search.main;

import br.com.alura.vehicles_price_search.models.InterativeMenu;
import br.com.alura.vehicles_price_search.services.JsonFromURL;

public class Main {
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    InterativeMenu menu = new InterativeMenu();
    JsonFromURL jsonFromURL = new JsonFromURL();

    public void test(){
        String answer = menu.ShowMenu();
        System.out.println(answer);

        try {
            String json = jsonFromURL.getJsonFromURL(BASE_URL + answer + "/marcas");
            System.out.println(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //System.out.println(json);
    }

}
