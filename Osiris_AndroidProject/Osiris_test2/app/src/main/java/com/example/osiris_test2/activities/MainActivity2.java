package com.example.osiris_test2.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.osiris_test2.adapters.testAdapter;
import com.example.osiris_test2.databinding.ActivityMainBinding;
import com.example.osiris_test2.listeners.TestListener;
import com.example.osiris_test2.models.Test;
import com.example.osiris_test2.utilities.Constants;
import com.example.osiris_test2.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity implements TestListener {
    private ActivityMainBinding binding;
    private FirebaseFirestore database;
    private PreferenceManager preferenceManager;
    private List<WriteTest> WriteTest;
    String [][] test;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        getTest();
        loadUserDetails();
        getToken();
        setListeners();
    }





    private void setListeners() {
        binding.imageSignOut.setOnClickListener(v -> signOut());
        binding.fabNewTest.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(),CreateTestActivity.class)));
    }


    private final EventListener<QuerySnapshot> eventListener = (value, error) -> {
      if(error != null) {
          return;
      }
      if(value != null) {
          for (DocumentChange documentChange : value.getDocumentChanges()) {
              if(documentChange.getType() == DocumentChange.Type.ADDED) {
                  Log.e("", documentChange.getDocument().getString(Constants.KEY_TEST_NAME));

              }
          }
      }
    };

    private void loadUserDetails() {
        binding.textName.setText(preferenceManager.getString(Constants.KEY_NAME));
        byte[] bytes = Base64.decode(preferenceManager.getString(Constants.KEY_IMAGE),Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        binding.imageProfile.setImageBitmap(bitmap);

    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
    }

    private void updateToken(String token) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        documentReference.update(Constants.KEY_FCM_TOKEN, token);
    }

    private void signOut() {
        showToast("Выход из учётной записи...");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        HashMap<String, Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> showToast("Unable to sign out"));
    }
    private String getReadableDateTime(Date date) {
        return new SimpleDateFormat("MMM dd, yyyy - hh:mm a", Locale.getDefault()).format(date);
    }

    private void loading(Boolean isLoading) {
        if(isLoading) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void getTest() {
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_TEST)
                .get()
                .addOnCompleteListener(task -> {
                    loading(false);
                    String currentTestName = preferenceManager.getString(Constants.KEY_TEST_NAME);
                    if(task.isSuccessful() && task.getResult() != null) {
                        List<Test> tests = new ArrayList<>();
                        for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
//                            if(currentTestName.equals(queryDocumentSnapshot.getId())) {
//                                continue;
//                            }
                            Test test = new Test();
                            test.name = queryDocumentSnapshot.getString(Constants.KEY_TEST_NAME);
                            test.description = queryDocumentSnapshot.getString(Constants.KEY_TEST_DESCRIPTION);

                            tests.add(test);
                        }
                        if (tests.size() > 0) {
                            testAdapter testAdapter  = new testAdapter(tests, this);
                            binding.testRecyclerView.setAdapter(testAdapter);
                            binding.testRecyclerView.setVisibility(View.VISIBLE);
                        } else {
                            showErrorMessage();
                        }
                    } else {
                        showErrorMessage();
                    }
                });
    }

    private void showErrorMessage() {
        binding.textErrorMessage.setText(String.format("%s", "Ещё новых тестов нет, но они обязательно будут"));
        binding.textErrorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTestCliced(Test test) {
        Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
        intent.putExtra(Constants.KEY_TEST, test);
        startActivity(intent);
        finish();
    }
}
