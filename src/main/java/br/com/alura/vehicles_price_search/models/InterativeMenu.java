package br.com.alura.vehicles_price_search.models;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class InterativeMenu {
    private Scanner reader = new Scanner(System.in);

    public String ShowMenu(){
        var menu = """
                ##### VEHICLE PRICE SEARCH #####
                
                --- OPTIONS ---
                
                1. CAR
                2. Motocycle
                3. Truck
                
                Type the option's number:""";
        System.out.println(menu);

        var option = reader.nextLine();

        if(option.contains("1") && option.length() < 2){
            return "carros";
        }
        if(option.contains("2") && option.length() < 2){
            return "motos";
        }
        if(option.contains("3") && option.length() < 2){
            return "caminhoes";
        }

        return "Invalid Number";

    }
}
