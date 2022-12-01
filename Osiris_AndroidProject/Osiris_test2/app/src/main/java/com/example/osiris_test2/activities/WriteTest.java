package com.example.osiris_test2.activities;

import android.app.Activity;
import android.os.Bundle;



import com.example.osiris_test2.databinding.ActivityTestWindowBinding;
import com.example.osiris_test2.utilities.PreferenceManager;

import java.util.Date;

public class WriteTest extends Activity {
    private ActivityTestWindowBinding binding;
    private PreferenceManager preferenceManager;

    public String testName, testDescription,datePublic, test;
    public  int sizeTest;
    public Date dateObject;
    public int count;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestWindowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
    }
}
