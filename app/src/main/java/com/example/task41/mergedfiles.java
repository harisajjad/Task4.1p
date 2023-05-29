package com.example.task41;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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





//Workout Activty
package com.example.task41;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView workoutTimeTextView;
    private EditText workoutDurationEditText;
    private TextView restTimeTextView;
    private EditText restDurationEditText;
    private Button startButton;
    private Button stopButton;
    private ProgressBar progressBar;

    // Declare timers
    private CountDownTimer workoutTimer;
    private CountDownTimer restTimer;

    // Declare variables for workout and rest durations
    private long workoutDuration;
    private long restDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Initialize all the various UI elements
        workoutTimeTextView = findViewById(R.id.workoutTimeTextView);
        workoutDurationEditText = findViewById(R.id.workoutDurationEditText);
        restTimeTextView = findViewById(R.id.restTimeTextView);
        restDurationEditText = findViewById(R.id.restDurationEditText);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        progressBar = findViewById(R.id.progressBar);

        // Set click listeners for start and stop buttons
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
    }

    // The following method will start the workout timer
    private void startTimer() {
        // Retrieve workout and rest durations from EditText inputs and convert to milliseconds
        workoutDuration = Long.parseLong(workoutDurationEditText.getText().toString()) * 1000;
        restDuration = Long.parseLong(restDurationEditText.getText().toString()) * 1000;

        // Initialize and start the workout timer
        workoutTimer = new CountDownTimer(workoutDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update workout time remaining TextView and progress bar
                long seconds = millisUntilFinished / 1000;
                workoutTimeTextView.setText("Workout Time Remaining: " + seconds);
                progressBar.setProgress((int) ((workoutDuration - millisUntilFinished) * 100 / workoutDuration));
            }

            @Override
            public void onFinish() {
                // When workout timer finishes, update workout time remaining TextView, progress bar,
                // start the rest timer, and play a sound
                workoutTimeTextView.setText("Workout Time Remaining: 00:00");
                progressBar.setProgress(100);
                restTimer.start();
            }
        };

        // Initialize and start the rest timer
        restTimer = new CountDownTimer(restDuration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update rest time remaining TextView and progress bar
                long seconds = millisUntilFinished / 1000;
                restTimeTextView.setText("Rest Time Remaining: " + seconds);
                progressBar.setProgress((int) ((restDuration - millisUntilFinished) * 100 / restDuration));
            }

            @Override
            public void onFinish() {
                // When rest timer finishes, update rest time remaining TextView, progress bar,
                // start the workout timer, and play a sound
                restTimeTextView.setText("Rest Time Remaining: 00:00");
                progressBar.setProgress(100);
                workoutTimer.start();
                playSound();
            }
        };

        // Start the workout timer
        workoutTimer.start();
        playSound();
        // Disable start button and enable stop button
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    // Method to stop the timers and play a sound
    private void stopTimer() {
        // Cancel the workout and rest timers
        workoutTimer.cancel();
        restTimer.cancel();
        // Play a sound
        playSound();

        // Enable start button and disable stop button
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    // Method to play a sound
    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.notification);
        mediaPlayer.start();
    }
}
