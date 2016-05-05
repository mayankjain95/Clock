package com.example.mayank.clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by MAYANK on 5/4/2016.
 */

public class Voice extends Activity{
    ListView lv;
    static final int check=1111;
    TextView tv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice);
        lv = (ListView) findViewById(R.id.listView);
        tv=(TextView)findViewById(R.id.textView3);
    }

    public void voice(View view) {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak up");
        startActivityForResult(i, check);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode==check && resultCode==RESULT_OK){
            ArrayList<String> results=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results)) ;

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    final String text = (String)((TextView)view).getText();
                    tv.setText(text);

                }});

        }
        super.onActivityResult(requestCode,resultCode,data);
    }



}


