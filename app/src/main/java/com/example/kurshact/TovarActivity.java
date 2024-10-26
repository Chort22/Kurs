package com.example.kurshact;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TovarActivity extends AppCompatActivity {

    private ListView listViewItems;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tovar);

        listViewItems = findViewById(R.id.listViewItem);
        String[] data = {"Сервелат охотничий 250", "Сервелат Св 300", "Сосиски премиум 800", "Сосиски премиум 800", "Молочные сосиски 600", "Филейная вар 200", "Коровино вар 340", "Коровино со шпиком вар. 330"};
        ArrayAdapter<String> adapter  = new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
        listViewItems.setAdapter(adapter);



        //dbHelper = new DbHelper(this);

        // Получаем товары из базы данных
        //List<String> items = dbHelper.getAllTovars();

        // Устанавливаем адаптер для ListView
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        //listViewItems.setAdapter(adapter);
    }
}
