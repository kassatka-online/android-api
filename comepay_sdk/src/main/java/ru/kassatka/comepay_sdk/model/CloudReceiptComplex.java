package ru.kassatka.comepay_sdk.model;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CloudReceiptComplex extends ReceiptComplex {

    private CloudReceiptComplex() {
    }

    private Map<String, String> looseLines = new LinkedHashMap<>();

    public Map<String, String> getLooseLines() {
        return looseLines;
    }

    public static class Builder {
        CloudReceiptComplex receipt;

        public Builder() {
            receipt = new CloudReceiptComplex();
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

        private void setLine(String key, String value) {
            if (Objects.requireNonNull(key).isEmpty()) {
                throw new RuntimeException("Key must be non null and not empty");
            }

            if (Objects.requireNonNull(value).isEmpty()) {
                throw new RuntimeException("Key must be non null and not empty");
            }

            receipt.looseLines.put(key, value);
        }

        public Builder setLooseLine(String key, String value) {
            setLine(key, value);
            return this;
        }

        public Builder setLooseLines(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }

            receipt.looseLines.putAll(map);
            return this;
        }

        public CloudReceiptComplex create() throws Exception {

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
        super.writeToParcel(dest, flags);
        dest.writeInt(this.looseLines.size());
        for (Map.Entry<String, String> entry : this.looseLines.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    protected CloudReceiptComplex(Parcel in) {
        super(in);
        int looseLinesSize = in.readInt();
        this.looseLines = new LinkedHashMap<>(looseLinesSize);
        for (int i = 0; i < looseLinesSize; i++) {
            String key = in.readString();
            String value = in.readString();
            this.looseLines.put(key, value);
        }
    }

    public static final Creator<CloudReceiptComplex> CREATOR = new Creator<CloudReceiptComplex>() {
        @Override
        public CloudReceiptComplex createFromParcel(Parcel source) {
            return new CloudReceiptComplex(source);
        }

        @Override
        public CloudReceiptComplex[] newArray(int size) {
            return new CloudReceiptComplex[size];
        }
    };
}
