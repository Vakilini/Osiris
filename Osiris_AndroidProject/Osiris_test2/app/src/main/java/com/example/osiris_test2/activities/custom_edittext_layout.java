//package com.example.osiris_test2.activities;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.LinearLayout;
//
//import com.example.osiris_test2.R;
//import com.example.osiris_test2.databinding.ActivityCreateTestBinding;
//import com.example.osiris_test2.databinding.ActivityCustomEdittextLayoutBinding;
//import com.example.osiris_test2.utilities.PreferenceManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class custom_edittext_layout extends AppCompatActivity {
//
//    private ActivityCustomEdittextLayoutBinding binding;
//    private PreferenceManager preferenceManager;
//
//    //Создаем список вьюх которые будут создаваться
//    private List<View> allEds;
//    //счетчик чисто декоративный для визуального отображения edittext'ov
//    private int counter = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityCustomEdittextLayoutBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        preferenceManager = new PreferenceManager(getApplicationContext());
//
//        Button addButton = (Button) findViewById(R.id.button3);
//        //инициализировали наш массив с edittext.aьи
//        allEds = new ArrayList<View>();
//
//        //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
//        final FrameLayout linear = (FrameLayout) findViewById(R.id.layou);
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                counter++;
//
//                //берем наш кастомный лейаут находим через него все наши кнопки и едит тексты, задаем нужные данные
//                final View view = getLayoutInflater().inflate(R.layout.activity_custom_editquestion_layout, null);
//                Button deleteField = (Button) view.findViewById(R.id.button);
//                deleteField.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        try {
//                            //получаем родительский view и удаляем его
//                            ((LinearLayout) view.getParent()).removeView(view);
//                            //удаляем эту же запись из массива что бы не оставалось мертвых записей
//                            allEds.remove(view);
//                        } catch(IndexOutOfBoundsException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                });
//
//
//                //добавляем все что создаем в массив
//                allEds.add(view);
//                //добавляем елементы в linearlayout
//                linear.addView(view);
//            }
//        });
//
//    }
//}