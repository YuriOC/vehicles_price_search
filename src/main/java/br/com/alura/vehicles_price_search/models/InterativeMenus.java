package br.com.alura.vehicles_price_search.models;

import br.com.alura.vehicles_price_search.exceptions.InvalidInputException;

import java.util.Scanner;

public class InterativeMenus {
    private Scanner reader = new Scanner(System.in);

    public String ShowFirstMenu(){
        var FirstMenu = """
                ##### VEHICLE PRICE SEARCH #####
                
                --- OPTIONS ---
                
                1. CAR
                2. Motocycle
                3. Truck
                
                Type the option's number:""";
        System.out.println(FirstMenu);

        var FirstOption = reader.nextLine();

        if(FirstOption.contains("1") && FirstOption.length() < 2){
            return "carros";
        }
        else if(FirstOption.contains("2") && FirstOption.length() < 2){
            return "motos";
        }
        else if(FirstOption.contains("3") && FirstOption.length() < 2){
            return "caminhoes";
        }
        else {
            throw new InvalidInputException("Invalid code 1");
        }
    }

    public String ShowSecondMenu(){
        var SecondMenu = """
                Type your company's code choice:""";
        System.out.println(SecondMenu);

        var SecondOption = reader.nextLine();

        if(SecondOption.isEmpty()){
            throw new InvalidInputException("You must type a valid number");
        } else {
            return SecondOption;
        }
    }
}
