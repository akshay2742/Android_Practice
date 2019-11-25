package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    RadioButton r1;
    RadioButton r2;
    TextView t1;
    Button b1;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        c1=findViewById(R.id.checkBox2);
        c2=findViewById(R.id.checkBox3);
        c3=findViewById(R.id.checkBox4);
        r1=findViewById(R.id.radioButton3);
        r2=findViewById(R.id.radioButton4);
        b1=findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c1.isChecked())
                {
                    c+=100;
                }
                if(c2.isChecked())
                {
                    c+=200;
                }
                if(c3.isChecked())
                {
                    c+=300;
                }

                t1=findViewById(R.id.textView4);

                if(r1.isChecked())
                {
                    c-=20;
                }
                if(r2.isChecked())
                {
                    c+=0;
                }
                t1.setText(String.valueOf(c));
            }
        });
    }


}
