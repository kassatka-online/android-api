package ru.kassatka.comepay_sdk.marking;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.callBack.CallBackMarking;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;

public final class MarkingCommand {
    private Extra extra = new Extra();

    public void sendError( @Nullable Extra extra){
        extra.putExtra("ACTION", "ERROR");
        this.extra = extra;
    }

    public void sendResult( @Nullable Extra extra){
        extra.putExtra("ACTION", "RESULT");
        this.extra = extra;
    }

    public void checkMRC(@Nullable Extra extra){
        extra.putExtra("ACTION", "MRC");
        this.extra = extra;
    }

    public void checkDisposal(@Nullable Extra extra){
        extra.putExtra("ACTION", "DISPOSAL");
        this.extra = extra;
    }

    public void registerAction(@Nullable Extra extra){
        extra.putExtra("ACTION", "REGISTER_ACTION");
        this.extra = extra;
    }

    public void startCommand(Context context, CallBackMarking callBack){

        context.sendBroadcast(new Intent("kassa.action.send.marking.command")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context)));
        CallbackHandler.instance.listeners.put("Marking", callBack);
    }
}
