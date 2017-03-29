package com.example.oh.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TabHost tabHost;
    EditText Height, Weight, PorS;
    TextView Result1, Result2;
    Button Bmi, Square, Pyeung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("면적계산기");

        tabHost = (TabHost) findViewById(R.id.TabHost);
        Height = (EditText) findViewById(R.id.editText);
        Weight = (EditText) findViewById(R.id.editText2);
        PorS = (EditText) findViewById(R.id.editText3);
        Result1 = (TextView) findViewById(R.id.textView3);
        Result2 = (TextView) findViewById(R.id.textView9);
        Bmi = (Button) findViewById(R.id.button);
        Square = (Button) findViewById(R.id.button2);
        Pyeung = (Button) findViewById(R.id.button3);

        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.tab1).setIndicator("BMI 계산기"));
        tabHost.addTab(tabHost.newTabSpec("").setContent(R.id.tab2).setIndicator("면적 계산기"));

        Bmi.setOnClickListener(this);
        Square.setOnClickListener(this);
        Pyeung.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String height = Height.getText().toString();
                String weight = Weight.getText().toString();
                if (height.length() == 0 || weight.length() == 0) {
                    Result1.setText("값을 입력해주세요.");
                    Height.setText(null);
                    Weight.setText(null);
                }
                else if (Integer.parseInt(height) > 300 || Integer.parseInt(weight) > 300) {
                    Result1.setText("다시 입력해주세요. (300이하)");
                    Height.setText(null);
                    Weight.setText(null);
                }
                else {
                    double result = (Integer.parseInt(weight) / Math.pow(Integer.parseInt(height), 2)) * 10000;
                    BmiCheck(result);
                }
                break;
            case R.id.button2:
                String square = PorS.getText().toString();
                if (square.length() == 0) {
                    Result2.setText(" 값을 입력해주세요.");
                    PorS.setText(null);
                }
                else {
                    double result = Integer.parseInt(square) * 3.305785;
                    Result2.setText(String.format("%.6f 제곱미터", result));
                }
                break;
            case R.id.button3:
                String pyeung = PorS.getText().toString();
                if (pyeung.length() == 0) {
                    Result2.setText(" 값을 입력해주세요.");
                    PorS.setText(null);
                }
                else {
                    double result = Integer.parseInt(pyeung) * 0.3025;
                    Result2.setText(String.format("%.4f 평", result));
                }
                break;

        }
    }
    void BmiCheck(double result) {
        if (result < 18.5)
            Result1.setText("저체중 입니다.");
        else if (result < 23.0)
            Result1.setText("정상 입니다.");
        else if (result < 25.0)
            Result1.setText("과체중 입니다.");
        else
            Result1.setText("비만 입니다.");
    }

}


