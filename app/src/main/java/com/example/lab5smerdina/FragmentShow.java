package com.example.lab5smerdina;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class FragmentShow extends Fragment {
    private NotesDBHelper dbHelper;
    private ArrayList<Note> notesList;
    private NotesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        ListView listView = view.findViewById(R.id.listViewNotes);
        dbHelper = new NotesDBHelper(getContext());
        notesList = new ArrayList<>();



        adapter = new NotesAdapter(getContext(), notesList);
        listView.setAdapter(adapter);

        ImageButton refreshButton = view.findViewById(R.id.reloadBtn);
        refreshButton.setOnClickListener(v -> loadNotes());

        loadNotes();


        return view;
    }

    private void loadNotes() {
        Cursor cursor = dbHelper.getAllNotes();
        if (cursor != null && cursor.moveToFirst()) {
            notesList.clear();
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                notesList.add(new Note(id, description));
            } while (cursor.moveToNext());
            cursor.close();
        }
    }

}

