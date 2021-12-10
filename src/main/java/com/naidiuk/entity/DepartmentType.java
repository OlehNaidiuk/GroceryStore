package com.naidiuk.entity;

public enum DepartmentType {
    FISHY("Рыбный"),
    ALCOHOL("Алкогольный"),
    BUTCHERY("Мясной"),
    SWEETS("Сладости"),
    BAKERY("Выпечка");

    private final String translation;

    DepartmentType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
