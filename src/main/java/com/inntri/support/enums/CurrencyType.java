package com.inntri.support.enums;

public enum CurrencyType {
    USD("USD", "USD"),
    EUR("EUR", "EUR"),
    GBP("GBP", "GBP"),
    JPY("JPY", "JPY"),
    INR("INR", "INR"),
    LKR("LKR", "LKR"),
    AUD("AUD", "AUD"),
    CAD("CAD", "CAD"),
    CHF("CHF", "CHF"),
    CNY("CNY", "CNY");

    private String label;
    private String value;

    CurrencyType(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getDisplayName() {
        return label;
    }

    public String getCode() {
        return value;
    }

    public static CurrencyType getEnum(String s) {
        for (CurrencyType item : CurrencyType.values()) {
            if (item.value.equals(s)) {
                return item;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
