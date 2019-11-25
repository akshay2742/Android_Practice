package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.user);
        e2=findViewById(R.id.pass);
        b1=findViewById(R.id.login);
        builder=new AlertDialog.Builder(getApplicationContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Field is Empty",Toast.LENGTH_SHORT).show();
                }
                if (e2.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                }
                if (!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty())
                {
                    Intent i=new Intent(getApplicationContext(),logout.class);
                    i.putExtra("USER",e1.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}
