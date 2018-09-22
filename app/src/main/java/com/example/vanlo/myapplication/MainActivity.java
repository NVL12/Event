package com.example.vanlo.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements OnClickListener{
    private EditText sa, sb;
    private Button tonghaiso;
    private TextView ketqua;

    private static int TIME_SPLASH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainInline.class);
                startActivity(intent);
                finish();
            }
        }, TIME_SPLASH);


        anhXa();
        //xử lí sự kiện bằng cách Activity is listener
        tonghaiso.setOnClickListener(this);
        ketqua.setOnClickListener(this); //xóa dữ liệu cũ để nhập dữ liệu mới
    }

    private void anhXa() {
        sa=(EditText)findViewById(R.id.hsa);
        sb=(EditText)findViewById(R.id.hsb);
        tonghaiso=(Button)findViewById(R.id.btngiai);
        ketqua=(TextView)findViewById(R.id.txtketqua);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btngiai: {
                if (sa.getText().toString().isEmpty() || sb.getText().toString().isEmpty()) {//bắt lỗi không nhập
                    Toast.makeText(MainActivity.this, "Input Please", Toast.LENGTH_SHORT).show();
                } else {
                    long a = Long.parseLong(sa.getText().toString());
                    long b = Long.parseLong(sb.getText().toString());
                    long tong = a + b;
                    ketqua.setText(String.valueOf(tong));
                }
            }
            break;

            case R.id.txtketqua: {
                sa.setText("");
                sb.setText("");
                ketqua.setText("");
                sa.requestFocus();
            }
            break;
        }
    }
}