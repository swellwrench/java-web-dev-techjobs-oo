package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType {
    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType() {
        id = nextId;
        nextId++;
    }

    public PositionType(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType positionType = (PositionType) o;
        return getId() == positionType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
