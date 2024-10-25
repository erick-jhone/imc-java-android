package com.erick.alura.imc.util;

import android.content.Context;
import android.widget.Toast;

public class AppFeedBackUI {

    private AppFeedBackUI() {
    }

    public static void showMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
