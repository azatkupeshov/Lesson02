package com.mysupercompany.lesson02;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Этот класс который представляет одну строку в RecyclerView
 * Он  содержит ссылки на те обьекты которые необходимо отобразить.
 * В нашем случае это два объекта TextView, которые отображают имя и телефнон.
 */
public class MyHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    private TextView phoneViev;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        this.nameView = (TextView) itemView.findViewById(R.id.name);
        this.phoneViev = (TextView) itemView.findViewById(R.id.phone);
    }

    public TextView getNameView() {
        return nameView;
    }

    public TextView getPhoneViev() {
        return phoneViev;
    }
}
