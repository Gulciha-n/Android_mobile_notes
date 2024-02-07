package com.example.storingdata;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class sharedPreferences extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // XML dosyasına bağlanır
        editText = findViewById(R.id.editTextNumber); //editText objesi uzerinden, XML dosyasındaki editTextNumber ogesini bul
        textView = findViewById(R.id.textMessage);

        sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("savedAge",0);

        if (storedAge == 0){
            textView.setText("Your age : ");
        }
        else{
            textView.setText("Your age : "+ storedAge);
        }

    }
    public void save(View view){
            if (!editText.getText().toString().matches("")){
                int userAge = Integer.parseInt(editText.getText().toString());
                textView.setText("Your age : " + userAge);
                sharedPreferences.edit().putInt("savedAge",userAge).apply();
            }
    }
    public  void delete(){

        int  storedData = sharedPreferences.getInt("storedAge",0);

        if (storedData != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age : ");
        }
    }
}
