package com.example.segundasemana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle param = getIntent().getExtras();
        String nombre = param.getString("NOMBRE_COMPLETO");
        String fecha = param.getString("FECHA_SELECCIONADA");
        String telefono = param.getString("TELEFONO");
        String email = param.getString("EMAIL");
        String descripcion = param.getString("DESCRIPCION");

        tvNombre = (TextView) (findViewById(R.id.tvNombreConfirmarDatos));
        tvFecha = (TextView) (findViewById(R.id.tvFechaConfirmarDatos));
        tvTelefono = (TextView) (findViewById(R.id.tvTelefonoConfirmarDatos));
        tvEmail = (TextView) (findViewById(R.id.tvEmailConfirmarDatos));
        tvDescripcion = (TextView) (findViewById(R.id.tvDescripcionConfirmarDatos));

        tvNombre.setText("Nombre Completo: " + nombre);
        tvFecha.setText("Fecha Nacimiento: " + fecha);
        tvTelefono.setText("Telefono: " + telefono);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripcion:: " + descripcion);
    }
}