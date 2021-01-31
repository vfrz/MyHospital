package fr.vfrz.myhospital.adapter;

import android.widget.EditText;

import androidx.databinding.InverseMethod;

public class IntegerConverter {

    @InverseMethod("stringToInt")
    public static String intToString(int value) {
        return Integer.toString(value);
    }

    public static int stringToInt(String value) {
        return Integer.parseInt(value);
    }

}
