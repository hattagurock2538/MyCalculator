package com.example.a10305_6.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.w3c.dom.Text;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private RadioGroup radioGroup;
    private String strTemperature ,strTem = "Celsius",strAnswer ;
    private double douAnswer;
    private HataDialogAlert alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText3);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    strTemperature = editText.getText().toString().trim();
                    if (strTemperature.equals("")) {
                        Log.d("wachirawit", "Have space in blank ");
                        alertDialog = new HataDialogAlert();
                        alertDialog.HavespaceDialog(MainActivity.this);
                        //Intent intent1 = new Intent(MainActivity.this, Result.class);
                        //startActivity(intent1);

                    } else {
                        Log.d("wachirawit", "No space =" + strTemperature);
                        Intent intent = new Intent(MainActivity.this, com.example.a10305_6.myapplication.Result.class);
                       // Intent intent1 = new Intent(MainActivity.this, Result.class);
                        startActivity(intent);
                    }
                    if (strTem=="Celsius") {
                        calculateAnswer();

                        alertDialog= new HataDialogAlert ();
                        alertDialog.ShowAnwer(MainActivity.this,strTemperature,strAnswer,strTem);
                        Intent intent = new Intent(MainActivity.this, Result.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }
                    if (strTem=="Fahrenheit") {
                        calculateAnswer1();

                        alertDialog.ShowAnwer(MainActivity.this,strTemperature,strAnswer,strTem);
                        Intent intent = new Intent(MainActivity.this, Result.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }

                    if (strTem=="Kelvin") {
                        calculateAnswer2();
                        alertDialog.ShowAnwer(MainActivity.this,strTemperature,strAnswer,strTem);
                        Intent intent = new Intent(MainActivity.this, Result.class);
                        intent.putExtra("Temperature", strTemperature);
                        intent.putExtra("Unit", strTem);
                        intent.putExtra("Answer", strAnswer);
                        startActivity(intent);
                    }

                }catch (Exception e){}

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.Celsius:
                                strTem ="Celsius";
                                break;

                            case R.id.Fahrenheit:
                                strTem ="Fahrenheit";
                                break;

                            case R.id.Kelvin:
                                strTem ="Kelvin";
                                break;

                        }

                    }
                });





            }
        });


    }
    private void calculateAnswer(){
        douAnswer = Double.parseDouble(strTemperature);
        strAnswer = Double.toString(douAnswer);
    }
    private void calculateAnswer1(){
        douAnswer = Double.parseDouble(strTemperature)*1.8+32;
        strAnswer = Double.toString(douAnswer);
    }
    private void calculateAnswer2(){
        douAnswer = Double.parseDouble(strTemperature)+273.15;
        strAnswer = Double.toString(douAnswer);
    }


}