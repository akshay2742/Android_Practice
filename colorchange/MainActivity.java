package com.example.colorchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.blue);
        b2=findViewById(R.id.green);
        b3=findViewById(R.id.red);

        view=this.getWindow().getDecorView();


    }

    public void setblue(View v)
    {
        view.setBackgroundResource(R.color.colorAccent);
    }
    public void setgreen(View v)
    {
        view.setBackgroundResource(R.color.colorPrimary);
    }
    public void setred(View v)
    {
        view.setBackgroundResource(R.color.colorPrimaryDark);
    }
}
