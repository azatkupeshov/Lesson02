package com.mysupercompany.lesson02;

import android.os.Bundle;

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

    private List<Contact> initDatabase(){
        contacts = new ArrayList<>();
        contacts.add(new Contact("Ваня", "+77771324567"));
        contacts.add(new Contact("Петя", "+77771324568"));
        contacts.add(new Contact("Маша", "+77771324569"));
        return contacts;
    }
}
