package com.naidiuk.service;

import static org.junit.jupiter.api.Assertions.*;

import com.naidiuk.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<Product> products = new ArrayList<>();
        products.add(roach);
        products.add(stellaArtois);
        products.add(jerky);
        products.add(lazyCow);
        products.add(donut);
        varus.setProducts(products);
    }

    @Test
    void testWriteStoreToJsonFormat() {
        //when
        storeService.writeStoreToJsonFormat(varus);

        //then
        assertTrue(Files.exists(Path.of("src/test/resources/Store.json")));
    }

    @Test
    void testReadStoreFromJsonFormat() {
        //when
        Store store = storeService.readStoreFromJsonFormat();

        //then
        assertEquals(store.getName(), varus.getName());
        assertEquals(store.getId(), varus.getId());
        assertEquals(store.getSquare(), varus.getSquare());
        assertEquals(store.getStoreType(), varus.getStoreType());
        assertEquals(store.getOpenDate(), varus.getOpenDate());
        assertTrue(store.getProducts().retainAll(varus.getProducts()));
    }

    @Test
    void testWriteStoreToXmlFormat() {
        //when
        storeService.writeStoreToXmlFormat(varus);

        //then
        assertTrue(Files.exists(Path.of("src/test/resources/Store.xml")));
    }

    @Test
    void testReadStoreFromXmlFormat() {
        //when
        Store store = storeService.readStoreFromXmlFormat();

        //then
        assertEquals(store.getName(), varus.getName());
        assertEquals(store.getId(), varus.getId());
        assertEquals(store.getSquare(), varus.getSquare());
        assertEquals(store.getStoreType(), varus.getStoreType());
        assertEquals(store.getOpenDate(), varus.getOpenDate());
        assertTrue(store.getProducts().retainAll(varus.getProducts()));
    }
}
