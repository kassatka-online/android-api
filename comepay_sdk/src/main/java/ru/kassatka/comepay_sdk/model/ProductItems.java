package ru.kassatka.comepay_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sokolov on 23.07.2018.
 */

public  class ProductItems {

    public String name;

    public String barcode;
    public String group;
    public int color;
    public int priority;
    public int count;
    public int subtotal;
    public boolean freePrice = false;
    public boolean freeSale = false;
    public VatType vatType = VatType.NONE;
    public double price = 0.0;
    public String unit;
    public boolean isFavorite;
    public byte agentType;
    public GoodAttributesType goodAttributesType;
    public boolean isRemaindersControl;
    public double currentRemainders;
    public double discount;
    //Система налогобложения
    public TaxMode taxMode = TaxMode.DEFAULT;
    public ProductType productType;
    public GoodAttributesType goodType;
    public PayAttributesType payAttributesType;
    public AgentType agentsType;
    public double alcoholByVolume; //Крепость.
    public long alcoholProductKindCode; //Код вида продукции ФСРАР.
    public double tareVolume; //Объём тары.
    //Id в кабинете
    public String extId;

    public ProductItems(){}

    public ProductItems(JSONObject object) throws JSONException {
        name = object.getString("Name");
        extId = object.getString("ExtId");
        group = object.getString("Group");
        price = object.getDouble("Price");
        try{
            count = object.getInt("Qty");
        }catch (Exception e){

        }
    }

    public enum AgentType {
        NONE,
        BANK_PAY_AGENT,
        BANK_PAY_SUB_AGENT,
        PAY_AGENT,
        PAY_SUB_AGENT,
        ATTORNEY,
        COMMISSION_AGENT,
        AGENT;
    }

    public enum PayAttributesType {

        TYPE_0((short) 0, ""), //Для индивидуальных предпринимателей, являющихся налого- плательщиками, применяющими патентную систему налогооб- ложения и упрощённую систему налогообложения, а также ин- дивидуальных предпринимателей, применяющих систему нало- гообложения для сельскохозяйственных товаропроизводителей, систему налогообложения в виде единого налога на вменённый доход для отдельных видов деятельности при осуществлении видов предпринимательской деятельности, установленных пунк- том 2 статьи 346.26 Налогового кодекса Российской Федерации, за исключением индивидуальных предпринимателей, осуществ- ляющих торговлю подакцизными товарами, требование об обя- зательном включении в состав кассового чека и БСО реквизитаприменяется с 1 февраля 2021 года.
        PREPAYMENT_100((short) 1, "Предоплата 100%"), //  Полная предварительная оплата до момента передачи предмета расчёта
        PREPAYMENT((short) 2, "Предоплата"), //Частичная предварительная оплата до момента передачи пред-мета расчёта
        ADVANCE((short) 3, "Аванс"), //Аванс
        FULL_PAY((short) 4, "Полный расчет"), //Полная оплата, в том числе с учётом аванса (предварительной оплаты) в момент передачи предмета расчёта
        PARTIAL_PAY((short) 5, "Частичный расчет и кредит"), //Частичная оплата предмета расчёта в момент его передачи с по- следующей оплатой в кредит
        CREDIT((short) 6, "Передача в кредит"), //Передача предмета расчёта без его оплаты в момент его передачи с последующей оплатой в кредит
        CREDIT_CLOSING((short) 7, "Оплата кредита"); //Оплата предмета расчёта после его передачи с оплатой в кредит (оплата кредита). Этот признак должен быть единственным в документе и документ с этим признаком может содержать только одну строку.

        public final short id;
        public final String name;

        PayAttributesType(short id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }


    public enum GoodAttributesType {

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
        OTHER((short) 13, "ИНОЙ ПРЕДМЕТ РАСЧЕТА");

        public final short id;
        public final String name;

        GoodAttributesType(short id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public enum ProductType {
        NORMAL, //Продукт
        ALCOHOL_MARKED, //Алкоголь с маркой
        ALCOHOL_NOT_MARKED, //Алкоголь без марки
        SERVICE //Услуга
    }

    public enum TaxMode {
        DEFAULT, //по умолчанию (0)
        COMMON, //Общая(1)
        SIMPLIFIED_INCOME, //    Упрощённая доход(2)
        SIMPLIFIED_INCOME_OUTCOME, //Упрощённая доход минус расход(4)
        SINGLE_IMPUTED_INCOME, //Единый налог на вменённый доход(8)
        SINGLE_AGRICULTURE, //Единый сельскохозяйственный налог(16)
        PATENT // Патентная система налогообложения(32)
    }




    public enum GoodAttributesType {
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
        OTHER((short) 13, "ИНОЙ ПРЕДМЕТ РАСЧЕТА");

        public final short id;
        public final String name;

        GoodAttributesType(short id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    public enum VatType {
        NONE,
        VAT_0,
        VAT_10,
        VAT_20;
    }
}


