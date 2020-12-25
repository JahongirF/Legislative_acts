package com.example.legislative_acts.screen;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LocalStorage.init(this);
    }
}
