package com.example.osiris_test2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.example.osiris_test2.databinding.ActivityQuestionsBinding;
import com.example.osiris_test2.models.Test;
import com.example.osiris_test2.utilities.Constants;

public class QuestionsActivity extends AppCompatActivity {
    private ActivityQuestionsBinding binding;
    private Test receiverTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadReceiverDetails();
        setListeners();
    }

    private void loadReceiverDetails() {
        receiverTest = (Test) getIntent().getSerializableExtra(Constants.KEY_TEST);
        binding.textNameTest.setText(receiverTest.name);
    }

    private void setListeners() {
        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }
}