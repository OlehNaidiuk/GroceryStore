package com.naidiuk;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;

class StoreServiceTest {
    private final Store varus = new Store("Varus", 3252213, BigDecimal.valueOf(1470), StoreType.AVERAGE,
            LocalDate.of(2015, 12, 10));
    private final Product roach = new Product("Плотва", BigDecimal.valueOf(235.70), 234123, DepartmentType.FISHY,
            LocalDateTime.of(2022, 5, 5, 0, 0, 0), Currency.UAH);
    private final Product stellaArtois = new Product("Stella Artois", BigDecimal.valueOf(0.963), 325234,
            DepartmentType.ALCOHOL, LocalDateTime.of(2022, 5, 5, 0, 0, 0),
            Currency.USD);
    private final Product jerky = new Product("обJerky", BigDecimal.valueOf(83.10), 123124, DepartmentType.BUTCHERY,
            LocalDateTime.of(2022, 1, 5, 0, 0, 0), Currency.UAH);
    private final Product lazyCow = new Product("Сливки-ленивки", BigDecimal.valueOf(139.99), 423421,
            DepartmentType.SWEETS, LocalDateTime.of(2022, 12, 5, 0, 0, 0),
            Currency.UAH);
    private final Product donut = new Product("Донатс", BigDecimal.valueOf(14.90), 152827, DepartmentType.BAKERY,
            LocalDateTime.of(2021, 12, 5, 23, 59, 59),
            Currency.UAH);
    private final StoreService storeService = new StoreService();

    @BeforeEach
    void setup() {
        varus.addProduct(roach);
        varus.addProduct(stellaArtois);
        varus.addProduct(jerky);
        varus.addProduct(lazyCow);
        varus.addProduct(donut);
    }

    @Test
    void writeStoreToJsonFormatTest() {
        //when
        storeService.writeStoreToJsonFormat(varus);

        //then
        assertTrue(Files.exists(Path.of("src/test/resources/Store.json")));
    }

    @Test
    void readStoreFromJsonFormatTest() {
        //when
        Store store = storeService.readStoreFromJsonFormat();

        //then
        assertEquals(store.getName(), varus.getName());
        assertEquals(store.getId(), varus.getId());
        assertEquals(store.getSquare(), varus.getSquare());
        assertEquals(store.getStoreType(), varus.getStoreType());
        assertEquals(store.getOpeningDate(), varus.getOpeningDate());
        assertTrue(store.getProduct().retainAll(varus.getProduct()));
    }

    @Test
    void writeStoreToXmlFormatTest() {
        //when
        storeService.writeStoreToXmlFormat(varus);

        //then
        assertTrue(Files.exists(Path.of("src/test/resources/Store.xml")));
    }

    @Test
    void readStoreFromXmlFormatTest() {
        //when
        Store store = storeService.readStoreFromXmlFormat();

        //then
        assertEquals(store.getName(), varus.getName());
        assertEquals(store.getId(), varus.getId());
        assertEquals(store.getSquare(), varus.getSquare());
        assertEquals(store.getStoreType(), varus.getStoreType());
        assertEquals(store.getOpeningDate(), varus.getOpeningDate());
        assertTrue(store.getProduct().retainAll(varus.getProduct()));
    }
}
