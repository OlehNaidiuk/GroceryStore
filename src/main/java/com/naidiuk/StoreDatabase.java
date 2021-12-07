package com.naidiuk;

import java.nio.file.Path;

public class StoreDatabase {
    private final Path pathToJson = Path.of("src/test/resources/Store.json");
    private final Path pathToXml = Path.of("src/test/resources/Store.xml");

    public Path getPathToJson() {
        return pathToJson;
    }

    public Path getPathToXml() {
        return pathToXml;
    }
}
