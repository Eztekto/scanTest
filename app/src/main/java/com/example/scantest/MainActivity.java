package com.example.scantest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scantest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Button getSerial;
    private Button getPackages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSerial = binding.getSerialbtn;
        getSerial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "getSerial pressed");

            }
        });
        getPackages = binding.getPackagesbtn;
        getPackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "getPackages pressed");

            }

        });



        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    // Used to load the 'scantest' library on application startup.
    static {
        System.loadLibrary("scantest");
    }

    private ActivityMainBinding binding;



    /**
     * A native method that is implemented by the 'scantest' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}