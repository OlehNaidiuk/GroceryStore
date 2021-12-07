package com.naidiuk;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Store implements Serializable {

    private String name;
    private int id;
    private BigDecimal square;
    private StoreType storeType;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate openingDate;
    @XmlElementWrapper(name = "products")
    private final List<Product> product = new ArrayList<>();

    public Store() {
    }

    public Store(String name, int id, BigDecimal square, StoreType storeType, LocalDate openingDate) {
        this.name = name;
        this.id = id;
        this.square = square;
        this.storeType = storeType;
        this.openingDate = openingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSquare() {
        return square;
    }

    public void setSquare(BigDecimal square) {
        this.square = square;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void addProduct(Product product) {
        this.product.add(product);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "{Name: " + name + ", " +
                "Id: " + id + ", " +
                "Square: " + square + ", " +
                "Store type: " + storeType + ", " +
                "Opening date: " + formatter.format(openingDate) + ", " +
                "Products: \n" + product + "}\n";
    }
}
