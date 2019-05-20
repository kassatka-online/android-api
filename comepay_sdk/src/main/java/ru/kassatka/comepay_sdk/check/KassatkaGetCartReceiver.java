package ru.kassatka.comepay_sdk.check;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.model.ProductItems;

public class KassatkaGetCartReceiver extends BroadcastReceiver {
    public static final String JSON_LIST_ITEMS= "JSON_PRODUCTS";
    public static final String JSON_ITEM = "JSON_PRODUCT";
    public String packageName = "PACKAGE_NAME";
    public static final String PACKAGE_NAME = "PACKAGE_NAME";
    public static final String COMMAND = "kassa.action.send.get.cart.command";

    public String RESEIVE_ITEMS = "ru.kassa.cart.";

    Listener listener;

    public KassatkaGetCartReceiver(Listener listener, String packageName){
        this.listener = listener;
        this.packageName = packageName;
        RESEIVE_ITEMS +=packageName;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action.equals(RESEIVE_ITEMS)){
                String jsonListItems = intent.getStringExtra(JSON_LIST_ITEMS);
                listener.receiveItems(CreateExtraJson.DeserializeJsomStringToListItems(jsonListItems));
        }
    }

    public interface Listener{
        void receiveItems(ArrayList<ProductItems> items);
    }

}
