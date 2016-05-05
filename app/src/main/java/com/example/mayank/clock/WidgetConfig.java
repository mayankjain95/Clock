package com.example.mayank.clock;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

import java.util.*;

/**
 * Created by MAYANK on 4/20/2016.
 */
public class WidgetConfig extends Activity implements View.OnClickListener {
    EditText info;
    AppWidgetManager awm;
    Context context;
    int awId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgetconfig);
        Button b=(Button)findViewById(R.id.bConfig);
        b.setOnClickListener(this);
        context=WidgetConfig.this;
        info=(EditText)findViewById(R.id.etConfig);

        //getting info about the widget that launched this activity

        Intent i=getIntent();
        Bundle extras=i.getExtras();
        if(extras!=null){
            awId=extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }else {
            finish();
        }
        awm=AppWidgetManager.getInstance(context);

    }

    @Override
    public void onClick(View v) {
        String e=info.getText().toString();
        RemoteViews view=new RemoteViews(context.getPackageName(),R.layout.widget);
        view.setTextViewText(R.id.tvWidget,e);

        Intent in=new Intent(context,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(context,0,in,0);
        view.setOnClickPendingIntent(R.id.bWidget,pi);
        awm.updateAppWidget(awId,view);

        Intent result=new Intent();
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,awId);
        setResult(RESULT_OK,result);
        finish();


    }
}
