package ru.kassatka.comepay_sdk.model;

public enum TaxMode {
    DEFAULT((short) 0, "По умолчанию"), //по умолчанию (0)
    COMMON((short) 1, "Общая"), //Общая(1)
    SIMPLIFIED_INCOME((short) 2, "Упрощённая доход"), //    Упрощённая доход(2)
    SIMPLIFIED_INCOME_OUTCOME((short) 4, "Упрощённая доход минус расход"), //Упрощённая доход минус расход(4)
    SINGLE_IMPUTED_INCOME((short) 8, "Единый налог на вменённый доход"), //Единый налог на вменённый доход(8)
    SINGLE_AGRICULTURE((short) 16, "Единый сельскохозяйственный налог"), //Единый сельскохозяйственный налог(16)
    PATENT((short) 32, "Патентная система налогообложения"); // Патентная система налогообложения(32)

    short code;
    String name;

    TaxMode(short code, String name) {
        this.code = code;
        this.name = name;
    }
}