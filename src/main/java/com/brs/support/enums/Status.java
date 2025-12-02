package com.brs.support.enums;

public enum Status {

    ACTIVE("ACTIVE","A"),
    DELETED("DELETED","D"),
    TERMINATION("TERMINATION","T"),
    RESIGNATION("RESIGNATION","RES"),
    RETIREMENT("RETIREMENT","RET");
    //(Termination / Resignation / Retirement)

    private final String label;

    private final String value;

    Status(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static Status getEnum(String s) {
        for(Status item:Status.values()) {
            if(item.value.equals(s)) {
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
