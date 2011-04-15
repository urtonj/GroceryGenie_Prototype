package com.groceryadvance.grocerygeine;
public class ListItem {
    private String name;
    private String quantity;
    
    public ListItem(String name, String quantity) {
            super();
            this.name = name;
            this.quantity = "( Items: " + quantity + " )";
    }

    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public String getQuantity() {
            return quantity;
    }
    public void setQuantity(String quant) {
            this.quantity = quant;
    }

}