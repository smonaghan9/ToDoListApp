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
public class LongTerm extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    //Define objects to be used
    private EditText itemET;
    private Button btn;
    private Button backBtnLong;
    private ListView itemsList;

    private ArrayList<String>  items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign objects to corresponding values from activity_main.xml
        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_button);
        backBtnLong = findViewById(R.id.backButtonLong);
        itemsList = findViewById(R.id.items_list);


        //items has data
        items = FileHelper.readData(this);
        //move items to adapter to be set to the items list
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);

        //set method to deal with a click of the button
        btn.setOnClickListener(this);
        backBtnLong.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //each case represents a different text box id
            case R.id.add_button:
                //get the text from the text box
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                //Reset text box back to no items
                itemET.setText("");


                FileHelper.writeData(items,  this);

                //a toast lets the user know when the action is completed
                Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.backButtonLong:
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Task Removed", Toast.LENGTH_SHORT).show();
    }
}
