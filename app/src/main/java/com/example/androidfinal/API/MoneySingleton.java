package com.example.androidfinal.API;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MoneySingleton {

    public static MoneySingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private MoneySingleton(Context context) {
        this.context = context;
    }

    public static MoneySingleton getInstance() {
        if (instance == null) {
            instance = new MoneySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
