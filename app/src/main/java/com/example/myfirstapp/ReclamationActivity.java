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
import androidx.room.Room;

import java.util.ArrayList;

public class ReclamationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reclamation);

        EditText editTitle = findViewById(R.id.edtTitre);
        EditText editDescription = findViewById(R.id.edtDescription);
        Button btnAjouter = findViewById(R.id.btnAjouter);
        RecyclerView recyclerView = findViewById(R.id.recyclerReclamations);

        //initialisation of database
        AppDataBase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDataBase.class,
                "syndic_db").allowMainThreadQueries().build();

        //get all reclamations from database
        ArrayList<Reclamation> listeReclamations = new ArrayList<>(db.reclamationDao().getAll());

        ReclamationAdapter adapter = new ReclamationAdapter(listeReclamations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAjouter.setOnClickListener(v -> {
            String title = editTitle.getText().toString();
            String description = editDescription.getText().toString();

            if(title.isEmpty() || description.isEmpty()){
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            } else {
                Reclamation reclamation = new Reclamation(title, description);
                db.reclamationDao().add(reclamation);

                //downloading the alerts
                listeReclamations.clear();
                listeReclamations.addAll(db.reclamationDao().getAll());

                adapter.notifyDataSetChanged();

                editTitle.setText("");
                editDescription.setText("");

                recyclerView.scrollToPosition(listeReclamations.size() - 1);

                Toast.makeText(this, "New alert added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}