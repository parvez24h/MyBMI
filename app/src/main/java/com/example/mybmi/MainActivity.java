package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText weightET, heightET;
    Button testBTN;
    TextView resultTV;

    String bmiStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        weightET = findViewById(R.id.weightET);
        heightET = findViewById(R.id.heightET);
        testBTN = findViewById(R.id.testBTN);
        resultTV = findViewById(R.id.resultTV);

        testBTN.setOnClickListener(view->{ bmiCalculate(); });

    }

    public void bmiCalculate() {
        String weight = weightET.getText().toString();
        String height = heightET.getText().toString();
        if (weight.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Weight", Toast.LENGTH_SHORT).show();
        } else if (height.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter your Height", Toast.LENGTH_SHORT).show();
        } else {

            double weight_Value = Double.parseDouble(weight);
            double height_Value = Double.parseDouble(height);
            double meter_convert = 0.3048 * height_Value;
            double meter_square = meter_convert * meter_convert;


            double result = weight_Value / meter_square;

            if (result<18.5){
                bmiStatus = "Underweight";
            }else if (result<25){
                bmiStatus = "Healthy Weight";
            }else if (result<30){
                bmiStatus = "Overweight";
            }else {
                bmiStatus = "Obese";
            }

            resultTV.setText("Result:  "+String.format("%.2f", result)+"\n"+"Health Status: " + bmiStatus);



        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}