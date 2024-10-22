package main.java.week_17_no_algo.equal_hashCode;

import java.util.Objects;

public class Money {
    private final String currency;
    private final int value;


    public Money(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
}
