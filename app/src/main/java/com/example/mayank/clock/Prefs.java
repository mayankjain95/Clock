package com.example.mayank.clock;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by MAYANK on 3/8/2016.
 */
public class Prefs extends PreferenceActivity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs) ;
    }
}
