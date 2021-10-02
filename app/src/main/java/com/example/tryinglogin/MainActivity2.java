package com.example.tryinglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button selectButton,nextButton,exitButton;
    private TextView genderText, eduText;
    private RadioGroup radioGroup;
    private RadioButton genderButton;
    private CheckBox sscCheck, hscCheck, bscCheck;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        selectButton = findViewById(R.id.buttonID2);
        genderText = findViewById(R.id.gendertTextID);
        eduText = findViewById(R.id.educationTextID);
        radioGroup = findViewById(R.id.radioGroupID);
        sscCheck = findViewById(R.id.checkBox1ID);
        hscCheck = findViewById(R.id.checkBox2ID);
        bscCheck = findViewById(R.id.checkBox3ID);
        nextButton=findViewById(R.id.button3Id);
        exitButton=findViewById(R.id.exitButtonID);


        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                genderButton = findViewById(radioID);
                String value = genderButton.getText().toString();
                genderText.setText("*You have selected " + value);


                StringBuilder stringBuilder = new StringBuilder();
                if (sscCheck.isChecked()) {
                    String select = sscCheck.getText().toString();
                    stringBuilder.append(select + " is checked\n");
                }
                if (hscCheck.isChecked()) {
                    String select = hscCheck.getText().toString();
                    stringBuilder.append(select + " is checked\n");
                }
                if (bscCheck.isChecked()) {
                    String select = bscCheck.getText().toString();
                    stringBuilder.append(select + " is checked\n");
                }
                eduText.setText(stringBuilder);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);

            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder=new AlertDialog.Builder(MainActivity2.this);
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
                        Toast.makeText(MainActivity2.this,"Clicked No",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this,"Clicked Cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog= alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
}