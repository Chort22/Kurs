package com.example.kurshact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        String[] data = {"Безе - 921р", "Зефир - 315р", "Бисквит - 320р", "Корзиночка - 266р", "Профитроли - 150р", "Пишмание - 279р", "Пастила - 499р", "Шифоновый бисквит - 785р", "Кулич - 759р", "Баумкухен - 1250р", "Трубочка с кремом - 216р", "Пища ангелов - 990р", "Папанаши - 300р", "Рацухи - 269р", "Олибол - 549р", "Валлийские лепёшки - 229р", "Диплес -    419р", "Сфенж - 154р"};
        ArrayAdapter<String> adapter  = new ArrayAdapter(this,android.R.layout.simple_list_item_1, data);
        listViewItems.setAdapter(adapter);





        //dbHelper = new DbHelper(this);

        // Получаем товары из базы данных
        //List<String> items = dbHelper.getAllTovars();

        // Устанавливаем адаптер для ListView
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        //listViewItems.setAdapter(adapter);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Создаем Intent для перехода на SecondActivity
                Intent intent = new Intent(TovarActivity.this, Zakaz.class);
                // Передаем данные, если нужно
                intent.putExtra("item_position", position);
                startActivity(intent);
            }

        });
    }
}
