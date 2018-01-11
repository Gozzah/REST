/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;



/**
 *
 * @author Runes tryllemaskine
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private List<String> fName = new ArrayList();
    private List<String> lName = new ArrayList();
    private List<Integer> age = new ArrayList();
    private List<Integer> id = new ArrayList();

    public DataGenerator() {

        populateLists();

    }

    private void populateLists() {

        fName.add("Christian");
        fName.add("Bjørn");
        fName.add("Hannibal");
        fName.add("Martin");
        fName.add("Menja");
        fName.add("Niki");
        fName.add("Scarlet");
        fName.add("Chuck");
        fName.add("Anna");
        fName.add("Nathan");
        fName.add("Donald");
        fName.add("Mickey");
        fName.add("Daisy");
        fName.add("Rikke");
        fName.add("Bruce");
        
        lName.add("Drake");
        lName.add("Wake");
        lName.add("Wayne");
        lName.add("Croft");
        lName.add("Olsen");
        lName.add("Gates");
        lName.add("Jobs");
        lName.add("Hansen");
        lName.add("Kristiansen");
        lName.add("Skriver");
        lName.add("Malcom");
        lName.add("Petersen");
        lName.add("Knoop");
        lName.add("Kjær");
        lName.add("Johansen");
        lName.add("Bale");
        lName.add("Jørgensen");
        lName.add("Duck");
        lName.add("Mouse");
        lName.add("Jones");
        lName.add("Boss");
        lName.add("Forsberg");
        lName.add("Vettergren");
        lName.add("Akara");
        lName.add("Engelbrekt");
        
         age.add(17);
        age.add(18);
        age.add(19);
        age.add(20);
        age.add(21);
        age.add(22);
        age.add(23);
        age.add(24);
        age.add(25);
        age.add(26);
        age.add(27);
        age.add(28);
        age.add(29);
        age.add(30);
        age.add(31);
        age.add(32);
        age.add(33);
        age.add(34);
        age.add(35);
        age.add(36);
        age.add(37);
        age.add(38);
        age.add(39);
        age.add(40);
        age.add(41);
        age.add(42);
        age.add(43);
        age.add(44);
        age.add(45);
        age.add(46);
        age.add(47);
        age.add(48);
        age.add(49);
        age.add(50);
        age.add(51);
        age.add(52);
        age.add(53);
        age.add(54);
        age.add(55);
        age.add(56);
        age.add(57);
        age.add(58);
        age.add(59);
        age.add(60);
        age.add(61);
        age.add(62);
        age.add(63);
        age.add(64);
        age.add(65);
        age.add(66);
        age.add(67);
        age.add(68);
        age.add(69);
        age.add(70);
       
     
      
}
    
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;

    }
    
     public String getData(int amountOfPeople, String properties, int id) {

        JsonArray persons = new JsonArray();

        for (int i = 0; i < amountOfPeople; i++) {
            
            JsonObject person = new JsonObject();
            
            if(properties.contains("fname")){
                
                person.addProperty("fName", fName.get(randInt(0, fName.size() - 1)));
                
            }
            
            if(properties.contains("id")){
                
                person.addProperty("id", id ++);
                
            }
            if(properties.contains("lname")){
                
                person.addProperty("lName", lName.get(randInt(0, lName.size() - 1)));
                
            }
            if(properties.contains("age")){
                
                person.addProperty("age", age.get(randInt(0, age.size() - 1)));
                
            }
            
               persons.add(person);

        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        return gson.toJson(persons);
    
}
        
     }
