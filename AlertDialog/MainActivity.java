package com.example.alertdialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"Toast Message",Toast.LENGTH_LONG).show();
    }
    public void save (View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Save Changes?");
        alert.setMessage("Do you want to save the changes made?");

        alert.setPositiveButton("Yes" , new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNeutralButton("Cancel", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Cancelled" ,Toast.LENGTH_SHORT);
            }
        });

        alert.show();
    }
}

