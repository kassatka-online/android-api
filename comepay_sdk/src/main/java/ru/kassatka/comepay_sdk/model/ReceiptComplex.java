package ru.kassatka.comepay_sdk.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReceiptComplex implements Parcelable {

    @SerializedName("DocumentType")
    protected byte documentType = -1;

    @SerializedName("Cash")
    protected long cash = 0;

    @SerializedName("NonCash")
    protected long nonCash = 0;

    @SerializedName("AdvancePayment")
    protected long advancePayment = 0;

    @SerializedName("Credit")
    protected long credit = 0;

    @SerializedName("Consideration")
    protected long consideration = 0;

    @SerializedName("PhoneOrEmail")
    @Nullable
    protected String phoneOrEmail;

    @SerializedName("CustomerName")
    @Nullable
    protected String customerName;

    @SerializedName("CustomerINN")
    @Nullable
    protected String customerINN;

    protected List<ProductComplex> productComplexes;

    protected ReceiptComplex() {
    }

    public byte getDocumentType() {
        return documentType;
    }

    public long getCash() {
        return cash;
    }

    public long getNonCash() {
        return nonCash;
    }

    public long getAdvancePayment() {
        return advancePayment;
    }

    public long getCredit() {
        return credit;
    }

    public long getConsideration() {
        return consideration;
    }

    @Nullable
    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    @Nullable
    public String getCustomerName() {
        return customerName;
    }

    @Nullable
    public String getCustomerINN() {
        return customerINN;
    }

    public List<ProductComplex> getProductComplexes() {
        return productComplexes;
    }

    public static class Builder {
        ReceiptComplex receipt;

        public Builder() {
            receipt = new ReceiptComplex();
            receipt.productComplexes = new ArrayList<>();
        }

        public Builder setDocumentType(DocumentType documentType) {
            receipt.documentType = documentType.code;
            return this;
        }

        public Builder setCash(long cash) {
            if (cash <= 0) {
                throw new RuntimeException("cash must be more 0");
            }

            receipt.cash = cash;
            return this;
        }

        public Builder setNonCash(long nonCash) {
            if (nonCash < 0) {
                throw new RuntimeException("nonCash must be more 3");
            }

            receipt.nonCash = nonCash;
            return this;
        }

        public Builder setAdvancePayment(long advancePayment) {
            if (advancePayment <= 0) {
                throw new RuntimeException("AdvancePayment must be more 0");
            }

            receipt.advancePayment = advancePayment;
            return this;
        }

        public Builder setCredit(long credit) {
            if (credit <= 0) {
                throw new RuntimeException("Credit must be more 0");
            }

            receipt.credit = credit;
            return this;
        }

        public Builder setConsideration(long consideration) {
            if (consideration <= 0) {
                throw new RuntimeException("Consideration must be more 0");
            }

            receipt.consideration = consideration;
            return this;
        }

        public Builder setPhoneOrEmail(String phoneOrEmail) {
            if (Objects.requireNonNull(phoneOrEmail).isEmpty()) {
                throw new RuntimeException("PhoneOrEmail must be no null and not Empty ");
            }

            receipt.phoneOrEmail = phoneOrEmail;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            if (Objects.requireNonNull(customerName).isEmpty()) {
                throw new RuntimeException("customerName must be not null");
            }

            receipt.customerName = customerName;
            return this;
        }

        public Builder setCustomerINN(String customerINN) {
            if (Objects.requireNonNull(customerINN).isEmpty()) {
                throw new RuntimeException("customerINN must be not null");
            }

            receipt.customerINN = customerINN;
            return this;
        }

        public Builder setProducts(List<ProductComplex> products) {
            if (Objects.requireNonNull(products).size() == 0) {
                throw new RuntimeException("Size products must be more 0");
            }

            receipt.productComplexes = products;
            return this;
        }

        public ReceiptComplex create() throws Exception {

            if (receipt == null) {
                throw new Exception("Object is not init");
            }

            if (receipt.documentType == -1) {
                throw new Exception("Document type is not init");
            }

            if (receipt.productComplexes.size() == 0) {
                throw new Exception("Size products must be more 0");
            }

            long total = 0;

            total += receipt.cash;

            total += receipt.nonCash;
            total += receipt.advancePayment;
            total += receipt.credit;
            total += receipt.consideration;

            if (total <= 0) {
                throw new Exception("Оплата по чеку должна быть больше 0");
            }

            return receipt;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.documentType);
        dest.writeLong(this.cash);
        dest.writeLong(this.nonCash);
        dest.writeLong(this.advancePayment);
        dest.writeLong(this.credit);
        dest.writeLong(this.consideration);
        dest.writeString(this.phoneOrEmail);
        dest.writeString(this.customerName);
        dest.writeString(this.customerINN);
        dest.writeTypedList(this.productComplexes);
    }

    protected ReceiptComplex(Parcel in) {
        this.documentType = in.readByte();
        this.cash = in.readLong();
        this.nonCash = in.readLong();
        this.advancePayment = in.readLong();
        this.credit = in.readLong();
        this.consideration = in.readLong();
        this.phoneOrEmail = in.readString();
        this.customerName = in.readString();
        this.customerINN = in.readString();
        this.productComplexes = in.createTypedArrayList(ProductComplex.CREATOR);
    }

    public static final Creator<ReceiptComplex> CREATOR = new Creator<ReceiptComplex>() {
        @Override
        public ReceiptComplex createFromParcel(Parcel in) {
            return new ReceiptComplex(in);
        }

        @Override
        public ReceiptComplex[] newArray(int size) {
            return new ReceiptComplex[size];
        }
    };

    @Override
    public String toString() {
        return "ReceiptComplex{" +
                "documentType=" + documentType +
                ", cash=" + cash +
                ", nonCash=" + nonCash +
                ", advancePayment=" + advancePayment +
                ", credit=" + credit +
                ", consideration=" + consideration +
                ", phoneOrEmail='" + phoneOrEmail + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerINN='" + customerINN + '\'' +
                ", productComplexes=" + productComplexes +
                '}';
    }
}