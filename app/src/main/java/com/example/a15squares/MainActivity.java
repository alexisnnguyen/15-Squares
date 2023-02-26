package com.example.a15squares;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.surfaceView);
        Controller controller = new Controller(view);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(controller);

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(controller);

        view.setOnTouchListener((android.view.View.OnTouchListener) controller);


    }
}