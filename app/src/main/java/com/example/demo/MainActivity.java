package com.example.demo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button load;
    EditText t;
    TestAdapter test_adapter;
    List<String> str_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        load = findViewById(R.id.loadBtn);
        t = findViewById(R.id.loadTxt);
        list = findViewById(R.id.listView);
        load.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                load_text();
                return true;
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_text();
            }
        });


        str_list = new ArrayList<>();
        test_adapter = new TestAdapter(this,str_list);
        list.setAdapter(test_adapter);
    }
    private void load_text(){
        if(t.getText().length() > 0){
            str_list.add(t.getText().toString());
            t.setText("");
            test_adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(getActivity(), "Input Field is Empty", Toast.LENGTH_LONG).show();
        }
    }

    private Context getActivity() {
        return MainActivity.this;
    }
}