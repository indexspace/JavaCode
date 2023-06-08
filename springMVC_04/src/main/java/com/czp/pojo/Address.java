package com.czp.pojo;

public class Address {
    private int code;
    private String value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "code=" + code +
                ", value='" + value + '\'' +
                '}';
    }

    public Address() {
    }

    public Address(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
