package com.example.mayank.clock;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        Button button1 = (Button) view.findViewById(R.id.button2);
        TextView textView=(TextView)view.findViewById(R.id.textView);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        textView.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        // when the button gets clicked
        if (v.getId() == R.id.button) {
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
        }

        if (v.getId() == R.id.button2) {
            Context context=getActivity().getApplicationContext();
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View appear = inflater.inflate(R.layout.toast, (ViewGroup) v.findViewById(R.id.toast));
            Toast toast1 = new Toast(context);
            toast1.setDuration(Toast.LENGTH_LONG);
            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.setView(appear);
            toast1.show();

        }

        if (v.getId()==R.id.textView){
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Hello", Toast.LENGTH_SHORT);
            toast.show();

        }

    }
}
   