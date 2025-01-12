/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

/**
 *
 * @author Alex
 */
@Entity
@NamedQueries({
    @NamedQuery(name="AutoParts.findById", query="SELECT a FROM AutoParts a WHERE a.id = :id"),
    @NamedQuery(name="AutoParts.findByCategory", query="SELECT a FROM AutoParts a WHERE a.category = :category"),
    @NamedQuery(name="AutoParts.findAll", query="SELECT a FROM AutoParts a"),
    @NamedQuery(name="AutoParts.needOrder", query="SELECT a FROM AutoParts a WHERE a.availability < 10")
})
public class AutoParts implements Serializable {
    
    @Id
    private int id;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;
    private int availability;
    private int itemSolds;
    
    public AutoParts() {}
    
    public AutoParts(int id, String name, Category cat, double price, int avail, int nItems) {
        this.id = id;
        this.name = name;
        this.category = cat;
        this.price = price;
        this.availability = avail;
        this.itemSolds = nItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getItemSolds() {
        return itemSolds;
    }

    public void setItemSolds(int itemSolds) {
        this.itemSolds = itemSolds;
    }

    @Override
    public String toString() {
        return "AutoParts{" + "id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", availability=" + availability + ", itemSolds=" + itemSolds + '}';
    }
    
    
}
