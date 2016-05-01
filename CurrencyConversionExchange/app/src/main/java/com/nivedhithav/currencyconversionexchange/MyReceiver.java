package com.nivedhithav.currencyconversionexchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {


    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("Debug2 -->", ">> CurrencyConversionExchange - OnReceive");

        String action=intent.getAction();
        if(action.equals(MainActivity.CUSTOM_INTENT_REQ)){
            Log.d("Debug2 -->", ">> App2 - Received Broadcast = CURRENCY_CONVERSION_REQUEST");
            String currencyType = intent.getExtras().getString("CurrencyType");
            String amount_s = intent.getExtras().getString("Amount");


            Log.d("Debug2 -->", ">> local_cust_id = " + currencyType);
            Log.d("Debug2 -->", ">> local num_string = " + amount_s);

            Log.d("Debug2 -->", ">> Before: MainActivity.currencyType = " + MainActivity.currencyType);
            Log.d("Debug2 -->", ">> Before: MainActivity.amount = " + amount_s);

            // set the parameters
            MainActivity.currencyType=currencyType;
            MainActivity.amount=Double.parseDouble(amount_s);

            Log.d("Debug2 -->", ">> MainActivity.currencyType = " + MainActivity.currencyType);
            Log.d("Debug2 -->", ">> MainActivity.amount = " + amount_s);
        }
    }
}
