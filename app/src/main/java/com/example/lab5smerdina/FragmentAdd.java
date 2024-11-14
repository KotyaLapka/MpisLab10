package com.example.lab5smerdina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentAdd extends Fragment {
    private NotesDBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        dbHelper = new NotesDBHelper(getContext());

        buttonAdd.setOnClickListener(v -> {
            String description = editTextDescription.getText().toString();
            if (dbHelper.addNote(description)) {
                Toast.makeText(getContext(), "Note added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
