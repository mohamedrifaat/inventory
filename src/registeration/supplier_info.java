/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

/**
 *
 * @author ahmed khaled
 */
public class supplier_info {
      private String  id;
    private String name;
    private String telephone;

    public supplier_info(String name, String id,String telephone) {
        this.name = name;
        this.id = id;
        this.telephone=telephone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    
}
