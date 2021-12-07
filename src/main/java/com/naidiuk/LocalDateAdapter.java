package com.naidiuk;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private final DateTimeFormatter formatter;

    public LocalDateAdapter() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    @Override
    public LocalDate unmarshal(String dateTime) {
        return LocalDate.from(formatter.parse(dateTime));
    }

    @Override
    public String marshal(LocalDate localDate) {
        return formatter.format(localDate);
    }
}
