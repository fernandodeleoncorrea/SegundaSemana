package com.example.segundasemana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private Button pickerNacimiento;
    private Button btnSiguiente;


    private TextInputLayout NombreCompleto;

    private TextView FechaSeleccionada;
    private TextInputLayout Telefono;
    private TextInputLayout Email;
    private TextInputLayout Descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //boton pantalla confirmar datos
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                NombreCompleto = findViewById(R.id.tvNombreCompleto);
                FechaSeleccionada = findViewById(R.id.tvFechaSeleccionada);
                Telefono = findViewById(R.id.tvTelefono);
                Email = findViewById(R.id.tvEmail);
                Descripcion = findViewById(R.id.tvDescripcion);

                String strNombreCompleto = NombreCompleto.getEditText().getText().toString();
                String strFechaSeleccionada = FechaSeleccionada.getText().toString();
                String strTelefono = Telefono.getEditText().getText().toString();
                String strEmail = Email.getEditText().getText().toString();
                String strDescripcion = Descripcion.getEditText().getText().toString();

                intent.putExtra("NOMBRE_COMPLETO", strNombreCompleto);
                intent.putExtra("FECHA_SELECCIONADA", strFechaSeleccionada);
                intent.putExtra("TELEFONO", strTelefono);
                intent.putExtra("EMAIL", strEmail);
                intent.putExtra("DESCRIPCION", strDescripcion);
                startActivity(intent);
            }
        });

        //picker de fecha
        pickerNacimiento = findViewById(R.id.pickerNacimiento);
        FechaSeleccionada = findViewById(R.id.tvFechaSeleccionada);

        MaterialDatePicker.Builder constructorPicker = MaterialDatePicker.Builder.datePicker();
        constructorPicker.setTitleText("Fecha Nacimiento");
        MaterialDatePicker picker = constructorPicker.build();

        pickerNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                FechaSeleccionada.setText(picker.getHeaderText());
            }
        });
    }


}