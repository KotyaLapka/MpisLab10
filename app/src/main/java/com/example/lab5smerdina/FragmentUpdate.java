package com.example.lab5smerdina;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentUpdate extends Fragment {
    private NotesDBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        EditText editTextId = view.findViewById(R.id.editTextId);
        EditText editTextNewDescription = view.findViewById(R.id.editTextNewDescription);
        Button buttonUpdate = view.findViewById(R.id.buttonUpdate);
        dbHelper = new NotesDBHelper(getContext());

        buttonUpdate.setOnClickListener(v -> {
            String idText = editTextId.getText().toString();
            String newDescription = editTextNewDescription.getText().toString();
            if (!idText.isEmpty() && !newDescription.isEmpty()) {
                int id = Integer.parseInt(idText);
                if (dbHelper.updateNoteById(id, newDescription)) {
                    Toast.makeText(getContext(), "Note updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Note not found", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

