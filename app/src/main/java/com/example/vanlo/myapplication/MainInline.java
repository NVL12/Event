package com.example.vanlo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainInline extends AppCompatActivity {
    private EditText sa, sb;
    private Button tonghaiso;
    private TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inline);
        anhXa();
        tonghaiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLiSuKienInline();
            }
        });
        ketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaDuLieu();
            }
        });
    }

    private void xoaDuLieu() {
        sa.setText("");
        sb.setText("");
        ketqua.setText("");
        sa.requestFocus();
    }

    private void xuLiSuKienInline() {
        if (sa.getText().toString().isEmpty() || sb.getText().toString().isEmpty()) {//bắt lỗi không nhập
            Toast.makeText(MainInline.this, "Input Please", Toast.LENGTH_LONG).show();
        } else {
            long a = Long.parseLong(sa.getText().toString());
            long b = Long.parseLong( sb.getText().toString());
            long tong = a + b;
            ketqua.setText(String.valueOf(tong));
        }
    }


    private void anhXa() {
        sa=(EditText)findViewById(R.id.hsa);
        sb=(EditText)findViewById(R.id.hsb);
        tonghaiso=(Button)findViewById(R.id.btngiai);
        ketqua=(TextView)findViewById(R.id.txtketqua);
    }
}