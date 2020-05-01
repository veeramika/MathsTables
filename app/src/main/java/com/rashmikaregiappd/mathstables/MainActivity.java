package com.rashmikaregiappd.mathstables;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    public void generateTables(int num)
    {
        ArrayList<String> tableContent = new ArrayList<String>();
        for(int i = 1;i<= 10 ; i++)
        {
            tableContent.add(Integer.toString(i*num));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tableContent);
        mylist.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar myseek = findViewById(R.id.seekBarId);
        mylist = findViewById(R.id.ListviewId);
        myseek.setMax(20);
        myseek.setProgress(10);
        myseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1,num;
                if(i<min)
                {
                    num = min;
                    myseek.setProgress(min);
                }
                else num = i;
                generateTables(num);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

            generateTables(10);
    }
}
