package com.erick.alura.imc.feature;

import static com.erick.alura.imc.model.StatusIMCEnum.OVERWEIGHT;
import static com.erick.alura.imc.model.StatusIMCEnum.UNDERWEIGHT;

import android.os.Bundle;
import android.view.View;
import com.erick.alura.imc.R;
import com.erick.alura.imc.util.AppNavigateKeys;

import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Report extends AppCompatActivity {

    TextView textViewName, textViewIMCValue, textViewResult;
    ImageView imageEvilBuu, imageFatBuu, imageSuperBuu;
    String name, statusIMC;
    Double imcValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_report);

        initUIComponents();
        getExtras();
        updateUIComponents();
        updateImageVisibilityByStatus();
    }

    private void initUIComponents() {
       textViewName = findViewById(R.id.textViewNome);
       textViewIMCValue = findViewById(R.id.textViewIMCValue);
       textViewResult = findViewById(R.id.textViewResultado);
        imageEvilBuu = findViewById(R.id.imageEvilBuu);
        imageFatBuu = findViewById(R.id.imageFatBuu);
        imageSuperBuu = findViewById(R.id.imageSuperBuu);
        hideAllImages();
    }

    private void hideAllImages() {
        imageEvilBuu.setVisibility(View.GONE);
        imageFatBuu.setVisibility(View.GONE);
        imageSuperBuu.setVisibility(View.GONE);
    }

    private void getExtras(){
        Intent intent = getIntent();
        name = intent.getStringExtra(AppNavigateKeys.KEY_PERSON_NAME);
        imcValue = intent.getDoubleExtra(AppNavigateKeys.KEY_IMC_VALUE, 0);
        statusIMC = intent.getStringExtra(AppNavigateKeys.KEY_STATUS_IMC);
    }

    public void updateUIComponents(){
        textViewName.setText(name);
        textViewIMCValue.setText(String.format("%.2f", imcValue));
        textViewResult.setText(statusIMC);
    }

    private void updateImageVisibilityByStatus(){

        if (statusIMC.equals(OVERWEIGHT.getDescription())) {
            imageFatBuu.setVisibility(View.VISIBLE);
            return;
        }
        if (statusIMC.equals(UNDERWEIGHT.getDescription())) {
            imageEvilBuu.setVisibility(View.VISIBLE);
            return;
        }
        imageSuperBuu.setVisibility(View.VISIBLE);
    }
}
