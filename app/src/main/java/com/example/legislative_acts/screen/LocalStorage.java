package com.example.legislative_acts.screen;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {

    private Context context;

    public static LocalStorage instance;

    SharedPreferences pref;

    private LocalStorage(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        instance = new LocalStorage(context);
    }


    public Long getExpiredDate() {
        return pref.getLong("EXPIRED_DATE", 0);
    }

    public void setExpiredDate(Long expiredDate) {
        pref.edit().putLong("EXPIRED_DATE", expiredDate).apply();
    }

    public boolean isAccepted() {
        return pref.getBoolean("IS_ACCEPTED", false);
    }

    public void setAccepted(boolean accepted) {
        pref.edit().putBoolean("IS_ACCEPTED", accepted).apply();
    }
}
