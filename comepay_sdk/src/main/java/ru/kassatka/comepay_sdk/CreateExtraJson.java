package ru.kassatka.comepay_sdk;

import android.content.Context;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;

import ru.kassatka.comepay_sdk.model.ProductItems;


/**
 * Created by sokolov on 06.08.2018.
 */

public final class CreateExtraJson {
    static JsonArray array;

    public static String createJson(JsonObject json, Context context){
        try {
            json.addProperty("PACKAGE", context.getPackageName());
            return new String(json.toString().getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static JsonArray addUUIDS(ArrayList<UUID> items){
        array = new JsonArray();
        for(int i = 0; i <items.size(); i++){
        JsonObject uuid = new JsonObject();
            uuid.addProperty("UUID",items.get(i).toString());
            array.add(uuid);
        }
        return array;
    }

    public static JsonArray createProduct(ArrayList<ProductItems> items){
        array = new JsonArray();
        if (items.size() > 0) {
            try {
                for (ProductItems item : items) {
                    JsonObject productJson = new JsonObject();
                    byte[] ptext = item.name.toString().getBytes("UTF-8");
                    String values = new String(ptext, "UTF-8");
                    productJson.addProperty("Description", values.toString());
                    productJson.addProperty("Group", item.group);
                    productJson.addProperty("ExtId", item.extId);
                    productJson.addProperty("Price", item.price);
                    productJson.addProperty("Qty", item.count);
                    productJson.addProperty("Discount", item.discount);
                    if(item.agentsType != null){
                        switch (item.agentsType) {
                            case BANK_PAY_AGENT:
                                productJson.addProperty("AgentModes", 1);
                                break;
                            case BANK_PAY_SUB_AGENT:
                                productJson.addProperty("AgentModes", 2);
                                break;
                            case PAY_AGENT:
                                productJson.addProperty("AgentModes", 4);
                                break;
                            case PAY_SUB_AGENT:
                                productJson.addProperty("AgentModes", 8);
                                break;
                            case ATTORNEY:
                                productJson.addProperty("AgentModes", 16);
                                break;
                            case COMMISSION_AGENT:
                                productJson.addProperty("AgentModes", 32);
                                break;
                            case AGENT:
                                productJson.addProperty("AgentModes", 64);
                                break;
                        }
                    }
                    if(item.payAttributesType != null){
                        switch (item.payAttributesType) {
                            case TYPE_0:
                                productJson.addProperty("PayAttribute",0);
                                break;
                            case PREPAYMENT_100:
                                productJson.addProperty("PayAttribute",1);
                                break;
                            case PREPAYMENT:
                                productJson.addProperty("PayAttribute",2);
                                break;
                            case ADVANCE:
                                productJson.addProperty("PayAttribute",3);
                                break;
                            case FULL_PAY:
                                productJson.addProperty("PayAttribute",4);
                                break;
                            case PARTIAL_PAY:
                                productJson.addProperty("PayAttribute",5);
                                break;
                            case CREDIT:
                                productJson.addProperty("PayAttribute",6);
                                break;
                            case CREDIT_CLOSING:
                                productJson.addProperty("PayAttribute",7);
                                break;
                        }

                    }
                    if(item.goodType != null){
                        switch (item.goodType) {
                            case PRODUCT:
                                productJson.addProperty("LineAttribute", 1);
                                break;
                            case EXCISABLE_GOODS:
                                productJson.addProperty("LineAttribute", 2);
                                break;
                            case WORK:
                                productJson.addProperty("LineAttribute", 3);
                                break;
                            case SERVICE:
                                productJson.addProperty("LineAttribute", 4);
                                break;
                            case BET_GAMBLING:
                                productJson.addProperty("LineAttribute", 5);
                                break;
                            case WIN_GAMBLING:
                                productJson.addProperty("LineAttribute", 6);
                                break;
                            case LOTTERY_TICKET:
                                productJson.addProperty("LineAttribute", 7);
                                break;
                            case WINNING_LOTTERY:
                                productJson.addProperty("LineAttribute", 8);
                                break;
                            case INTELLECTUAL_PROPERTY_RESULTS:
                                productJson.addProperty("LineAttribute", 9);
                                break;
                            case PAYMENT_OR_PAYOUT:
                                productJson.addProperty("LineAttribute", 10);
                                break;
                            case COMPOSITE:
                                productJson.addProperty("LineAttribute", 11);
                                break;
                            case OTHER:
                                productJson.addProperty("LineAttribute", 12);
                                break;
                        }
                    }
                    switch (item.taxMode) {
                        case DEFAULT:
                            productJson.addProperty("TaxMode", 0);
                            break;

                        case COMMON:
                            productJson.addProperty("TaxMode", 1);
                            break;

                        case SIMPLIFIED_INCOME:
                            productJson.addProperty("TaxMode", 2);
                            break;

                        case SIMPLIFIED_INCOME_OUTCOME:
                            productJson.addProperty("TaxMode", 4);
                            break;

                        case SINGLE_IMPUTED_INCOME:
                            productJson.addProperty("TaxMode", 8);
                            break;

                        case SINGLE_AGRICULTURE:
                            productJson.addProperty("TaxMode", 16);
                            break;

                        case PATENT:
                            productJson.addProperty("TaxMode", 32);
                            break;
                    }
                    if(item.subtotal > 0)
                        productJson.addProperty("SubTotal", item.subtotal);
                    switch (item.vatType){
                        case NONE:
                            productJson.addProperty("TaxId", 4);
                            break;
                        case VAT_0:
                            productJson.addProperty("TaxId", 3);
                            break;
                        case VAT_10:
                            productJson.addProperty("TaxId", 2);
                            break;
                        case VAT_20:
                            productJson.addProperty("TaxId", 1);
                            break;
                    }
                    addProductJson(productJson);
                }

                JsonObject complex = new JsonObject();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    private static void addProductJson(JsonObject jsonObject) {
        array.add(jsonObject);
    }
}
