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
public class Tester {
    
    public static void main(String[] args) {
        
         DataGenerator dG = new DataGenerator(); 
        
        System.out.println(dG.getData(100, "fname,lname,age, id",1000));
     
    }
    
}
