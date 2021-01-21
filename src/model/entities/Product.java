package model.entities;

/**
 *
 * @author Joao
 */
public class Product {
    
    private String nameItem;
    private Double price;
    
    public Product() {
    }
    
    public Product(String nameItem, Double price) {
        this.nameItem = nameItem;
        this.price = price;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
