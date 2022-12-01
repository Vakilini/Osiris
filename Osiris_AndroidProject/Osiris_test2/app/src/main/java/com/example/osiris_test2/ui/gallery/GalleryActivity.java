package com.example.osiris_test2.ui.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.osiris_test2.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends Activity {
   //Создаем список вьюх которые будут создаваться
    private List<View> allEds;
    //счетчик чисто декоративный для визуального отображения edittext'ov
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);

        Button addButton = (Button) findViewById(R.id.button);
        //инициализировали наш массив с edittext.aьи
        allEds = new ArrayList<View>();

        //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
        final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                //берем наш кастомный лейаут находим через него все наши кнопки и едит тексты, задаем нужные данные
                final View view = getLayoutInflater().inflate(R.layout.activity_custom_edittext_layout, null);
                Button deleteField = (Button) view.findViewById(R.id.button2);
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
                EditText text = (EditText) view.findViewById(R.id.editText);
                text.setText("Some text" + counter);
                //добавляем все что создаем в массив
                allEds.add(view);
                //добавляем елементы в linearlayout
                linear.addView(view);
            }
        });

    }
}
