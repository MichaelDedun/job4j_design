package ru.job4j.srp.enums;

public enum Type {
    Dollar("dollar", 69.27),
    Euro("euro", 77.62);

    private String value;
    private Double rate;

    Type(String value, Double rate) {
        this.value = value;
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }


}
