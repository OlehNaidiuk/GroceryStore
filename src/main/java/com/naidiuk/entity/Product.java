package com.naidiuk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.naidiuk.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

    private String name;
    private BigDecimal price;
    private int id;
    private DepartmentType departmentType;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expirationDate;
    private Currency currency;

    public Product() {
    }

    public Product(String name, BigDecimal price, int id, DepartmentType departmentType,
                   LocalDateTime expirationDate, Currency currency) {
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
        this.id = id;
        this.departmentType = departmentType;
        this.expirationDate = expirationDate;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "{Name: " + name + ", " +
                "Price: " + price + ", " +
                "Id: " + id + ", " +
                "Department type: " + departmentType + ", " +
                "Expiration date: " + expirationDate + ", " +
                "Currency: " + currency + "}";
    }
}
