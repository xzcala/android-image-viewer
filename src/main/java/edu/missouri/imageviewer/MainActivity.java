package edu.missouri.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewer;
    private Button previousButton;
    private Button nextButton;
    private TextView indexTextView;
    private int index=0;
    private int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewer = findViewById(R.id.imageViewer);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        indexTextView = findViewById(R.id.indexTextView);
        previousButton.setEnabled(false);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                nextButton.setEnabled(true);
                if(index==0){
                    previousButton.setEnabled(false);
                }
                imageViewer.setImageResource(images[index]);
                indexTextView.setText(Integer.toString(index+1)+"/3");
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                previousButton.setEnabled(true);
                if(index==2){
                    nextButton.setEnabled(false);
                }
                imageViewer.setImageResource(images[index]);
                indexTextView.setText(Integer.toString(index+1)+"/3");
            }
        });
    }
}
