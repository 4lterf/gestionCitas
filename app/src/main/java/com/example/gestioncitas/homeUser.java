package com.example.gestioncitas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class homeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Configuración para pantalla completa si es necesario
        setContentView(R.layout.activity_home_user); // Establece el layout

        // Referencias a los ImageView existentes
        ImageView imgCalen = findViewById(R.id.imagecalenUser);
        ImageView imgCit = findViewById(R.id.imageView2);
        ImageView imgHis = findViewById(R.id.imageView3);

        // Nueva referencia para el ImageView de perfil
        ImageView homePerfil = findViewById(R.id.homePerfil);

        ImageView imageView7 = findViewById(R.id.imageView7);


        // Configura los OnClickListener para cada imagen
        imgCalen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeUser.this, gestion_agenda.class);
                startActivity(intent);
            }
        });

        imgCit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeUser.this, gestio_cita.class);
                startActivity(intent);
            }
        });

        imgHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homeUser.this, historial_citasUs.class);
                startActivity(intent);
            }
        });

        // Nuevo OnClickListener para el icono de perfil
        homePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad de perfil al hacer clic en la imagen de perfil
                Intent intent = new Intent(homeUser.this, perfilUs.class);
                startActivity(intent);
            }
        });



        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad de perfil al hacer clic en la imagen de perfil
                Intent intent = new Intent(homeUser.this, soporte.class);
                startActivity(intent);
            }
        });

    }
}