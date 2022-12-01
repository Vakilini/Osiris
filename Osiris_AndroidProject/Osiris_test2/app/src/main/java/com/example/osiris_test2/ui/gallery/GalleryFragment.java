package com.example.osiris_test2.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.osiris_test2.R;
import com.example.osiris_test2.activities.MainActivity;
import com.example.osiris_test2.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    List<View> allEds;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, null);

        //счетчик чисто декоративный для визуального отображения edittext'ov

        Button addButton = (Button) v.findViewById(R.id.button);
        //инициализировали наш массив с edittext.aьи
        allEds = new ArrayList<View>();

        //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
//        final LinearLayout linear = (LinearLayout) v.findViewById(R.id.linear);
//        addButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int counter = 0;
//                counter++;
//
//                //берем наш кастомный лейаут находим через него все наши кнопки и едит тексты, задаем нужные данные
//                final View view = getLayoutInflater().inflate(R.layout.ac, null);
//                Button deleteField = (Button) view.findViewById(R.id.button2);
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
//                EditText text = (EditText) view.findViewById(R.id.editText);
//                text.setText("Some text" + counter);
//                //добавляем все что создаем в массив
//                allEds.add(view);
//                //добавляем елементы в linearlayout
//                linear.addView(view);
//            }
//        });


        binding = FragmentGalleryBinding.inflate(inflater, container, false);



        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}