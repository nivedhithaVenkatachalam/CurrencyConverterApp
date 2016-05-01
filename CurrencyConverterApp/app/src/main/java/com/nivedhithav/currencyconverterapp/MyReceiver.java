package com.nivedhithav.currencyconverterapp;

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
        Log.d("Debug -->", ">> CurrencyConversionApp - OnReceive");

        String action=intent.getAction();
        if(action.equals(MainActivity.CUSTOM_INTENT_REPLY)){
            Log.d("Debug -->", ">> App2 - Received Broadcast = CURRENCY_CONVERSION_REQUEST");
            String converted = intent.getExtras().getString("ConvertedAmount");
            Boolean flag=intent.getExtras().getBoolean("Flag");

            Log.d("Debug -->", ">> converted = " + converted);

            Log.d("Debug -->", ">> Before: MainActivity.converted = " + MainActivity.converted);
            Log.d("Debug -->", ">> Before: MainActivity.flagConverted = " + MainActivity.flagConverted);
            // set the parameters
            MainActivity.converted=converted;
            MainActivity.flagConverted=flag;
            Log.d("Debug -->", ">> After: MainActivity.converted = " + MainActivity.converted);
            Log.d("Debug -->", ">> After: MainActivity.flagConverted = " + MainActivity.flagConverted);
        }

    }
}
