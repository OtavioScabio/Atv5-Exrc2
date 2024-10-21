package com.example.atv5_exrc2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/*Otavio Gabriel Ribeiro Scabio - 1110482223043*/

public class MainActivity extends AppCompatActivity {

    private EditText editTextBits;
    private RadioGroup radioGroupUnidade;
    private Button buttonConverter;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextBits = findViewById(R.id.editTextBits);
        radioGroupUnidade = findViewById(R.id.radioGroupUnidade);
        buttonConverter = findViewById(R.id.buttonConverter);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonConverter.setOnClickListener(op->converter());
    }

    private void converter() {
        String input = editTextBits.getText().toString();
        if (input.isEmpty()) {
            textViewResultado.setText("Por favor, insira um valor em bits.");
            return;
        }

        long bits = Long.parseLong(input);
        double resultado = 0.0;

        int selectedId = radioGroupUnidade.getCheckedRadioButtonId();

        if (selectedId == R.id.radioBytes) {
            resultado = bits / 8.0;
            textViewResultado.setText(String.format("Resultado: %.2f Bytes", resultado));
        } else if (selectedId == R.id.radioKB) {
            resultado = bits / 8192.0; // 1 KB = 8 * 1024 bits
            textViewResultado.setText(String.format("Resultado: %.2f KB", resultado));
        } else if (selectedId == R.id.radioMB) {
            resultado = bits / 8388608.0; // 1 MB = 8 * 1024^2 bits
            textViewResultado.setText(String.format("Resultado: %.2f MB", resultado));
        } else if (selectedId == R.id.radioGB) {
            resultado = bits / 8589934592.0; // 1 GB = 8 * 1024^3 bits
            textViewResultado.setText(String.format("Resultado: %.2f GB", resultado));
        } else if (selectedId == R.id.radioTB) {
            resultado = bits / 8796093022208.0; // 1 TB = 8 * 1024^4 bits
            textViewResultado.setText(String.format("Resultado: %.2f TB", resultado));
        } else {
            textViewResultado.setText("Por favor, selecione uma unidade.");
        }
    }

}