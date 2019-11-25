package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    database db;
    EditText e1,e2,e3,e4;
    Button b1,b2,b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.surname);
        e3=findViewById(R.id.marks);
        e4=findViewById(R.id.idtext);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.viewall);
        b3=findViewById(R.id.update);
        b4=findViewById(R.id.delete);
        db=new database(this);
        add_data();
        viewalldata();
        updatedata();
        deletedata();
    }

    public void add_data()
    {


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isinserted=db.insertdata(e1.getText().toString(),e2.getText().toString(),e3.getText().toString());

                if(isinserted=true)
                    Toast.makeText(getApplicationContext(),"Data is Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data is not inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void viewalldata()
    {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=db.getAlldata();
                if (res.getCount()==0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer st=new StringBuffer();
                while (res.moveToNext())
                {
                    st.append("Id: "+res.getString(0)+"\n");
                    st.append("Name: "+res.getString(1)+"\n");
                    st.append("Surname: "+res.getString(2)+"\n");
                    st.append("Marks: "+res.getString(3)+"\n\n");
                }
                showMessage("Data",st.toString());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void updatedata()
    {
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isupdate=db.updatedata(e4.getText().toString(),e1.getText().toString(),e2.getText().toString(),e3.getText().toString());
                if(isupdate==true)
                {
                    Toast.makeText(getApplicationContext(),"Data is Updated",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data is not Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void deletedata()
    {
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleterows=db.deletedata(e4.getText().toString());
                if (deleterows>0)
                {
                    Toast.makeText(getApplicationContext(),"Rows are Left",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Rows are not Left",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
