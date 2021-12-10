package com.naidiuk.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime unmarshal(String dateTime) {
        return LocalDateTime.from(formatter.parse(dateTime));
    }

    @Override
    public String marshal(LocalDateTime localDateTime) {
        return formatter.format(localDateTime);
    }
}
