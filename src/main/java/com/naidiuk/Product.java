package com.naidiuk;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

    private String name;
    private BigDecimal price;
    private int id;
    private DepartmentType departmentType;
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private @JsonFormat(pattern = "dd-MM-yyyy 'T' HH:mm:ss")
    LocalDateTime expirationDate;
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

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'T' HH:mm:ss");
        return "{Name: " + name + ", " +
                "Price: " + price + ", " +
                "Id: " + id + ", " +
                "Department type: " + departmentType + ", " +
                "Expiration date: " + formatter.format(expirationDate) + ", " +
                "Currency: " + currency + "}\n";
    }
}
