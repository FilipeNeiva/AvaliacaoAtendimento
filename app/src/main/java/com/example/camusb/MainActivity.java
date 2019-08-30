package com.example.camusb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image = findViewById(R.id.img_view);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CameraActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        if(intent.getStringExtra("path") != null){

            String path = intent.getStringExtra("path");

            Bitmap myBitmap = BitmapFactory.decodeFile(path);
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            Bitmap imageRotate = Bitmap.createBitmap(myBitmap, 0, 0,myBitmap.getWidth(),myBitmap.getHeight(), matrix, true);

            image.setImageBitmap(imageRotate);

            assert path != null;
            File file = new File(path);
            boolean deletar = file.delete();
            intent.putExtra("path", (Bundle) null);

        }
    }
}
