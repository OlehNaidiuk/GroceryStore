package com.naidiuk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.naidiuk.util.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Store implements Serializable {

    private String name;
    private int id;
    private BigDecimal square;
    private StoreType storeType;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate openDate;
    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<Product> products;

    public Store() {
    }

    public Store(String name, int id, BigDecimal square, StoreType storeType, LocalDate openingDate) {
        this.name = name;
        this.id = id;
        this.square = square;
        this.storeType = storeType;
        this.openDate = openingDate;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSquare() {
        return square;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "{Name: " + name + ", " +
                "Id: " + id + ", " +
                "Square: " + square + ", " +
                "Store type: " + storeType + ", " +
                "Opening date: " + openDate + ", " +
                "Products: " + products + "}";
    }
}
