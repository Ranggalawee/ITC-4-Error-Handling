package com.example.debuggingerrorhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvHeader, tvNama, tvNomor, tvFinal;
    EditText etNama, etNomor;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_Nama);
        etNomor = findViewById(R.id.et_Nomor);
        btnEnter = findViewById(R.id.btn_Enter);
        tvFinal = findViewById(R.id.tv_Final);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            // Saat click enter, jika nomor tempat duduk tersedia, maka tidak akan muncul Toast apapun
            @Override
            public void onClick(View v) {
                int nomor = 200;
                // deklarasi di atas 100 agar setText di bawah tidak muncul saat input karakter huruf batas
                try {
                    nomor = Integer.parseInt(etNomor.getText().toString());
                    if (nomor > 100) {
                        // Batas nomor tempat duduk hanya sampai 100, jika di atas itu maka dinyatakan habis
                        throw new IllegalArgumentException();
                    }
                }
                catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Input harus dalam bentuk angka.", Toast.LENGTH_SHORT).show();
                }
                catch (IllegalArgumentException e){
                    Toast.makeText(MainActivity.this, "Nomor tempat duduk sudah habis.", Toast.LENGTH_SHORT).show();
                }

                if (nomor <= 100 && nomor >= 0){
                    tvFinal.setText("Tempat duduk berhasil dipesan.");
                }
                else {
                    tvFinal.setText("");
                }
            }
        });
    }
}