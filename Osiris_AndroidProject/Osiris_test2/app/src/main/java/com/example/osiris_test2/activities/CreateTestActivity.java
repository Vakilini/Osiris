package com.example.osiris_test2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.osiris_test2.R;
import com.example.osiris_test2.databinding.ActivityCreateTestBinding;
import com.example.osiris_test2.utilities.Constants;
import com.example.osiris_test2.utilities.PreferenceManager;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CreateTestActivity extends Activity {

    private ActivityCreateTestBinding binding;
    private PreferenceManager preferenceManager;

    //Создаем список вьюх которые будут создаваться
    private List<View> allEds;
    private List<CreateTestActivity> createTestActivities;
    private FirebaseFirestore database;
    String [][] test;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityCreateTestBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            preferenceManager = new PreferenceManager(getApplicationContext());

            Button addButton = (Button) findViewById(R.id.button);
            //инициализировали наш массив с edittext.aьи
            allEds = new ArrayList<View>();
            setListeners();
            init();
            //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
            final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //берем наш кастомный лейаут находим через него все наши кнопки и едит тексты, задаем нужные данные
                    final View view = getLayoutInflater().inflate(R.layout.activity_custom_edittext_layout, null);
                    Button deleteField = (Button) view.findViewById(R.id.button);
                    deleteField.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                //получаем родительский view и удаляем его
                                ((LinearLayout) view.getParent()).removeView(view);
                                //удаляем эту же запись из массива что бы не оставалось мертвых записей
                                allEds.remove(view);
                            } catch(IndexOutOfBoundsException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });

                    Button showDataBtn = (Button) findViewById(R.id.button2);
                    showDataBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String nameTest = findViewById(R.id.inputTitleTest).toString();
                            if (nameTest == null) {
                                showToast("Укажите название теста");
                            } else {
                                //преобразуем наш ArrayList в просто String Array
                                test = new String[allEds.size()][2];
                                //запускаем чтение всех елементов этого списка и запись в массив
                                for(int i=0; i < allEds.size(); i++) {


                                    test[i][0] = ((EditText) allEds.get(i).findViewById(R.id.editText)).getText().toString();
                                    test[i][1] = ((EditText) allEds.get(i).findViewById(R.id.editText2)).getText().toString();

                                    //ну и можно сразу же здесь вывести
                                     //Log.e("", " " + test[0][0]);
                                    sendTest();
                                }

                            }
                        }
                    });


                    //добавляем все что создаем в массив
                    allEds.add(view);
                    //добавляем елементы в linearlayout
                    linear.addView(view);
                }
            });

        }

        private void init() {
            preferenceManager = new PreferenceManager(getApplicationContext());
            createTestActivities = new ArrayList<>();

            database = FirebaseFirestore.getInstance();

        }

        private void setListeners() {
            binding.imageBack.setOnClickListener(v -> onBackPressed());
            //binding.button2.setOnClickListener(v -> );
        }
        private void sendTest() {
            FirebaseFirestore database = FirebaseFirestore.getInstance();
            HashMap<String, Object> testPush = new HashMap<>();
            testPush.put(Constants.KEY_TEST_NAME, binding.inputTitleTest.getText().toString());
            testPush.put(Constants.KEY_TEST_DESCRIPTION, binding.inputDescriptionTest.getText().toString());
            testPush.put(Constants.KEY_SIZE_TEST, test.length+"");
            for (int i = 0; i<test.length; i++) {

                testPush.put(Constants.KEY_TEST_QUESTION+i,test[i][0]);
                testPush.put(Constants.KEY_TEST_QUESTION_DESCRIPTION+i,test[i][1]);
            }
            //testPush.put(Constants.KEY_TEST, test);

            database.collection(Constants.KEY_COLLECTION_TEST).add(testPush)
                    .addOnSuccessListener(documentReference -> {

                        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                        startActivity(intent);
                    })
                      ;
        }





    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    }

