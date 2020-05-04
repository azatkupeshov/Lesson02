package com.mysupercompany.lesson02;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация RecyclerView
        recyclerView = findViewById(R.id.recycleView);

        //Магия котораю постараюсь обьяснить в будущем.
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        //Инициализируем нашу псевдо базу данных
        contacts = initDatabase();
        //Создаем адаптер
        adapter = new MyAdapter(contacts);
        //и устанавливаем его
        recyclerView.setAdapter(adapter);
    }

    //Метод создающий меню приложения
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Получаем menuInflater, компонент который загружает меню из xml файла.
        MenuInflater inflater = getMenuInflater();
        //Загружаем меню из xml файла
        inflater.inflate(R.menu.menu, menu);
        //Возвращаем значение true, которое уведомляет систему андроид создать меню для приложения
        return true;
    }

    //Метот обрабатывающий клики на пункты меню.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Извлекаем ID пункта меню и ищем подходящий case.
        switch (item.getItemId()) {
            case R.id.exit:
                finish();
                return true;
            case R.id.setting:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Contact> initDatabase() {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Ваня", "+77771324567"));
        contacts.add(new Contact("Петя", "+77771324568"));
        contacts.add(new Contact("Маша", "+77771324569"));
        return contacts;
    }
}
