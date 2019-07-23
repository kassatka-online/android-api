package ru.kassatka.comepay_sdk;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;


/**
 * Created by sokolov on 08.08.2018.
 */

public class PrintCommand {
    private Extra extra;

    public void printString(@Nullable Extra extra) {
        this.extra = extra;
    }

    public void printEmtyString(@Nullable Extra extra){
        this.extra = extra;
    }

    public void printStringAfterCheck(@Nullable Extra extra){
        this.extra = extra;
    }

    public void printStringBeforeCheck(@Nullable Extra extra){
        this.extra = extra;
    }

    public void startCommand(Context context, CallBack callBack){
        CallbackHandler.instance.listeners.put("Print", callBack);
        context.sendBroadcast(new Intent("kassa.action.send.print.command").
                putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context))
        );
    }
    public void startCommand(Context context){
        context.sendBroadcast(new Intent("kassa.action.send.print.command").
                putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context))
        );
    }
}
