package com.erick.alura.imc.feature;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.erick.alura.imc.R;
import com.erick.alura.imc.model.Person;
import com.erick.alura.imc.util.AppFeedBackUI;
import com.erick.alura.imc.util.AppNavigateKeys;
import com.erick.alura.imc.util.CalculatorIMC;

public class MainActivity extends AppCompatActivity {

    TextView title;
    EditText editTextName, editTextHeight, editTextWeight;
    TextView textViewResult;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initUIComponents();
        setupListeners();
    }

    private void initUIComponents() {
        title = findViewById(R.id.title);
        textViewResult = findViewById(R.id.textView);
        editTextName = findViewById(R.id.editTextText);
        editTextWeight = findViewById(R.id.editTextPeso);
        editTextHeight = findViewById(R.id.editTextAltura);
        buttonCalculate = findViewById(R.id.button);
    }

    private void setupListeners(){
        buttonCalculate.setOnClickListener(view -> calculateIMC());
    }

    private void calculateIMC() {
       if (hasEmptyFields()) return;

       Person personCorporeData = getPerson();

       if(personCorporeData == null) return;
       String imcStatus = CalculatorIMC.getIMCStatus(personCorporeData);
       textViewResult.setText(imcStatus);
       navigateToReport();
    }

    private Person getPerson() {
        try {
            String name = editTextName.getText().toString();
            double height = Double.parseDouble(editTextHeight.getText().toString());
            double weight = Double.parseDouble(editTextWeight.getText().toString());
            return new Person(name, height, weight);
        } catch (NumberFormatException e ){
            AppFeedBackUI.showMessage(this, "Valor inválido ( Altura ou Peso )");
            return null;
        }
    }

    private void navigateToReport(){
        Intent intent = new Intent(this, Report.class);
        intent.putExtra(AppNavigateKeys.KEY_PERSON_NAME, editTextName.getText().toString());
        intent.putExtra(AppNavigateKeys.KEY_STATUS_IMC, textViewResult.getText().toString());
        intent.putExtra(AppNavigateKeys.KEY_IMC_VALUE, Double.parseDouble(editTextWeight.getText().toString()));
        startActivity(intent);
    }

    private boolean hasEmptyFields() {
        String name = editTextName.getText().toString().trim();
        String height = editTextHeight.getText().toString().trim();
        String weight = editTextWeight.getText().toString().trim();

        if (name.isEmpty()) {
            AppFeedBackUI.showMessage(this, "Nome não pode estar vazio");
            return true;
        }
        if (height.isEmpty()) {
            AppFeedBackUI.showMessage(this, "Altura não pode estar vazia");
            return true;
        }
        if (weight.isEmpty()) {
            AppFeedBackUI.showMessage(this, "Peso não pode estar vazio");
            return true;
        }
        return false;
    }
}