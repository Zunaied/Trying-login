package com.example.tryinglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    private TextView dateTextView;
    private Button selectButton,exitButton;
    private DatePickerDialog datePickerDialog;
    private AnalogClock analogClock;
    private TextClock textClock;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dateTextView = findViewById(R.id.textView4);
        selectButton = findViewById(R.id.selectDateID);
        analogClock=findViewById(R.id.analogClockID);
        textClock= findViewById(R.id.textClockID);
        exitButton= findViewById(R.id.exitButtonID);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);
        exitButton.setOnClickListener(this);




        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker datePicker=new DatePicker(MainActivity3.this);
                int currentYear= datePicker.getYear();
                int currentMonth= datePicker.getMonth();
                int currentDay= datePicker.getDayOfMonth();

                datePickerDialog=new DatePickerDialog(MainActivity3.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateTextView.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                    }
                },currentYear,currentMonth,currentDay);
                datePickerDialog.show();
            }
        });



    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.analogClockID){
            Toast.makeText(MainActivity3.this,"Analog clock is clicked",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.textClockID){
            Toast.makeText(MainActivity3.this,"Text clock is clicked",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.exitButtonID){
            alertDialogBuilder=new AlertDialog.Builder(MainActivity3.this);
            alertDialogBuilder.setTitle(R.string.alert_title);
            alertDialogBuilder.setMessage(R.string.alert_message);
            alertDialogBuilder.setIcon(R.drawable.alert_dialog);
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity3.this,"Clicked No",Toast.LENGTH_SHORT).show();
                }
            });
            alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity3.this,"Clicked Cancel",Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog alertDialog= alertDialogBuilder.create();
            alertDialog.show();



        }
    }
}