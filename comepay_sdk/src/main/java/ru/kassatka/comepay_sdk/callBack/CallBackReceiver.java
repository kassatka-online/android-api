package ru.kassatka.comepay_sdk.callBack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by sokolov on 09.08.2018.
 */

public class CallBackReceiver extends BroadcastReceiver {
    public static final String Check = "sdk.action.call.back.check";
    public static final String CheckClose = "ru.kassa.action.close.check";
    public static final String Report= "sdk.action.call.back.shift.report";
    public static final String Status = "sdk.action.call.back.shift.status";
    public static final String Print = "sdk.action.call.back.print";
    public static final String Discount = "sdk.action.call.back.discount";
    public static final String ShiftClose = "ru.kassa.action.check.close";
    public static final String ShiftCloseError = "ru.kassa.action.check.print.error";
    public static final String StatusDevice = "action.get.device.status";
    public static final String StatusOFD = "action.get.ofd.status";
    CallbackListener listener;
    ShiftCallBack statusListener;
    StatusPrint statusPrint = new StatusPrint();


    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(TextUtils.isEmpty(action)) return;
        Bundle bundle = intent.getExtras();
        switch (action) {
//            case StatusDevice:
//                ShiftInfoCallBack shiftInfo = (ShiftInfoCallBack) CallbackHandler.instance.listeners.get("ShiftInfo");
//                shiftInfo.getStatus( new ShiftInfo(intent.getStringExtra("printerStatus"),intent.getStringExtra("CheckCount"),  intent.getBooleanExtra("isOpen", false)));
//                break;
//            case StatusOFD:
//                OFDCallBack ofdCallBack = (OFDCallBack) CallbackHandler.instance.listeners.get("OFDInfo");
//                ofdCallBack.getStatus( new OFDInfo(intent.getStringExtra("Date"), intent.getStringExtra("CheckCount")));
//                break;

            case ShiftCloseError:
                 statusListener = (ShiftCallBack) CallbackHandler.instance.listeners.get("Shift");
                 statusPrint = new StatusPrint();

                 if(intent.hasExtra("ErrorMessage"))
                    statusPrint.error = intent.getStringExtra("ErrorMessage");

                statusPrint.status = "Не успешно";
                //statusListener.(statusPrint);
                break;

            case ShiftClose:
                 statusListener = (ShiftCallBack) CallbackHandler.instance.listeners.get("Shift");
                 statusPrint = new StatusPrint();
                 statusPrint.error="";
                 statusPrint.status = "Успешно";
                // statusListener.getStatus(statusPrint);

                break;
            case CheckClose:
                CallBackCloseCheck callBackCloseCheck = (CallBackCloseCheck) CallbackHandler.instance.listeners.get("Check");
                 statusPrint = new StatusPrint();
                if(intent.hasExtra("Error"))
                    statusPrint.error = intent.getStringExtra("Error");

                if(intent.hasExtra("ID"))
                    statusPrint.id = intent.getLongExtra("ID", -1);

                if(intent.hasExtra("CheckId"))
                    statusPrint.checkID = intent.getLongExtra("CheckId", -1);

                if(intent.hasExtra("Text"))
                    statusPrint.text = intent.getStringExtra("Text");

                if(intent.hasExtra("QR"))
                    statusPrint.qr = intent.getStringExtra("QR");

                if(intent.hasExtra("DOC_TYPE"))
                    statusPrint.docType = intent.getStringExtra("DOC_TYPE");

                if(intent.hasExtra("Status"))
                    statusPrint.status = intent.getStringExtra("Status");
                callBackCloseCheck.getStatus(statusPrint);
                break;
            case Check:
                listener = (CallbackListener) CallbackHandler.instance.listeners.get("Check");

                if(bundle.getInt("ErrorCode") == 0){
                    listener.OnSuccess( bundle.getString("Response"));
                }else {
                    listener.OnError(bundle.getInt("ErrorCode"), bundle.getString("ErrorMessage"));
                }
                break;
            case Report:
                CallBackPrint reportListener = (CallBackPrint) CallbackHandler.instance.listeners.get("Shift");
                reportListener.result(bundle.getBoolean("PrintReport"));
                break;
            case Status:
                statusListener = (ShiftCallBack) CallbackHandler.instance.listeners.get("Shift");
                statusListener.OnSuccess( bundle.getLong("Shift"), bundle.getBoolean("IsOpen"));
                statusListener.OnError(bundle.getString("Error"));
                break;
            case Print:
                CallBackPrint printListener = (CallBackPrint) CallbackHandler.instance.listeners.get("Print");
                printListener.result(bundle.getBoolean("IsPrint"));
                break;
            case Discount:
                DiscountCallBack discountCallBack = (DiscountCallBack) CallbackHandler.instance.listeners.get("Discount");
                discountCallBack.OnSuccess(intent.getExtras().getBoolean("IsSetDiscount"));
                discountCallBack.OnError(intent.getExtras().getString("Error"));
                break;
        }
    }
}
