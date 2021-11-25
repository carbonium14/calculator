package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView screen;
    private Button btn0,btn1,btn2,btn3,btn4,
                    btn5,btn6,btn7,btn8,btn9,
                    btnadd,btnsub,btnmul,btndiv,
                    btnans,btnclear;
    private List<item> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=(TextView) findViewById(R.id.tvscreen);
        btn0=(Button) findViewById(R.id.btn0);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btnadd=(Button) findViewById(R.id.btnadd);
        btnsub=(Button) findViewById(R.id.btnsub);
        btnmul=(Button) findViewById(R.id.btnmul);
        btndiv=(Button) findViewById(R.id.btndiv);
        btnans=(Button) findViewById(R.id.btnans);
        btnclear=(Button) findViewById(R.id.btnclear);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnans.setOnClickListener(this);
        btnclear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn0:
                screen.append("0");
                break;
            case R.id.btn1:
                screen.append("1");
                break;
            case R.id.btn2:
                screen.append("2");
                break;
            case R.id.btn3:
                screen.append("3");
                break;
            case R.id.btn4:
                screen.append("4");
                break;
            case R.id.btn5:
                screen.append("5");
                break;
            case R.id.btn6:
                screen.append("6");
                break;
            case R.id.btn7:
                screen.append("7");
                break;
            case R.id.btn8:
                screen.append("8");
                break;
            case R.id.btn9:
                screen.append("9");
                break;
            case R.id.btnadd:
                items.add(new item(Double.parseDouble(screen.getText().toString()),types.num));
                checkandcompute();
                items.add(new item(0,types.add));
                screen.setText("");
                break;
            case R.id.btnsub:
                items.add(new item(Double.parseDouble(screen.getText().toString()),types.num));
                checkandcompute();
                items.add(new item(0,types.sub));
                screen.setText("");
                break;
            case R.id.btnmul:
                items.add(new item(Double.parseDouble(screen.getText().toString()),types.num));
                checkandcompute();
                items.add(new item(0,types.mul));
                screen.setText("");
                break;
            case R.id.btndiv:
                items.add(new item(Double.parseDouble(screen.getText().toString()),types.num));
                checkandcompute();
                items.add(new item(0,types.div));
                screen.setText("");
                break;
            case R.id.btnans:
                items.add(new item(Double.parseDouble(screen.getText().toString()),types.num));
                checkandcompute();
                screen.setText(items.get(0).value+"");
                items.clear();
                break;
            case R.id.btnclear:
                screen.setText("");
                items.clear();
                break;

        }
    }
    public void checkandcompute()
    {
        if(items.size()>=3)
        {
            double a=items.get(0).value;
            double b=items.get(2).value;
            int opt=items.get(1).type;
            items.clear();
            switch(opt)
            {
                case types.add:
                    items.add(new item(a+b,types.num));
                    break;
                case types.sub:
                    items.add(new item(a-b,types.num));
                    break;
                case types.mul:
                    items.add(new item(a*b,types.num));
                    break;
                case types.div:
                    items.add(new item(a/b,types.num));
                    break;
            }
        }
    }
}