package com.naidiuk;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private final DateTimeFormatter formatter;

    public LocalDateTimeAdapter() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'T' HH:mm:ss");
    }

    @Override
    public LocalDateTime unmarshal(String dateTime) {
        return LocalDateTime.from(formatter.parse(dateTime));
    }

    @Override
    public String marshal(LocalDateTime localDateTime) {
        return formatter.format(localDateTime);
    }
}
