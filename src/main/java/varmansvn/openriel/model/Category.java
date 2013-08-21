/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varmansvn.openriel.model;

import java.io.Serializable;

/**
 *
 * @author varmansvn
 */
public class Category implements Serializable {
    
    private String name;
    
    private String desc;
    
    public Category() {}
    
    public Category(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
}
