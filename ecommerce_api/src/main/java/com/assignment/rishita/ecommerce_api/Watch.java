package com.assignment.rishita.ecommerce_api;

import javax.persistence.*;

@Entity
public class Watch {
    //contains get methods of all columns of the database table Watch and a toString method.
    @Id
    private String watchID;
    @Column(name = "WatchName")
    private String watchName;
    @Column(name = "UnitPrice")
    private Integer unitPrice;
    @Column(name = "DiscountVal")
    private Integer discountVal;
    @Column(name = "DiscountQuantity")
    private Integer discountQuantity;

    public Watch() {  }

    public String getWatchID() {
        return watchID;
    }

    public String getWatchName() {
        return watchName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
    public int getDiscountVal() {
        return discountVal;
    }
    public int getDiscountQuantity() {
        return discountQuantity;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "watchID=" + watchID +
                ", watchName=" + watchName + 
                ", unitPrice=" + unitPrice +  
                ", discountVal=" + discountVal +
                ", discountQuantity=" + discountQuantity  +
                '}';
    }
}
