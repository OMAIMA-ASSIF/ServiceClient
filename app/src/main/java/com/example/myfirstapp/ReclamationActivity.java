package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReclamationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reclamation);

        EditText edtTitre = findViewById(R.id.edtTitre);
        EditText edtDescription = findViewById(R.id.edtDescription);
        Button btnAjouter = findViewById(R.id.btnAjouter);

        RecyclerView recyclerView = findViewById(R.id.recyclerReclamations);

        ArrayList<Reclamation> listeReclamations = new ArrayList<>();
        listeReclamations.add(new Reclamation("Basement", "Parking cleaning"));
        listeReclamations.add(new Reclamation("Apartment 12", "Water leak"));
        listeReclamations.add(new Reclamation("Block B", "Elevator out of order"));
        listeReclamations.add(new Reclamation("Hallway 2", "Lighting issue"));
        listeReclamations.add(new Reclamation("Main entrance", "Broken door"));
        listeReclamations.add(new Reclamation("Parking lot", "Non-functional camera"));

        ReclamationAdapter adapter = new ReclamationAdapter(listeReclamations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAjouter.setOnClickListener(v -> {
            String titre = edtTitre.getText().toString();
            String description = edtDescription.getText().toString();
            if(titre.isEmpty() || description.isEmpty()){
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            }else{
                listeReclamations.add(new Reclamation(description, titre));
                adapter.notifyDataSetChanged();
                edtTitre.setText("");
                edtDescription.setText("");
                Toast.makeText(this, "New alert added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}