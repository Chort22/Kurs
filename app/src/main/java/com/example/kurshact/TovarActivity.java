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
        dbHelper = new DbHelper(this);

        // Получаем товары из базы данных
        List<String> items = dbHelper.getAllTovars();

        // Устанавливаем адаптер для ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listViewItems.setAdapter(adapter);
    }
}
