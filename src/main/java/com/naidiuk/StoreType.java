package com.naidiuk;

public enum StoreType {
    BIG("Гипермаркет"),
    AVERAGE("Супермаркет"),
    SMALL("Гастроном");

    private final String translation;

    StoreType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
