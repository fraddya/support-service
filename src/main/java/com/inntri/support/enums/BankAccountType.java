package com.inntri.support.enums;

public enum BankAccountType {
    SAVINGS("SAV", "Savings"),
    CURRENT("CUR", "Current");


    private String label;
    private String value;

    BankAccountType(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static BankAccountType getEnum(String s) {
        for (BankAccountType item : BankAccountType.values()) {
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
