package com.example.mayank.clock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by MAYANK on 4/20/2016.
 */
public class Widget extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Random random=new Random();
        int randomInt=random.nextInt(42364563);
        String rand=String.valueOf(randomInt);

        final int N=appWidgetIds.length;
        for (int i = 0; i <N ; i++) {
            int awId = appWidgetIds[i];
            RemoteViews view=new RemoteViews(context.getPackageName(),R.layout.widget);
            view.setTextViewText(R.id.tv1Widget,rand);
            appWidgetManager.updateAppWidget(awId,view);
        }
    }



    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
    }
}
