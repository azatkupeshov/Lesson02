package com.mysupercompany.lesson02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    private List<Contact> contacts;

    public MyAdapter(List<Contact> dataset) {
        //Инициализируем нашу базу данных
        this.contacts = dataset;
    }

    /**
     * Эта функция создает каждый раз новый объект MyHolder. То есть эта функция вызывается тогда когда
     * создается новая строка списка RecyclerView.
     * @param parent это viewGroup куда будет добавлен новый view после его привязки к адаптеру
     */

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Здесь мы инициализируем View объект из файла contact.xml
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact, parent, false);

        //Возвращаем созданный MyHolder содержащий в себе ссылки на TextView объекты name и phone
        return new MyHolder(v);
    }

    /**
     * Здесь мы биндим данные, то есть извлекаем данные из источника и устанавливаем их
     * в необходимые поля для отображения.
     * Функция принимает два аргумента:
     *
     * @param holder   ссылка на объект который был создан в onCreateViewHolder
     * @param position позиция элемента который был создан в onCreateViewHolder.
     */
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.getNameView().setText(contact.getName());
        holder.getPhoneViev().setText(contact.getPhone());
    }

    /*
    Здесь мы должны задать то количество элементов списка которое у нас есть.
    Это количество строк в базе данных, строк из файла или количество любого другого ресурса из которого
    мы пытаемся извлеч данные
     */
    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
