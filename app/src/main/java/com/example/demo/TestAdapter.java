package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintSet;

import java.util.List;

public class TestAdapter extends ArrayAdapter<String> {
    private Context cntxt;
    private List<String> str_list;
    public TestAdapter(Context context, List<String> string_list) {
        super(context, 0, string_list);
        this.cntxt = context;
        this.str_list = string_list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(cntxt).inflate(R.layout.test_layout, parent, false);
        }
        String str = str_list.get(position);
        TextView txt = view.findViewById(R.id.textView);
        txt.setText(str);
        return view;
    }
}
