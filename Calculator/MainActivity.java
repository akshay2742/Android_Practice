package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tx;
    int a,b;
    float n;
    String s1;
    String s;
    Button bt;
    Button bt1;
    Button bt2;
    Button bt3;

    EditText ed;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ed= findViewById(R.id.editText);
        ed1= findViewById(R.id.editText2);


         tx= findViewById(R.id.textView);
         bt =findViewById(R.id.button);
        bt1 =findViewById(R.id.button1);
        bt2 =findViewById(R.id.button2);
        bt3 =findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=ed.getText().toString();
                s1=ed1.getText().toString();
                n= Integer.parseInt(s)+Integer.parseInt(s1);
                tx.setText(String.valueOf(n));
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                s=ed.getText().toString();
                s1=ed1.getText().toString();
                n= Integer.parseInt(s)-Integer.parseInt(s1);
                tx.setText(String.valueOf(n));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                s=ed.getText().toString();
                s1=ed1.getText().toString();
                n= Integer.parseInt(s)*Integer.parseInt(s1);
                tx.setText(String.valueOf(n));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                s=ed.getText().toString();
                s1=ed1.getText().toString();
                a=Integer.parseInt(s);
                b=Integer.parseInt(s1);


                    n= Float.parseFloat(s)/Integer.parseInt(s1);

                tx.setText(String.valueOf(n));
            }
        });
    }
}
