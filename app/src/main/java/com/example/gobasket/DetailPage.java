package com.example.gobasket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {
    ImageView img;
    TextView title;
    TextView subTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        img = findViewById(R.id.detail_image);
        title = findViewById(R.id.detail_title);
        subTitle = findViewById(R.id.detail_subtitle);
        img.setImageResource(getIntent().getIntExtra("img",0));
        title.setText(getIntent().getStringExtra("title"));
        subTitle.setText(getIntent().getStringExtra("subtitle"));
    }
}