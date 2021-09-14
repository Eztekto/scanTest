package com.example.scantest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                TextView tv = binding.sampleText;
                tv.setText(getphoneSerial());
            }
        });
        getPackages = binding.getPackagesbtn;
        getPackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "getPackages pressed");
                TextView tv = binding.sampleText;
                tv.setText(getphonePackages());
            }
        });



        // Example of a call to a native method

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
    public native String getphoneSerial();
    public native String getphonePackages();


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState (savedInstanceState);
        Log.d("SYSTEM INFO", "Метода onSaveInstanceState() запущен");
    }
}