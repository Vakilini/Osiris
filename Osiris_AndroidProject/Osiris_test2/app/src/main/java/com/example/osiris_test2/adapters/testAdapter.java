package com.example.osiris_test2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osiris_test2.databinding.ActivityTestWindowBinding;


import com.example.osiris_test2.databinding.ItemContainerTestBinding;
import com.example.osiris_test2.databinding.ItemConteinerSentTestBinding;
import com.example.osiris_test2.listeners.TestListener;
import com.example.osiris_test2.models.Test;

import java.util.List;

public class testAdapter extends RecyclerView.Adapter<testAdapter.TestViewHolder> {

    private final List<Test> tests;
    private final TestListener testListener;

    public testAdapter(List<Test> tests, TestListener testListener) {
        this.tests = tests;
        this.testListener = testListener;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemContainerTestBinding itemContainerTestBinding = ItemContainerTestBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new TestViewHolder(itemContainerTestBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  testAdapter.TestViewHolder holder, int position) {
        holder.setTestData(tests.get(position));
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {

        ItemContainerTestBinding binding;

        TestViewHolder(ItemContainerTestBinding itemContainerTestBinding) {
            super(itemContainerTestBinding.getRoot());
            binding = itemContainerTestBinding;
        }

        void setTestData(Test test){
            binding.textNameTest.setText(test.name);
            binding.textDurationTest.setText(test.description);
            binding.getRoot().setOnClickListener(v -> {
                binding.textNameTest.setVisibility(View.GONE);
                binding.textDurationTest.setVisibility(View.GONE);
                binding.textDesriptionQestion1.setVisibility(View.GONE);
                binding.textDesriptionQestion2.setVisibility(View.GONE);
                binding.textDesriptionQestion3.setVisibility(View.GONE);
                binding.textAnswer1.setVisibility(View.GONE);
                binding.textAnswer2.setVisibility(View.GONE);
                binding.textAnswer3.setVisibility(View.GONE);
                binding.editText1.setVisibility(View.GONE);
                binding.editText2.setVisibility(View.GONE);
                binding.editText3.setVisibility(View.GONE);
                binding.layoutSend.setVisibility(View.GONE);
                binding.imageStartTest.setVisibility(View.VISIBLE);
            });

        }
    }

}
