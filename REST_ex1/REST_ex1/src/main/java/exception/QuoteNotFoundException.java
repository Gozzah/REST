/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Peter Riis
 */
public class QuoteNotFoundException extends Exception {
    
        public QuoteNotFoundException(String quote_not_found){
        
            super(quote_not_found);
    }
}
