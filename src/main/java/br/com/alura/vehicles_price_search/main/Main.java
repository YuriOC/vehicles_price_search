package br.com.alura.vehicles_price_search.main;

import br.com.alura.vehicles_price_search.exceptions.InvalidInputException;
import br.com.alura.vehicles_price_search.models.InterativeMenus;
import br.com.alura.vehicles_price_search.services.JsonFromURL;

public class Main {
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    InterativeMenus menu = new InterativeMenus();
    JsonFromURL jsonFromURL = new JsonFromURL();

    public void test(){
        String firstInput = menu.ShowFirstMenu();

        try {
            String json = jsonFromURL.getJsonFromURL(BASE_URL + firstInput + "/marcas");
            System.out.println(json);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        String secondInput = menu.ShowSecondMenu();

        try{
            String json = jsonFromURL.getJsonFromURL(BASE_URL + firstInput + "/marcas/" + secondInput + "/modelos");
            System.out.println(json);
        } catch (InvalidInputException e) {
            throw new InvalidInputException("invalid code 2");
        }

        String thirdInput = menu.ShowThirdMenu();

        try{
            String json = jsonFromURL.getJsonFromURL(BASE_URL + firstInput + "/marcas/" + secondInput + "/modelos/" +
                    thirdInput + "/anos");
            System.out.println(json);
        } catch (InvalidInputException e) {
            throw new InvalidInputException("invalid code 3");
        }

        String fourthInput = menu.ShowFourthMenu();

        try{
            String json = jsonFromURL.getJsonFromURL(BASE_URL + firstInput + "/marcas/" + secondInput + "/modelos/" +
                    thirdInput + "/anos/" + fourthInput);
            System.out.println(json);
        } catch (InvalidInputException e) {
            throw new InvalidInputException("invalid code 4");
        }
    }

}
