package br.com.alura.vehicles_price_search.main;

import br.com.alura.vehicles_price_search.exceptions.InvalidInputException;
import br.com.alura.vehicles_price_search.models.InterativeMenus;
import br.com.alura.vehicles_price_search.models.Models;
import br.com.alura.vehicles_price_search.models.ModelsData;
import br.com.alura.vehicles_price_search.models.Vehicles;
import br.com.alura.vehicles_price_search.services.JsonFromURL;
import br.com.alura.vehicles_price_search.services.JsonToClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    InterativeMenus menu = new InterativeMenus();
    JsonFromURL jsonFromURL = new JsonFromURL();
    JsonToClass conversor = new JsonToClass();

    public void test() {
        String firstInput = menu.ShowFirstMenu();
        String adress = BASE_URL;
        List<ModelsData> modelos;

        try {
            adress = adress + firstInput + "/marcas";
            String json = jsonFromURL.getJsonFromURL(adress);
            modelos = conversor.getList(json, ModelsData.class);
            modelos.stream().sorted(Comparator.comparing(ModelsData::name))
                    .map(ModelsData::toString)
                    .forEach(System.out::println);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }

        String secondInput = menu.ShowSecondMenu();

        try {
            adress = adress + "/" + secondInput + "/modelos";
            String json = jsonFromURL.getJsonFromURL(adress);
            var modelsList = conversor.getData(json, Models.class);
            modelsList.modelos().stream()
                    .sorted(Comparator.comparing(ModelsData::name))
                    .map(ModelsData::toString)
                    .forEach(System.out::println);
        } catch (InvalidInputException e) {
            throw new InvalidInputException("invalid code 2");
        }

        String thirdInput = menu.ShowThirdMenu();

        try {
            adress = adress + "/" + thirdInput + "/anos";
            String json = jsonFromURL.getJsonFromURL(adress);
            List<ModelsData> years = conversor.getList(json, ModelsData.class);
            List<Vehicles> veiculos = new ArrayList<>();

            for (int i = 0; i < years.size(); i++) {
                var yearAdress = adress + "/" + years.get(i).code();
                json = jsonFromURL.getJsonFromURL(yearAdress);
                Vehicles veiculo = conversor.getData(json, Vehicles.class);
                veiculos.add(veiculo);
            }

            veiculos.stream()
                    .forEach(System.out::println);

        } catch (InvalidInputException e) {
            throw new InvalidInputException("invalid code 3");
        }
    }
}