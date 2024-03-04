package org.exhandl.homework3.data;

public class Attribute {

    private AttributeType type;
    private String value;

    public Attribute() {
    }

    public Attribute(AttributeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
