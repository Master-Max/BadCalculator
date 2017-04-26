package com.example.mx.badcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    char[] build = new char[512];
    double a,b,c;
    int count = 0;
    int fun = 0;
    String bld;
    TextView screen;
    boolean many;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RelativeLayout kp = (RelativeLayout) findViewById(R.id.keypad);

        Button num0 = (Button) findViewById(R.id.bt0);
        num0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build0();
                refresh();
            }
        });
        Button num1 = (Button) findViewById(R.id.bt1);
        num1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build1();
                refresh();
            }
        });
        Button num2 = (Button) findViewById(R.id.bt2);
        num2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build2();
                refresh();
            }
        });
        Button num3 = (Button) findViewById(R.id.bt3);
        num3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build3();
                refresh();
            }
        });
        Button num4 = (Button) findViewById(R.id.bt4);
        num4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build4();
                refresh();
            }
        });
        Button num5 = (Button) findViewById(R.id.bt5);
        num5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build5();
                refresh();
            }
        });
        Button num6 = (Button) findViewById(R.id.bt6);
        num6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build6();
                refresh();
            }
        });
        Button num7 = (Button) findViewById(R.id.bt7);
        num7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build7();
                refresh();
            }
        });
        Button num8 = (Button) findViewById(R.id.bt8);
        num8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build8();
                refresh();
            }
        });
        Button num9 = (Button) findViewById(R.id.bt9);
        num9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                build9();
                refresh();
            }
        });
        Button dot = (Button) findViewById(R.id.btDot);
        dot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildDot();
                refresh();
            }
        });
        Button clr = (Button) findViewById(R.id.btClear);
        clr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                refresh();
            }
        });
        Button eqls = (Button) findViewById(R.id.btEq);
        eqls.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                setB();
                calc();
                //screen.setText(String.valueOf(c));
            }
        });
        Button plus = (Button) findViewById(R.id.btPlu);
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                if(many){
                    a += Double.parseDouble(bld);
                }else{
                    setA();
                }
                setFun(1);
                screen.setText(String.valueOf(a+" + "));
                many = true;
            }
        });
        Button min = (Button) findViewById(R.id.btMin);
        min.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                setA();
                setFun(2);
                screen.setText(String.valueOf(a+" - "));
                many = true;
            }
        });
        Button mult = (Button) findViewById(R.id.btMul);
        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                setA();
                setFun(3);
                screen.setText(String.valueOf(a+" X "));
                many = true;
            }
        });
        Button div = (Button) findViewById(R.id.btDiv);
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                setA();
                setFun(4);
                screen.setText(String.valueOf(a+" / "));
                many = true;
            }
        });


        screen = (TextView) findViewById(R.id.tvMain);


        //screen.setText("");


    }

    void build0(){
        build[count] = '0';
        count++;
    }
    void build1(){
        build[count] = '1';
        count++;
    }
    void build2(){
        build[count] = '2';
        count++;
    }
    void build3(){
        build[count] = '3';
        count++;
    }
    void build4(){
        build[count] = '4';
        count++;
    }
    void build5(){
        build[count] = '5';
        count++;
    }
    void build6(){
        build[count] = '6';
        count++;
    }
    void build7(){
        build[count] = '7';
        count++;
    }
    void build8(){
        build[count] = '8';
        count++;
    }
    void build9(){
        build[count] = '9';
        count++;
    }
    void buildDot(){
        build[count] = '.';
        count++;
    }
    void clearScreen(){
        for(int i=0;i<count;i++){
            build[i] = ' ';
        }
        count=0;
    }
    void refresh(){
        bld = new String(build);
        screen.setText(bld);
    }
    void setA(){
        a = Double.parseDouble(bld);
    }
    void setB(){
        b = Double.parseDouble(bld);
    }
    void setFun(int x){
        if(x==1){
            fun = 1;
        }else if(x==2){
            fun = 2;
        }else if(x==3){
            fun = 3;
        }else if(x==4){
            fun = 4;
        }
    }
    void calc(){
        if(fun==1){
            c = a+b;
            screen.setText(String.valueOf(a+" + "+b+" = "+c));
        }else if(fun==2){
            c = a-b;
            screen.setText(String.valueOf(a+" - "+b+" = "+c));
        }else if(fun==3){
            c = a*b;
            screen.setText(String.valueOf(a+" X "+b+" = "+c));
        }else if(fun==4){
            c = a/b;
            screen.setText(String.valueOf(a+" / "+b+" = "+c));
        }else{
            c = b;
        }
        a = c;
    }


}
