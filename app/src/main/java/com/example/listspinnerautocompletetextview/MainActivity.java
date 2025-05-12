package com.example.listspinnerautocompletetextview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;
    ListView listView;
    int[] arrNo = new  int[]{1,2,3,4,5,6,7,8,9,10}; // Immutable and data is fixed.
    ArrayList<String> arrNames = new ArrayList<>(); //Dynamic and mutable
    ArrayList<String> arrIds = new ArrayList<>(); //Dynamic and mutable
    ArrayList<String> arrLanguages = new ArrayList<>(); //Dynamic and mutable

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

        arrNames.add("Ram");
        arrNames.add("Raman");
        arrNames.add("Raman");
        arrNames.add("Raman");
        arrNames.add("Raman");
        arrNames.add("Raman");
        arrNames.add("Ramanujan");
        arrNames.add("Aakash");
        arrNames.add("Aditya");
        arrNames.add("Aditya");
        arrNames.add("Aditya");
        arrNames.add("Aditya");
        arrNames.add("Suraj");
        arrNames.add("Sunny");
        arrNames.add("Sunny");
        arrNames.add("Sunny");
        arrNames.add("Sunny");
        arrNames.add("Sunny");
        arrNames.add("Nitish");
        arrNames.add("Adarsh");
        arrNames.add("Adarsh");
        arrNames.add("Adarsh");
        arrNames.add("Adarsh");
        arrNames.add("Adarsh");
        arrNames.add("Vignesh");
        arrNames.add("Manas");
        arrNames.add("Vishwa");
        arrNames.add("Vishwa");
        arrNames.add("Vishwa");
        arrNames.add("Vishwa");
        arrNames.add("Vishwa");
        arrNames.add("Vishwa");
        arrNames.add("Rakesh");
        arrNames.add("Rajesh");

        //Spinner
        arrIds.add("Aadhar Card");
        arrIds.add("PAN Card");
        arrIds.add("Voter ID Card");
        arrIds.add("Driving License Card");
        arrIds.add("Xth Card");
        arrIds.add("XIIth Card");

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        ArrayAdapter<String> idAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrIds);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hi this is index "+position, Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setAdapter(idAdapter);

        //Auto Complete Text View

        arrLanguages.add("C");
        arrLanguages.add("C++");
        arrLanguages.add("Java");
        arrLanguages.add("Kotlin");
        arrLanguages.add("Dart");
        arrLanguages.add("Python");
        arrLanguages.add("Ruby");


        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguages);

        autoCompleteTextView.setAdapter(languageAdapter);
        autoCompleteTextView.setThreshold(1);
    }
}