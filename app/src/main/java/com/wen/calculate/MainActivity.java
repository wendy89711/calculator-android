package com.wen.calculate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView edName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button();
            }
        });

    }

    private void button() {
        if (!TextUtils.isEmpty(edName.getText().toString())) {
            String username = edName.getText().toString();
            Intent intent = new Intent(this, CalcuActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
        } else {
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("請填寫姓名！")
                    .setPositiveButton("OK", null)
                    .show();

        }
    }
}