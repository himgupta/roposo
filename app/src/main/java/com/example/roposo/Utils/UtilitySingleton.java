package com.example.roposo.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roposo.R;

import java.util.ArrayList;


public final class UtilitySingleton {

    private static final String TAG = UtilitySingleton.class.getName();
    private static volatile UtilitySingleton instance = null;
    private final SharedPreferences sharedPreferences;
    private Context context;
    private ArrayList<String> mStatusTypes = new ArrayList<>();
    private String currentDateStr;

    private UtilitySingleton(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Roposo", Context.MODE_PRIVATE);
    }

    public static UtilitySingleton getInstance(Context context) {
        if (instance == null) {
            synchronized (UtilitySingleton.class) {
                instance = new UtilitySingleton(context);
            }
        }
        return instance;
    }


    // --------- click Listener in whole application-----------
    public void SetClickListener(int[] clickIDs, Context context) {
        if (context instanceof OnClickListener) {
            for (int id : clickIDs) {
                try {
                    ((Activity) context).findViewById(id).setOnClickListener((OnClickListener) context);
                } catch (Exception e) {
                    Log.e(TAG, "Wrong view ID sent.");
                }
            }
        }
    }

    public void hideSoftKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void ShowToast(String msg, Context context) {
        if (msg != null && !msg.trim().equalsIgnoreCase("")) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }




    public void saveStringInSharedPref(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringFromSharedPref(String key) {
        return getStringFromSharedPref(key, null);
    }

    public String getStringFromSharedPref(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public void saveIntInSharedPref(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getIntFromSharedPref(String key) {
        return getIntFromSharedPref(key, 0);
    }

    public int getIntFromSharedPref(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public void saveBooleanInSharedPref(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBooleanFromSharedPref(String key) {
        return getBooleanFromSharedPref(key, false);
    }

    public boolean getBooleanFromSharedPref(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public ArrayList<String> getStatusTypes() {
        return mStatusTypes;
    }

    public void setStatusTypes(ArrayList<String> mStatusTypes) {
        this.mStatusTypes = mStatusTypes;
    }

    public void resetStatusTypes() {
        mStatusTypes.clear();
        currentDateStr = "";
    }

    public void setDateSelected(String currentDateStr) {
        this.currentDateStr = currentDateStr;
    }

    public String getCurrentDateStr() {
        return this.currentDateStr;
    }


    public void clearSharedPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static void navigateFragment(Fragment fragment, String tag, Bundle bundle, FragmentActivity fragmentActivity) {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(tag, 0);
        /*	*//*
             * fragment not in back stack, create it.
			 *//* */
        if (!fragmentPopped && fragmentManager.findFragmentByTag(tag) == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            fragmentTransaction.replace(R.id.fragment_container, fragment, tag);
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }
    }
}
