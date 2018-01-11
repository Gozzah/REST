/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Peter Riis
 */
public class Quote {

    public Quote() {
    }

    public Quote(String quote) {
        this.quote = quote;
    }
    
    public Quote(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }
    
    int id;
    String quote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
    
}
