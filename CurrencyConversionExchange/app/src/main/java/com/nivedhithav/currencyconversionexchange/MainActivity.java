package com.nivedhithav.currencyconversionexchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_INTENT_REQ = "nivedhitha.custom.intent.action.CONVERSION_REQUEST";
    public static final String CUSTOM_INTENT_REPLY = "nivedhitha.custom.intent.action.CONVERSION_REPLY";

    public static String currencyType="Type";
    public static double amount=0;

    TextView get1;
    TextView get2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get1=(TextView) findViewById(R.id.amount);
        get2=(TextView) findViewById(R.id.currencyType);

    }

    protected void onResume(){
        super.onResume();

        get1.setText(String.valueOf(amount));
        get2.setText(currencyType);

    }

    public void apply(View v){
        Log.d("Debug2 -->", "Apply Button was pressed.");
        String ct=currencyType;
        double amount= MainActivity.amount;
        if(ct.equals("Euro"))
            amount=amount*0.91;
        else if(ct.equalsIgnoreCase("Indian Rupee"))
            amount=amount*67.32;
        else if(ct.equalsIgnoreCase("British Pound"))
            amount=amount*0.71;
        Log.d("Apply","Working");
        Log.d("Debug2 -->", "amount = "+amount);
        Intent intent= new Intent(MainActivity.CUSTOM_INTENT_REPLY);

        intent.putExtra("ConvertedAmount",String.valueOf(amount));
        intent.putExtra("Flag",true);

        Log.d("Debug2 -->", "Before Currency exchange sendBroadcast()");
        sendBroadcast(intent);
        Log.d("Debug2 -->", "After Currency exchange sendBroadcast()");


    }

    public void close(View v) {

        MainActivity.this.finish();
    }
}
