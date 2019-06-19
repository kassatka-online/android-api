package ru.kassatka.comepay_sdk;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;


/**
 * Created by sokolov on 24.07.2018.
 */
//Печать сменных отчетов
public final class ShiftCommand {

    private Extra extra;
    public void PrintXReport(Extra extra){
        extra.putExtra("ACTION", "X_REPORT");
        this.extra = extra;
    }

    public void PrintZReport(Extra extra){
        extra.putExtra("ACTION", "Z_REPORT");
        this.extra = extra;
    }

    public void getStatus(@Nullable Extra extra) {
        this.extra = extra;
    }

    public void startCommand(Context context, CallBack callBack){
        context.sendBroadcast(new Intent("kassa.action.send.shift.command")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context))
        );
        CallbackHandler.instance.listeners.put("Shift", callBack);
    }
}
