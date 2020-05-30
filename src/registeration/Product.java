/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import java.sql.Date;

/**
 *
 * @author ahmed khaled
 */
class Product {
    private int price;
    private String name;
    private String expire_date;

    public Product(int price, String name,String expire_date) {
        this.price = price;
        this.name = name;
        this.expire_date=expire_date;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getExpire_date() {
        return expire_date;
    }
    
}
