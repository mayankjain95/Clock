package com.example.mayank.clock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

/**
 * Created by MAYANK on 4/20/2016.
 */
public class Camera extends Activity implements View.OnClickListener{

    ImageView imageView;
    Intent intent;
    Button takePic,save;
    final static int cameraData=0;
    Bitmap bitmap;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        imageView=(ImageView)findViewById(R.id.cameraView);
        takePic=(Button)findViewById(R.id.takePic);
        save=(Button) findViewById(R.id.setWall);
        takePic.setOnClickListener(this);
        save.setOnClickListener(this);
    }



    public void onClick(View v){
        switch (v.getId()){
            case R.id.setWall:
                try {
                    getApplicationContext().setWallpaper(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.takePic:
                intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,cameraData);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode ==RESULT_OK){
            Bundle extras=data.getExtras();
            bitmap=(Bitmap)extras.get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}
