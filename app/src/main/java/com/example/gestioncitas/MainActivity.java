package com.example.gestioncitas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.btnulogin);
        TextView logindoc = findViewById(R.id.iniciardoc);
        TextView regisus = findViewById(R.id.regisUsuario);



        //registrarse como usuario
        regisus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registerUsuario.class);
                startActivity(intent);
            }
        });
        //iniciar sesion al panel de doctor
       logindoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginDoctor.class);
                startActivity(intent);
            }
        });


    }
}