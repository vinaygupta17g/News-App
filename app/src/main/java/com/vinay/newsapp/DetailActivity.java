package com.vinay.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView,back;
    TextView title,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String titles =intent.getStringExtra("title");
        String images =intent.getStringExtra("image");
        String descriptions =intent.getStringExtra("description");
        title =findViewById(R.id.tv_detail_title);
        description=findViewById(R.id.tv_detail_description);
        imageView =findViewById(R.id.iv_detail_image);
        title.setText(titles);
        description.setText(descriptions);
        Picasso.get().load(images).placeholder(R.drawable.placeholder_image).into(imageView);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}