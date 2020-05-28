package com.bh183.adisurya;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TampilActivity extends AppCompatActivity {

    private ImageView imgCover;
    private TextView tvNegara, tvSejarah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        imgCover = findViewById(R.id.iv_negara);
        tvNegara = findViewById(R.id.tv_negara);
        tvSejarah = findViewById(R.id.tv_sejarah);

        Intent terimaData = getIntent();
        tvNegara.setText(terimaData.getStringExtra("NEGARA"));
        tvSejarah.setText(terimaData.getStringExtra("SEJARAH"));
        String imgLocation = terimaData.getStringExtra("COVER");

        try {
            File file = new File(imgLocation);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            imgCover.setImageBitmap(bitmap);
            imgCover.setContentDescription(imgLocation);
        } catch (FileNotFoundException er) {
            er.printStackTrace();
            Toast.makeText(this, "Gagal dalam mengambil gambar", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tampil_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}

