package com.example.gestioncitas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registerdoctor extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registerdoctor);
        ed1 = (EditText) findViewById(R.id.editTextEmail);
        ed2 = (EditText) findViewById(R.id.editTextPassword);
        ed3 = (EditText) findViewById(R.id.colegiaturaDoc);
        ed4 = (EditText) findViewById(R.id.correoDoc);
        ed5 = (EditText) findViewById(R.id.contraDoc);
        b1 = (Button) findViewById(R.id.btnulogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });


    }


    public void insert()
    {
        try
        {
            String p_nombre = ed1.getText().toString();
            String p_apellido = ed2.getText().toString();
            String p_colegiatura = ed3.getText().toString();
            String p_correo = ed4.getText().toString();
            String p_contraseña = ed5.getText().toString();

            ProgressDialog progressDialog =new ProgressDialog(this);
            progressDialog.setMessage("cargando");


            if (p_nombre.isEmpty()){
                Toast.makeText(this,"Ingrese nombre",Toast.LENGTH_SHORT).show();
            }else if (p_apellido.isEmpty()){
                Toast.makeText(this,"Ingrese apellido",Toast.LENGTH_SHORT).show();
            }else if (p_colegiatura.isEmpty()){
                Toast.makeText(this,"Ingrese colegiatura",Toast.LENGTH_SHORT).show();
            }else if (p_correo.isEmpty()){
                Toast.makeText(this,"Ingrese correo",Toast.LENGTH_SHORT).show();
            }else if (p_contraseña.isEmpty()){
                Toast.makeText(this,"Ingrese contraseña",Toast.LENGTH_SHORT).show();
            }else {
                progressDialog.show();
                progressDialog.dismiss();
                StringRequest request =new StringRequest(Request.Method.POST, "http://192.168.56.1/crud_android2/insertar_.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(registerdoctor.this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), registerdoctor.class));
                                finish();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(registerdoctor.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
                ){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String>params=new HashMap<>();
                        params.put("nombre",p_nombre);
                        params.put("apellido",p_apellido);
                        params.put("colegiatura",p_colegiatura);
                        params.put("correo",p_correo);
                        params.put("contraseña",p_contraseña);

                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(registerdoctor.this);
                requestQueue.add(request);
            }
            Toast.makeText(this,"Doctor registrado",Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Verificar datos a ingresar",Toast.LENGTH_SHORT).show();
        }
    }



}