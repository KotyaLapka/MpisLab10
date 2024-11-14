package com.example.lab5smerdina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentDel extends Fragment {
    private NotesDBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_del, container, false);

        EditText editTextId = view.findViewById(R.id.editTextId);
        Button buttonDel = view.findViewById(R.id.buttonDel);
        dbHelper = new NotesDBHelper(getContext());

        buttonDel.setOnClickListener(v -> {
            String idText = editTextId.getText().toString();
            if (!idText.isEmpty()) {
                int id = Integer.parseInt(idText);
                if (dbHelper.deleteNoteById(id)) {
                    Toast.makeText(getContext(), "Note deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Note not found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Please enter a valid ID", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

