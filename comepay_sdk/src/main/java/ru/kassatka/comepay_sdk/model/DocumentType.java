package ru.kassatka.comepay_sdk.model;

public enum DocumentType {
    SALE((byte) 0),
    RETURN((byte) 2),
    CONSUMPTION((byte) 1),
    CONSUMPTION_RETURN((byte) 3);

    byte code;

    DocumentType(byte code) {
        this.code = code;
    }
}
