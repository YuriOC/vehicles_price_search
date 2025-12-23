package br.com.alura.vehicles_price_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ModelsData(@JsonAlias("codigo") String code,
                         @JsonAlias("nome") String name) {

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
