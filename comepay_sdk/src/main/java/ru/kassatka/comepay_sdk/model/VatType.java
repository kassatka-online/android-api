package ru.kassatka.comepay_sdk.model;

public enum VatType {
    VAT_20((short) 1, "НДС 20%"),
    VAT_10((short) 2, "НДС 10%"),
    VAT_0((short) 3, "НДС 0%"),
    NONE((short) 4, "Без налога"),
    VAT_10_110((short) 5, "Ставка 20/120"),
    VAT_20_120((short) 6, "Ставка 10/110");

    short code;
    String name;

    VatType(short code, String name) {
        this.code = code;
        this.name = name;
    }
}