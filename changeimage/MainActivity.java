package com.example.changeimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private static ImageView imgview;
    private static Button buttonsbm;
    private int current_image;
    int[] images={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonclick();
    }
        public void buttonclick()
        {
            imgview=findViewById(R.id.imageview);
            buttonsbm=findViewById(R.id.button);
            buttonsbm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    current_image++;
                    current_image=current_image % images.length;
                    imgview.setImageResource(images[current_image]);
                }
            });
        }
}

