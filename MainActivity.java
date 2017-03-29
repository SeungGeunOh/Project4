package com.example.oh.project4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    LinearLayout linear;
    TextView cText, sText;
    boolean vi = false;
    int index = 0;
    int num = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴");

        image = (ImageView) findViewById(R.id.imageView);
        linear = (LinearLayout) findViewById(R.id.linear);
        cText = (TextView) findViewById(R.id.textView);
        sText = (TextView) findViewById(R.id.textView2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.mnRed:
                linear.setBackgroundColor(Color.RED);
                cText.setTextColor(Color.BLUE);
                sText.setTextColor(Color.BLUE);
                break;
            case R.id.mnBlue:
                linear.setBackgroundColor(Color.BLUE);
                cText.setTextColor(Color.YELLOW);
                sText.setTextColor(Color.YELLOW);
                break;
            case R.id.mnYellow:
                linear.setBackgroundColor(Color.YELLOW);
                cText.setTextColor(Color.RED);
                sText.setTextColor(Color.RED);
                break;
            case R.id.rotation:
                image.setRotation(num);
                num += 30;
                break;
            case R.id.visible:
                if (index == 0)
                    break;
                if (item.isChecked() == true) {
                    sText.setVisibility(View.INVISIBLE);
                    cText.setVisibility(View.INVISIBLE);
                    vi = false;
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                    if (index == 1) {
                        cText.setVisibility(View.VISIBLE);
                        sText.setVisibility(View.INVISIBLE);

                    } else if (index == 2) {
                        sText.setVisibility(View.VISIBLE);
                        cText.setVisibility(View.INVISIBLE);
                    }
                    vi = true;
                }
                break;
            case R.id.expand:
                if (index == 0)
                    break;
                if (item.isChecked() == true) {
                    image.setScaleX(1);
                    image.setScaleY(1);
                    item.setChecked(false);
                }
                else {
                    image.setScaleX(2);
                    image.setScaleY(2);
                    item.setChecked(true);
                }
                break;
            case R.id.chicken :
                item.setChecked(true);
                image.setImageResource(R.drawable.chicken);
                image.setRotation(0);
                image.setVisibility(View.VISIBLE);
                index = 1;
                check();
                break;
            case R.id.spaghetti :
                item.setChecked(true);
                image.setImageResource(R.drawable.spaghetti);
                image.setRotation(0);
                image.setVisibility(View.VISIBLE);
                index = 2;
                check();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void check(){
        if (index == 1 && vi == true) {
            image.setImageResource(R.drawable.chicken);
            cText.setVisibility(View.VISIBLE);
            sText.setVisibility(View.INVISIBLE);
        }
        else if (index == 2 && vi == true){
            image.setImageResource(R.drawable.spaghetti);
            sText.setVisibility(View.VISIBLE);
            cText.setVisibility(View.INVISIBLE);
        }
    }


}
