package br.com.alura.vehicles_price_search.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Models(List<ModelsData> modelos) {
}
