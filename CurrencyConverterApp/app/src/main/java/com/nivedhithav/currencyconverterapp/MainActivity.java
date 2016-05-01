package com.nivedhithav.currencyconverterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_INTENT_REQ = "nivedhitha.custom.intent.action.CONVERSION_REQUEST";
    public static final String CUSTOM_INTENT_REPLY = "nivedhitha.custom.intent.action.CONVERSION_REPLY";

    Spinner dropdown;

    String currencyType="";
    int amount=0;

    public static String converted ="";
    public static Boolean flagConverted = Boolean.FALSE;

    TextView get1;
    TextView get2;
    TextView con_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get1=(TextView) findViewById(R.id.get1);
        get2=(TextView) findViewById(R.id.get2);
        //con_amount=(TextView) findViewById(R.id.con_amount);

        dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Euro", "Indian Rupee", "British Pound"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    public void convert(View v){

        Log.d("Debug -->", "Convert Button was pressed.");

        currencyType=dropdown.getItemAtPosition(dropdown.getSelectedItemPosition()).toString();
        EditText editText=(EditText) findViewById(R.id.edit_message);

        if(!editText.getText().toString().equals(""))
        amount=Integer.parseInt(editText.getText().toString());

        Log.d("Debug -->", "CurrencyType: " + currencyType);
        Log.d("Debug -->", "Amount: " + String.valueOf(amount));

        Intent intent= new Intent(MainActivity.CUSTOM_INTENT_REQ);

        intent.putExtra("CurrencyType",currencyType);
        intent.putExtra("Amount",String.valueOf(amount));

        Log.d("Debug -->", "Before Currency app sendBroadcast()");
        sendBroadcast(intent);
        Log.d("Debug -->", "After Currency app sendBroadcast()");

        //get1.setText(String.valueOf(amount) + " ");
        get2.setText("");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Debug -->", " OnResume() Starts");
        Log.d("Debug -->", " flagApproved = " + flagConverted.toString());

        if (flagConverted) {
            Log.d("Debug -->", " OnResume() - Reply = apply ==> Converted!");
            get2.setText("Dollar amount $"+String.valueOf(amount)+" converted to "+converted+" "+currencyType);
        } else {
            Log.d("Debug -->", " OnResume() - Reply = close ==> NOT Converted!");
            get2.setText("");
        }

        Log.d("Debug -->", " OnResume() Ends");
    }


    public void close(View v) {

        MainActivity.this.finish();
    }

}
