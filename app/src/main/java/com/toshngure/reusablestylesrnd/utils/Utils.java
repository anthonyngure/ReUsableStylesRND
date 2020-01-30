package com.toshngure.reusablestylesrnd.utils;

import android.content.res.Resources;

/**
 * Created by Anthony Ngure on 1/30/2020
 *
 * @author Anthony Ngure
 */
public class Utils {

    public static int dpToPx(double dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
