package com.example.divyamohan.divyaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing button
        Button button = (Button) findViewById(R.id.button);

        //initialize listview
        ListView listView = (ListView) findViewById(R.id.listview);
        final EditText editText = (EditText) findViewById(R.id.edittext);

        //make an arraylist to store data
        final ArrayList<String> myItems = new ArrayList<>();

        //make an arrayadapter
        //connects listview to arraylist of data
        final ArrayAdapter myAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myItems);
        listView.setAdapter(myAdapter);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //get the edittext input as a string
                String currentItem  = editText.getText().toString();
                myItems.add(currentItem);
                //update adapter
                myAdapter.notifyDataSetChanged();
                //clear EditText
                editText.setText("");
                Toast.makeText(MainActivity.this, "Added Item", Toast.LENGTH_LONG).show();
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myItems.remove(i);
                //update adapter
                myAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Removed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
