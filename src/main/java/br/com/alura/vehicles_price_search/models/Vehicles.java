package br.com.alura.vehicles_price_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicles(@JsonAlias("Valor") String value,
        @JsonAlias("Marca") String company,
        @JsonAlias("Modelo") String model ,
        @JsonAlias("AnoModelo") String year,
        @JsonAlias("Combustivel") String fuelType) {

    @Override
    public String toString() {
        return "Value = " + value + "\n" +
                "Company = " + company + "\n" +
                "Model = " + model + "\n" +
                "Year = " + year + "\n" +
                "FuelType = " + fuelType + "\n";
    }
}
