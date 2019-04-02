package com.example.chydii.spinner;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private Spinner spinner1, spinner2;
    private Button submitbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addItemsOnSpinner2();
        addListenerOnButton();
        addListnerOnSpinnerItemSelected();
    }

    //ADD ITEMS INTO SPINNER DYNAMICALLY

    public void addItemsOnSpinner2(){

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListnerOnSpinnerItemSelected(){
        spinner1 = (Spinner) findViewById(R.id.Spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    //get the selected dropdown list value

    public void addListenerOnButton(){
        spinner1=(Spinner)findViewById(R.id.Spinner1);
        spinner2=(Spinner)findViewById(R.id.spinner2);
        submitbtn=(Button)findViewById(R.id.submitbtn);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "OnClickListener :" +
                        "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem())+
                        "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
