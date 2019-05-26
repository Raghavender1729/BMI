package com.example.bodymassindex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<charSequence> extends AppCompatActivity implements View.OnClickListener {

    private double a=0;
    private double m=0;
    private double h=0;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private EditText editText1;
    private EditText editText2;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        linear3 = (LinearLayout)findViewById(R.id.linear3);
        linear4 = (LinearLayout)findViewById(R.id.linear4);
        linear5 = (LinearLayout)findViewById(R.id.linear5);
        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview2);
        textView3 = (TextView)findViewById(R.id.textview3);
        editText1 = (EditText)findViewById(R.id.edittext1);
        editText2 = (EditText)findViewById(R.id.edittext2);
        button1 = (Button)findViewById(R.id.button1);

        linear3.setVisibility(View.INVISIBLE);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1){
            if (!(editText1.getText().toString().equals("")||editText2.getText().toString().equals(""))){
                m = Double.parseDouble(editText1.getText().toString());
                h = Double.parseDouble(editText2.getText().toString())/100;
                a = m/(h*h);
                textView2.setText(String.valueOf((long)(a)));
                textView2.setTextColor(0xFF000000);
                if (a<18){
                    textView3.setText("UnderWeight");
                    linear2.setBackgroundColor(0xFF4FC3F7);
                }
                else if (a>25){
                    textView3.setText("Overweight");
                    linear2.setBackgroundColor(0xFFEF5350);
                    }
                else {
                    textView3.setText("Normal");
                    linear2.setBackgroundColor(0xFF8BC34A);
                }
                linear3.setVisibility(View.VISIBLE);
            }
            else {
                Context context = getApplicationContext();
                String text = "Invalid inputs";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text ,duration);
                toast.show();
            }
        }
    }
}
