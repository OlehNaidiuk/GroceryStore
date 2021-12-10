package com.naidiuk.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String localDate) {
        return LocalDate.from(formatter.parse(localDate));
    }

    @Override
    public String marshal(LocalDate localDate) {
        return formatter.format(localDate);
    }
}
