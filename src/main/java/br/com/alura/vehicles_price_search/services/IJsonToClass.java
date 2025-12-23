package br.com.alura.vehicles_price_search.services;

import java.util.List;

public interface IJsonToClass {
    <T> T getData(String json, Class<T> classe);

    <T> List<T> getList(String json, Class<T> classe);
}
