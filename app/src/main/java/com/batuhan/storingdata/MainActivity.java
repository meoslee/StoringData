package com.batuhan.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText editText2;
    TextView resultText;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.batuhan.storingdata", Context.MODE_PRIVATE);

        editText2 = findViewById(R.id.editText2);

        resultText = findViewById(R.id.textView);

        int StoredAge =sharedPreferences.getInt("StoredAge",0);

        if(StoredAge == 0) {
            resultText.setText("Your Age = ");
        }else {
            resultText.setText("Your Age = " + StoredAge);
        }
    }

    public void save (View view){
        if (editText2.getText().toString().matches("")){
            resultText.setText("Enter Age !");
        }else {
            int ageText = Integer.parseInt(editText2.getText().toString());
            int result = ageText;
            resultText.setText("Your Age = " + result);
            sharedPreferences.edit().putInt("StoredAge", ageText).apply();
        }


    }

    public void delete(View view){
        int storedData = sharedPreferences.getInt("StoredAge",0);
        //!= eşit değil ise
        if (storedData != 0){
            sharedPreferences.edit().remove("StoredAge").apply();
            resultText.setText("Your Age = ");
        }


    }
}