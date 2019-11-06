package com.nayaapp.classwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.nayaapp.classwork.Model.DetailsClass;
import com.nayaapp.classwork.adapter.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txname, txage;
    RadioButton rbf, rbm;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txname = findViewById(R.id.txtname);
        txage = findViewById(R.id.txtage);
        rbf = findViewById(R.id.rbf);
        rbm = findViewById(R.id.rbm);
        spinnerimg = findViewById(R.id.spinimg);
        viewR = findViewById(R.id.recycleV);
        btnsave = findViewById(R.id.btnsave);
        radioGroup = findViewById(R.id.genderG);
        final List<DetailsClass> detailsClasses = new ArrayList<>();
        final int[] title = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,

        };
        final String[] titlenaME = {
                "a",
                "b",
                "c"
        };

        ArrayAdapter<String> imgtitle= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, titlenaME);
        spinnerimg.setAdapter(imgtitle);

        btnsave.setOnClickListener(new View.OnClickListener() {
            String name,age;
            @Override
            public void onClick(View v) {
                int selectid=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton= findViewById(selectid);
                gender=radioButton.getText().toString();
                name=txname.getText().toString();
                age=(txage.getText().toString());
                int position = (spinnerimg.getSelectedItemPosition());
                int imageposition=title[position];

                detailsClasses.add(new DetailsClass(name,age,gender,imageposition));
                AdapterView adapterView= new AdapterView(MainActivity.this,detailsClasses);
                viewR.setAdapter(adapterView);
                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }
        });


    }
}
