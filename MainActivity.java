package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    //Define objects to be used
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        String[] toDoLists = {"Daily", "Weekly", "Long Term"};

        ArrayAdapter<String> homeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, toDoLists);

        listView.setAdapter(homeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(view.getContext(), Daily.class);
                    startActivity(intent);
                }

                if(position == 1){
                    Intent intent = new Intent(view.getContext(), MidTerm.class);
                    startActivity(intent);
                }

                if(position == 2){
                    Intent intent = new Intent(view.getContext(), LongTerm.class);
                    startActivity(intent);
                }
            }
        });

    }
}

