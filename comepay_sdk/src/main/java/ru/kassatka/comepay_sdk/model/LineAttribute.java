package ru.kassatka.comepay_sdk.model;

public enum LineAttribute {

    PRODUCT((short) 1, "ТОВАР"),
    EXCISABLE_GOODS((short) 2, "ПОДАКЦИЗНЫЙ ТОВАР"),
    WORK((short) 3, "РАБОТА"),
    SERVICE((short) 4, "УСЛУГА"),
    BET_GAMBLING((short) 5, "СТАВКА АЗАРТНОЙ ИГРЫ"),
    WIN_GAMBLING((short) 6, "ВЫИГРЫШ АЗАРТНОЙ ИГРЫ"),
    LOTTERY_TICKET((short) 7, "ЛОТЕРЕЙНЫЙ БИЛЕТ"),
    WINNING_LOTTERY((short) 8, "ВЫИГРЫШ ЛОТЕРЕИ"),
    INTELLECTUAL_PROPERTY_RESULTS((short) 9, "ПРЕДОСТАВЛЕНИЕ РИД"),
    PAYMENT_OR_PAYOUT((short) 10, "ПЛАТЕЖ ИЛИ ВЫПЛАТА"),
    AGENT_S_COMMISSION((short) 11, "АГЕНТСКОЕ ВОЗНАГРАЖДЕНИЕ"),
    COMPOSITE((short) 12, "СОСТАВНОЙ ПРЕДМЕТ РАСЧЕТА"),
    OTHER((short) 13, "ИНОЙ ПРЕДМЕТ РАСЧЕТА"),
    PROPERTY_LAW((short) 14, "ИМУЩЕСТВЕННОЕ ПРАВО"),
    NON_SALE_INCOME((short) 15, "ВНЕРЕАЛИЗАЦИОННЫЙ ДОХОД"),
    INSURANCE_CONTRIBUTIONS((short) 16, "СТРАХОВЫЕ ВЗНОСЫ"),
    TRADE_FEE((short) 17, "ТОРГОВЫЙ СБОР"),
    RESORT_FEE((short) 18, "КУРОРТНЫЙ СБОР"),
    PLEDGE((short) 19, "ЗАЛОГ");

    public final short code;
    public final String name;

    LineAttribute(short code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}