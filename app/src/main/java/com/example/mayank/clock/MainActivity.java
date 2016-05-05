package com.example.mayank.clock;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import android.os.PowerManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class
        MainActivity extends AppCompatActivity {
    PowerManager.WakeLock wl;
    MediaPlayer song;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //wake lock
        PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
        wl=pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"whatever");

        super.onCreate(savedInstanceState);

        wl.acquire();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        floatButton();
        song=MediaPlayer.create(this,R.raw.tip_tip);

    }

    public void onPause(){
        super.onPause();
        song.release();
    }

    private void floatButton() {
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_open_search);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();
        ImageView iconSortName = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_open_search);
        ImageView iconSortDate = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_open_search);
        ImageView iconSortRating = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_open_search);
        SubActionButton.Builder itemBuilder=new  SubActionButton.Builder(this);
        SubActionButton button2=itemBuilder.setContentView(iconSortDate).build();
        SubActionButton button3=itemBuilder.setContentView(iconSortName).build();
        SubActionButton button4=itemBuilder.setContentView(iconSortRating).build();
        FloatingActionMenu actionMenu=new FloatingActionMenu.Builder(this)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .attachTo(actionButton)
                .build();
    }

    public void onClick(View v){
        Intent i=new Intent("android.intent.action.Camera");
        startActivity(i);
    }

    public void Sound(View v){

        song.start();

    }
    public void PauseMusic(View v){
        song.pause();
    }

    public void voice(View v){
        Intent intent=new Intent("android.intent.action.Voice");
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent("android.intent.action.Prefs");
            startActivity(i);
        }
        if (id == R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
