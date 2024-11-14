package com.example.lab5smerdina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<Note> notesList;

    public NotesAdapter(Context context, ArrayList<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int position) {
        return notesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return notesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_note, parent, false);
        }

        Note note = notesList.get(position);
        TextView textId = convertView.findViewById(R.id.textId);
        TextView textDescription = convertView.findViewById(R.id.textDescription);

        textId.setText(String.valueOf(note.getId()));
        textDescription.setText(note.getDescription());

        return convertView;
    }
}

