package com.example.dialogfragmentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Datable {

    private ArrayList<String> phones;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView phonesList=findViewById(R.id.phonesList);
        phones=new ArrayList<>();
        phones.add("Google Pixel");
        phones.add("Huawei P9");
        phones.add("LG G5");
        phones.add("Samsung Galaxy S8");

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phones);
        phonesList.setAdapter(adapter);

        phonesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPhone=adapter.getItem(position);
                CustomDialogFragment dialog=new CustomDialogFragment();
                Bundle args=new Bundle();
                args.putString("phone", selectedPhone);
                dialog.setArguments(args);
                dialog.show(getSupportFragmentManager(), "custom");
            }
        });
    }

    @Override
    public void remove(String name) {
        adapter.remove(name);
    }
}
