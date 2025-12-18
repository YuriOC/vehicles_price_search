package br.com.alura.vehicles_price_search.exceptions;

public class InvalidInputException extends RuntimeException {
    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
