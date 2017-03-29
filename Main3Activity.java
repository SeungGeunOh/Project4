package com.example.oh.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Intent intent;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("목차");

        text = (TextView) findViewById(R.id.textView);
        registerForContextMenu(text);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == text)
            getMenuInflater().inflate(R.menu.menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu1 :
                intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu2 :
                intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
