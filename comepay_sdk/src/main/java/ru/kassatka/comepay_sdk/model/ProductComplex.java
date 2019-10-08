package ru.kassatka.comepay_sdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ProductComplex implements Parcelable {

    /**
     * Идентификатор товара
     */
    @SerializedName("ExtId")
    private String extId;

    /**
     * Группа товаров
     */
    @SerializedName("Group")
    private String group;

    /**
     * Количество
     */
    @SerializedName("Qty")
    private long qty = -1;

    /**
     * Цена в копейках
     */
    @SerializedName("Price")
    private long price = -1;

    /**
     * Признак способа расчёта
     */
    @SerializedName("PayAttribute")
    private short payAttribute = -1;

    /**
     * Признак предмета расчёта
     */
    @SerializedName("LineAttribute")
    private short lineAttribute = -1;

    /**
     * Код налога
     */
    @SerializedName("TaxId")
    private short taxId = -1;

    /**
     * Признак агента по предмету расчёта
     */
    @SerializedName("AgentModes")
    private byte agentModes;

    /**
     * Наименование товарной позиции
     */
    @SerializedName("Description")
    @NonNull
    private String description;

    /**
     * Код страны происхождения товара
     */
    @SerializedName("CountryOfOrigin")
    @Nullable
    private String countryOfOrigin;

    /**
     * Номер таможенной декларации
     */
    @SerializedName("NumberOfCustomsDeclaration")
    @Nullable
    private String numberOfCustomsDeclaration;


    private ProductComplex() {
    }

    public String getExtId() {
        return extId;
    }

    public String getGroup() {
        return group;
    }

    public long getQty() {
        return qty;
    }

    public long getPrice() {
        return price;
    }

    public short getPayAttribute() {
        return payAttribute;
    }

    public short getLineAttribute() {
        return lineAttribute;
    }

    public short getTaxId() {
        return taxId;
    }

    public byte getAgentModes() {
        return agentModes;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Nullable
    public String getNumberOfCustomsDeclaration() {
        return numberOfCustomsDeclaration;
    }

    public static class Builder {
        ProductComplex productComplex;

        public Builder() {
            productComplex = new ProductComplex();
        }

        /**
         * Установка кода товара
         */
        public Builder setExtId(@NonNull String extId) throws Exception {
            if (Objects.requireNonNull(extId.isEmpty())) {
                throw new Exception("ExtId не должен быть пустым");
            }

            productComplex.extId = extId;
            return this;
        }

        public Builder setGroup(@NonNull String group) throws Exception {
            if (Objects.requireNonNull(group).isEmpty()) {
                throw new Exception("Group не должен быть пустым");
            }

            productComplex.group = group;
            return this;
        }

        /**
         * Количество. Количество указывается в тысячных долях,
         * т.о если необходимо передать количество, например, 2,5 килограмма,
         * то в параметре следует указать 2500 (2,5 · 1000 = 2500)
         */
        public Builder setQty(long qty) {
            productComplex.qty = qty;
            return this;
        }

        /**
         * Цена в копейках
         */
        public Builder setPrice(long price) {
            productComplex.price = price;
            return this;
        }

        /**
         * Признак способа расчёта
         */
        public Builder setPayAttribute(PayAttributesType attribute) {
            productComplex.payAttribute = attribute.code;
            return this;
        }

        /**
         * Признак предмета расчёта
         */
        public Builder setLineAttribute(LineAttribute attribute) {
            productComplex.lineAttribute = attribute.code;
            return this;
        }

        /**
         * Наименование товарной позиции
         * Не может быть нулевым
         */
        public Builder setDescription(@NonNull String description) throws Exception {
            if (Objects.requireNonNull(description.isEmpty())) {
                throw new Exception("Description не должен быть пустым");
            }

            productComplex.description = description;
            return this;
        }

        /**
         * Код налога
         */
        public Builder setTaxId(VatType vatType) {
            productComplex.taxId = vatType.code;
            return this;
        }

        /**
         * Признак агента по предмету расчёта
         */
        public Builder setAgentMode(AgentModes mode) {
            productComplex.agentModes = mode.code;
            return this;
        }

        /**
         * Код страны происхождения товара
         */
        public Builder setCountryOfOrigin(@NonNull String countryOfOrigin) throws Exception {
            if (Objects.requireNonNull(countryOfOrigin).isEmpty()) {
                throw new Exception("CountryOfOrigin не должен быть пустым");
            }

            productComplex.countryOfOrigin = countryOfOrigin;
            return this;
        }

        /**
         * Номер таможенной декларации
         */
        public Builder setNumberOfCustomsDeclaration(String numberOfCustomsDeclaration) throws Exception {
            if (Objects.requireNonNull(numberOfCustomsDeclaration.isEmpty())) {
                throw new Exception("numberOfCustomsDeclaration не должен быть пустым");
            }

            productComplex.numberOfCustomsDeclaration = numberOfCustomsDeclaration;
            return this;
        }

        /**
         * @return {@link ProductComplex } объект для отправки
         * @throws NullPointerException если параметры объекта указаны не верно или отсутсвуют обязательные поля
         */
        public ProductComplex create() throws NullPointerException {
            if (productComplex == null) {
                throw new NullPointerException("Объект не был создан");
            }

            if (Objects.requireNonNull(productComplex.extId).isEmpty()) {
                throw new NullPointerException("Необходимо заполнить идентификатор товара");
            }

            if (Objects.requireNonNull(productComplex.group).isEmpty()) {
                throw new NullPointerException("Необходимо заполнить группу товара");
            }

            if (productComplex.qty <= 0) {
                throw new NullPointerException("Необходимо заполнить количество");
            }

            if (productComplex.price <= 0) {
                throw new NullPointerException("Необходимо заполнить цену");
            }

            if (productComplex.payAttribute == -1) {
                throw new NullPointerException("Необходимо заполнить признак способа расчёта");
            }

            if (productComplex.lineAttribute == -1) {
                throw new NullPointerException("Необходимо заполнить признак предмета расчёта");
            }

            if (productComplex.taxId == -1) {
                throw new NullPointerException("Необходимо заполнить код налога");
            }

            if (productComplex.description.isEmpty()) {
                throw new NullPointerException("Необходимо заполнить наименование товарной позиции");
            }

            return productComplex;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.extId);
        dest.writeString(this.group);
        dest.writeLong(this.qty);
        dest.writeLong(this.price);
        dest.writeInt(this.payAttribute);
        dest.writeInt(this.lineAttribute);
        dest.writeInt(this.taxId);
        dest.writeByte(this.agentModes);
        dest.writeString(this.description);
        dest.writeString(this.countryOfOrigin);
        dest.writeString(this.numberOfCustomsDeclaration);
    }

    protected ProductComplex(Parcel in) {
        this.extId = in.readString();
        this.group = in.readString();
        this.qty = in.readLong();
        this.price = in.readLong();
        this.payAttribute = (short) in.readInt();
        this.lineAttribute = (short) in.readInt();
        this.taxId = (short) in.readInt();
        this.agentModes = in.readByte();
        this.description = in.readString();
        this.countryOfOrigin = in.readString();
        this.numberOfCustomsDeclaration = in.readString();
    }

    public static final Parcelable.Creator<ProductComplex> CREATOR = new Parcelable.Creator<ProductComplex>() {
        @Override
        public ProductComplex createFromParcel(Parcel source) {
            return new ProductComplex(source);
        }

        @Override
        public ProductComplex[] newArray(int size) {
            return new ProductComplex[size];
        }
    };

    @Override
    public String toString() {
        return "ProductComplex{" +
                "extId='" + extId + '\'' +
                ", group='" + group + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", payAttribute=" + payAttribute +
                ", lineAttribute=" + lineAttribute +
                ", taxId=" + taxId +
                ", agentModes=" + agentModes +
                ", description='" + description + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", numberOfCustomsDeclaration='" + numberOfCustomsDeclaration + '\'' +
                '}';
    }

    public static ProductComplex ADVANCE = new ProductComplex();

    public static ProductComplex getAdvance(long price, VatType vatType) {
        ProductComplex advance = new ProductComplex();
        advance.qty = 1000;
        advance.description = "Аванс";
        advance.payAttribute = 3;
        advance.taxId = vatType.code;
        advance.price = price;
        return advance;
    }

    public static ProductComplex getNonOperationIncome(long price) {
        ProductComplex advance = new ProductComplex();
        advance.qty = 1000;
        advance.description = "8";
        advance.lineAttribute = LineAttribute.NON_SALE_INCOME.code;
        advance.taxId = VatType.NONE.code;
        advance.price = price;
        return advance;
    }
}