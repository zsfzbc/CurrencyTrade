package com.onepay.currencytrade.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onepay.currencytrade.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void launch(Context context){
        Intent intent=new Intent(context, null);
        startActivity(intent);
    }
}
