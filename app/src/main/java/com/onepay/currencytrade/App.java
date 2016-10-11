package com.onepay.currencytrade;

import android.app.Application;

import im.fir.sdk.FIR;

/**
 * Created by zsfzbc on 2016,9,30,0030.
 */

public class App extends Application {

    private static App appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        FIR.init(this);

    }

    public static App getAppContext() {
        return appContext;
    }
}
