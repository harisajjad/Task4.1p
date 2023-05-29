package com.example.task41;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ImageViews
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);

        // Set click listeners for the ImageViews
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }

    // Method to open Activity 1
    private void openActivity1() {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    // Method to open Activity 2
    private void openActivity2() {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    // Method to open Activity 3
    private void openActivity3() {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    // Method to open Activity 4
    private void openActivity4() {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }

    // Method to open Activity 5
    private void openActivity5() {
        Intent intent = new Intent(this, WorkoutActivity.class);
        startActivity(intent);
    }
}
