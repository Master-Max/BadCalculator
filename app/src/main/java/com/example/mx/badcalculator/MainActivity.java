package com.example.mx.badcalculator;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

import static com.example.mx.badcalculator.R.id.tv1;
import static java.sql.DriverManager.println;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    private boolean justEqualed = false, runningTotal = false;
    private String fun;
    private double runTot,curNum,calNum;
    private int annoy;

    public TextView wrk,ans,cht;

    Computations c = new Computations();

    Bad b = new Bad();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cht = (TextView) findViewById(R.id.chat);
        wrk = (TextView) findViewById(R.id.tv1);
        ans = (TextView) findViewById(R.id.tv2);

        ///////////////////////////////////
        //NUM PAD BUTTONS//
        ///////////////////////////////////

        Button num0 = (Button) findViewById(R.id.bt0);
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('0');
                c.numBtRefresh();
            }
        });
        Button num1 = (Button) findViewById(R.id.bt1);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('1');
                c.numBtRefresh();
            }
        });
        Button num2 = (Button) findViewById(R.id.bt2);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('2');
                c.numBtRefresh();
            }
        });
        Button num3 = (Button) findViewById(R.id.bt3);
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('3');
                c.numBtRefresh();
            }
        });
        Button num4 = (Button) findViewById(R.id.bt4);
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('4');
                c.numBtRefresh();
            }
        });
        Button num5 = (Button) findViewById(R.id.bt5);
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('5');
                c.numBtRefresh();
            }
        });
        Button num6 = (Button) findViewById(R.id.bt6);
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('6');
                c.numBtRefresh();
            }
        });
        Button num7 = (Button) findViewById(R.id.bt7);
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('7');
                c.numBtRefresh();
            }
        });
        Button num8 = (Button) findViewById(R.id.bt8);
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('8');
                c.numBtRefresh();
            }
        });
        Button num9 = (Button) findViewById(R.id.bt9);
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('9');
                c.numBtRefresh();
            }
        });
        Button dot = (Button) findViewById(R.id.btDot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.buildIt('.');
                c.numBtRefresh();
            }
        });

        /////////////////////////////////////
        //OPERATION BUTTONS//
        /////////////////////////////////////

        Button plus = (Button) findViewById(R.id.btPlu);//PLUS
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {c.clearScreen();}
                try {
                    fun = "+";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        c.setCurrentNum();
                        c.setRunT(curNum);
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setWrkScreen(c.getEntries());
                        runningTotal = true;
                    } else {//There is a Running Total
                        c.setCurrentNum();
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setRunT(curNum);
                        c.setWrkScreen(c.getEntries());
                        c.setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {System.out.println(e);}
            }
        });
        Button minus = (Button) findViewById(R.id.btMin);//MINUS
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {c.clearScreen();}
                try {
                    fun = "-";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        c.setCurrentNum();
                        c.setRunT(curNum);
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setWrkScreen(c.getEntries());
                        runningTotal = true;
                    } else {
                        c.setCurrentNum();
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setRunT(curNum);
                        c.setWrkScreen(c.getEntries());
                        c.setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {System.out.println(e);}
            }
        });
        Button mult = (Button) findViewById(R.id.btMul);//MINUS
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {c.clearScreen();}
                try {
                    fun = "x";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        c.setCurrentNum();
                        c.setRunT(curNum);
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setWrkScreen(c.getEntries());
                        runningTotal = true;
                    } else {
                        c.setCurrentNum();
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setRunT(curNum);
                        c.setWrkScreen(c.getEntries());
                        c.setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        Button divide = (Button) findViewById(R.id.btDiv);//MINUS
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {c.clearScreen();}
                try {
                    fun = "/";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        c.setCurrentNum();
                        c.setRunT(curNum);
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setWrkScreen(c.getEntries());
                        runningTotal = true;
                    } else {
                        c.setCurrentNum();
                        //c.setRunT(curNum);
                        c.addEntry(String.valueOf(curNum));
                        c.addEntry(fun);
                        c.setRunT(curNum);
                        c.setWrkScreen(c.getEntries());
                        c.setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {System.out.println(e);}
            }
        });


        ///////////////////////////////////
        //CONTROL BUTTONS//
        ///////////////////////////////////

        Button clr = (Button) findViewById(R.id.btClear);//CLEAR BUTTON
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.clearScreen();
                c.clearChat();
                c.resetBuild();
                c.resetEntries();
                runTot = 0;
                runningTotal = false;
                justEqualed = false;
            }
        });
        Button eqls = (Button) findViewById(R.id.btEq);//EQUALS BUTTON
        eqls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getRand(0,1)>=1) {
                    annoy++;
                }
                if(c.getRand(0+annoy,100)>=50) {
                    c.setChtScreen("GOOD");
                    good();
                    equalsFunct();
                }else{
                    c.setChtScreen("BAD");
                    new Thread(new Bad()).start();
                }
            }
        });
    }

    void equalsFunct(){
        try {
            fun = "=";
            if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                runTot = 0;
                c.setCurrentNum();
                c.setRunT(curNum);
                c.resetEntries();
                c.resetBuild();
                //c.addEntry(String.valueOf(curNum));
                c.setWrkScreen(c.getEntries());
            } else {
                c.setCurrentNum();
                c.setECount(2);
                c.setRunT(curNum);
                c.resetEntries();
                c.resetBuild();
                //c.addEntry(String.valueOf(calNum));
                c.setWrkScreen(c.getEntries());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        justEqualed = true;
        runningTotal = false;
        String cn = String.valueOf(calNum);
        for (int i = 0; i < cn.length(); i++) {
            c.buildIt(cn.charAt(i));
        }
        c.numBtRefresh();
        runTot = 0;
    }

    void good(){
        Log.d("GOOD", "annoy: " +annoy);
        String[] nice = {"Hello World!", "Good Day ol' Chap", "Hello Friend", "Nice To See You!",
                "Ah! What A Pleasant Surprise", "Hope I Helped!", "Happy Calculating!",
                "Good Morning, or Evening or Something", "Why Hello Friendo!", "Master Mather In The House!"};

        c.setChtScreen(nice[c.getRand(0, nice.length-1)]);
    }
    
}
