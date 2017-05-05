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

import static java.sql.DriverManager.println;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    char[] build = new char[512];
    String[] entry = new String[64];

    double runTot, curNum, calNum;
    boolean runningTotal = false, justEqualed = false, mischief = false, pEquals = false;

    int bCount = 0;//Build Count
    int eCount = 0;//Entry Count
    String fun;

    String bld;

    StringBuilder dis1, dis2;

    TextView wrkScreen, ansScreen, chtScreen;
    RelativeLayout kp;

    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        chtScreen = (TextView) findViewById(R.id.chat); 
        wrkScreen = (TextView) findViewById(R.id.tv1);
        ansScreen = (TextView) findViewById(R.id.tv2);

        kp = (RelativeLayout) findViewById(R.id.keypad);

        ///////////////////////////////////
        //NUM PAD BUTTONS//
        ///////////////////////////////////

        Button num0 = (Button) findViewById(R.id.bt0);
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('0');
                numBtRefresh();
            }
        });
        Button num1 = (Button) findViewById(R.id.bt1);
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('1');
                numBtRefresh();
            }
        });
        Button num2 = (Button) findViewById(R.id.bt2);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('2');
                numBtRefresh();
            }
        });
        Button num3 = (Button) findViewById(R.id.bt3);
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('3');
                numBtRefresh();
            }
        });
        Button num4 = (Button) findViewById(R.id.bt4);
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('4');
                numBtRefresh();
            }
        });
        Button num5 = (Button) findViewById(R.id.bt5);
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('5');
                numBtRefresh();
            }
        });
        Button num6 = (Button) findViewById(R.id.bt6);
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('6');
                numBtRefresh();
            }
        });
        Button num7 = (Button) findViewById(R.id.bt7);
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('7');
                numBtRefresh();
            }
        });
        Button num8 = (Button) findViewById(R.id.bt8);
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('8');
                numBtRefresh();
            }
        });
        Button num9 = (Button) findViewById(R.id.bt9);
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('9');
                numBtRefresh();
            }
        });
        Button dot = (Button) findViewById(R.id.btDot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildIt('.');
                numBtRefresh();
            }
        });

        /////////////////////////////////////
        //OPERATION BUTTONS//
        /////////////////////////////////////

        Button plus = (Button) findViewById(R.id.btPlu);//PLUS
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {clearScreen();}
                try {
                    fun = "+";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        setCurrentNum();
                        setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        runningTotal = true;
                    } else {//There is a Running Total
                        setCurrentNum();
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setRunT(curNum);
                        setWrkScreen(getEntries());
                        setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {System.out.println(e);}
            }
        });
        Button minus = (Button) findViewById(R.id.btMin);//MINUS
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {clearScreen();}
                try {
                    fun = "-";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        setCurrentNum();
                        setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        runningTotal = true;
                    } else {
                        setCurrentNum();
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setRunT(curNum);
                        setWrkScreen(getEntries());
                        setAnsScreen(String.valueOf(runTot));
                    }
                } catch (Exception e) {System.out.println(e);}
            }
        });
        Button mult = (Button) findViewById(R.id.btMul);//MINUS
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (justEqualed) {clearScreen();}
                try {
                    fun = "x";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        setCurrentNum();
                        setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        runningTotal = true;
                    } else {
                        setCurrentNum();
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setRunT(curNum);
                        setWrkScreen(getEntries());
                        setAnsScreen(String.valueOf(runTot));
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
                if (justEqualed) {clearScreen();}
                try {
                    fun = "/";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot = 0;
                        setCurrentNum();
                        setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        runningTotal = true;
                    } else {
                        setCurrentNum();
                        //setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setRunT(curNum);
                        setWrkScreen(getEntries());
                        setAnsScreen(String.valueOf(runTot));
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
                clearScreen();
                clearChat();
                resetBuild();
                resetEntries();
                runTot = 0;
                runningTotal = false;
                justEqualed = false;
            }
        });
        Button eqls = (Button) findViewById(R.id.btEq);//EQUALS BUTTON
        eqls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mischief) {
                    clearScreen();
                    try {
                        fun = "=";
                        if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                            runTot = 0;
                            setCurrentNum();
                            setRunT(curNum);
                            resetEntries();
                            resetBuild();
                            //addEntry(String.valueOf(curNum));
                            setWrkScreen(getEntries());
                        } else {
                            setCurrentNum();
                            eCount += 2;
                            setRunT(curNum);
                            resetEntries();
                            resetBuild();
                            //addEntry(String.valueOf(calNum));
                            setWrkScreen(getEntries());
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    justEqualed = true;
                    runningTotal = false;
                    String cn = String.valueOf(calNum);
                    for (int i = 0; i < cn.length(); i++) {
                        buildIt(cn.charAt(i));
                    }
                    numBtRefresh();
                    runTot = 0;
                }else if(!pEquals){
                    pEquals = true;
                }else if(pEquals){
                    pEquals = false;
                }
                bad();
            }
        });
    }

    void bad() {
        /*for(int i=0;i<kp.getChildCount();i++){
            View child=kp.getChildAt(i);
            //your processing....
            child.setEnabled(false);
        }*/
        choice = getRand();
        if (choice > 20 && choice <= 95) {
            clearScreen();
        }
        String[] nice = {"Hello World!", "Good Day ol' Chap", "Hello Friend", "Nice To See You!",
                "Ah! What A Pleasant Surprise", "Hope I Helped!", "Happy Calculating!",
                "Good Morning, or Evening or Something", "Why Hello Friendo!", "Master Mather In The House!"};

        String[] whine = {"I Don't Want Toooooooo", "Uggg Fine I'll do the numbers or whatever", "Can't you just calculate this later? I'm busy",
                "This is booooooring", "Can we do this later", "I'm bored now", "Blehhh Math suuuuuucks", "OMG just use another app, I don't wanna",
                "nooooooooooo not this agaaaaiinnnnnnn", "lkjafdnkadfsjafdsknmewoije382n-dvnas", "STOOOooooooOOOOppppPPPP", "come on, just leave so I can chill with the viruses on your phone"};

        final String[] concede = {"uggg fine", "whatever man", "laaammmmmeeeeeeee", "fine you win", "BLAhHHHHHHHhhhhhHh"};


        String[] setUp = {"What do you have to do to have a party in space?", "Don't spell part backwards.", "How did pirates collaborate before computers?",
                "Why did the functions stop calling each other?", "Why do anarchists like functional programming?", "As a piece of software, sometimes I feel a void"};

        String[] punchline = {"You have to Planet.", "It's a trap.", "Pier to pier networking",
                "Because they had constant arguments.", "Because it has no state.", "That's when I know I've reached the point of no return"};

        final String zzz = "zzzzzzzzzzzzz";
        String drum = "\\/\\/\\/\\/\\/\\/\\/\\/";

        if (choice >= 1 && choice < 20) {//Regular Calc
            setChtScreen(nice[getRand(0, nice.length)]);
        }else if (choice >= 20 && choice < 25) {//Incorrect Answer
            setWrkScreen(String.valueOf(getRand(0, (int) runTot)));
        }else if (choice >= 25 && choice < 40) {//Complain
            setChtScreen(whine[getRand(0, whine.length)]);
            try {
                Thread.sleep(getRand(1500,3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setChtScreen(concede[getRand(0, concede.length)]);
        }else if(choice>=40 && choice<50){//Joke
            setChtScreen("Hey Lemme Tell a Joke!");
            clearScreen();
            int j = getRand(0,setUp.length);
            setWrkScreen(setUp[j]);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setAnsScreen(punchline[j]);

        }else if(choice>=50 && choice<55){//Sleepy Time
            setChtScreen("Hey I'm just gonna take a lil nap for a sec...");
            try {
                Thread.sleep(30000);
                setWrkScreen(zzz.substring(getRand(0, zzz.length())));
            } catch (InterruptedException e) {
                e.printStackTrace();}
            setChtScreen("Ahhhh that hits the spot");
        }else if(choice>=55 && choice<60){//Distracted
            try {
                Thread.sleep(getRand(10000,15000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setChtScreen("Oh sorry I watcing this cool process tick by.");
        }else if(choice>=60 && choice<70){//Guestimate
            setChtScreen("Its like somewhere around:");
            setWrkScreen(String.valueOf(getRand(0,(int)runTot)));
            setAnsScreenNe("I think...");
        }else if(choice>=70 && choice<71){//Scam
            setChtScreen("CONGRADULATIONS!!!");
            setWrkScreen("YOU WIN!!!");
            setAnsScreenNe("ENTER YOUR SSN TO CLAIM PRIZE!!!");
        }else if(choice>=80 && choice<83){//Pay Wall
            setChtScreen("Oh sorry to access this answer you must pay $" + getRand(0,50)+" dollars");
        }else if(choice>=90 && choice<95){//Binary Answer
            setWrkScreen(Long.toBinaryString(Double.doubleToRawLongBits(calNum)));
            setChtScreen("Oh whoops can you read that?");
        }else{
            setChtScreen(nice[getRand(0,nice.length)]);
        }
        new CountDownTimer(10000,1000) {
            public void onFinish() {
            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();
        /*for(int i=0;i<kp.getChildCount();i++){
            View child=kp.getChildAt(i);
            //your processing....
            child.setEnabled(true);
        }*/
    }

    void setChtScreen(String s){
        chtScreen.setText(s);
    }
    void clearChat(){
        chtScreen.setText("");
    }
    
    int getRand(){
        return (int)(Math.random()*101);
    }
    int getRand(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /////////////////////////////
    //FUNCTIONS//
    /////////////////////////////

    void buildIt(char n) {//Enters Numbers and the '.' character into the Build Array
        build[bCount] = n;
        bCount++;
    }
    void numBtRefresh() {//Refreshes Top (Work) Screen, Sets Displayed String to the New Build Array
        char[] b = Arrays.copyOfRange(build, 0, bCount);
        bld = new String(b);
        if (!runningTotal) {//If there hasn't been an operation yet
            setWrkScreen(bld);
        } else {
            setWrkScreen(getEntries(bld));
            try {
                setAnsScreen(String.valueOf(getRunT(Double.parseDouble(bld))));
            } catch (Exception e) {
                setAnsScreen(String.valueOf(getRunT(0)));
            }
        }
    }
    void setCurrentNum() {
        curNum = Double.parseDouble(bld);
        resetBuild();
    }
    void resetBuild() {//Empties Build Array
        for (int i = 0; i <= bCount; i++) {
            build[i] = ' ';
        }
        bCount = 0;
    }

    void addEntry(String s) {
        entry[eCount] = s;
        Log.d("Add Entry", "eCount:" + (eCount) + "\nentry:" + entry[eCount]);
        eCount++;
    }
    String getEntries() {
        dis1 = new StringBuilder();
        for (int i = 0; i < eCount; i++) {
            dis1.append(entry[i]);
        }
        return dis1.toString();
    }
    String getEntries(String s) {
        dis2 = new StringBuilder();
        for (int i = 0; i < eCount; i++) {
            dis2.append(entry[i]);
        }
        dis2.append(s);
        return dis2.toString();
    }
    void resetEntries() {
        for (int i = 0; i < eCount; i++) {
            entry[i] = " ";
        }
        eCount = 0;
    }

    void clearScreen() {
        setWrkScreen(" ");
        setAnsScreen(" ");
    }
    void setWrkScreen(String s) {
        wrkScreen.setText(s);
    }
    void setAnsScreen(String s) {
        //Log.d("setAnsScreen", "Ans: " + s);
        //Log.d("sAs2", "RT: " + runTot);
        if(false){
            //bad();
        }else {
            s = "= " + s;
            ansScreen.setText(s);
        }
    }
    void setAnsScreenNe(String s){
        ansScreen.setText(s);
    }

    void setRunT(double n) {//Sets the Running Total (double runTot)
        try {
            if (entry[eCount - 3].equals("+") && runningTotal) {//Plus
                runTot = runTot + n;
            } else if (entry[eCount - 3].equals("-") && runningTotal) {//Minus
                runTot = runTot - n;
            } else if (entry[eCount - 3].equals("x") && runningTotal) {//Multiply
                if (runTot != 0) {
                    runTot = runTot * n;
                } else {
                    runTot = n;
                }
            } else if (entry[eCount - 3].equals("/") && runningTotal) {//Divide
                if (runTot != 0) {
                    runTot = runTot / n;
                } else {
                    runTot = n;
                }
            }
        } catch (Exception e) {runTot = n;}
        if (fun.equals("=")) {
            calNum = runTot;
        }
    }
    double getRunT(double n) {
        Log.d("gRT", "numIn: " + n);
        Log.d("gRT", "funct: " + fun);
        Log.d("gRT", "runni: " + runTot);
        if (fun.equals("+")) {//Plus
            return runTot + n;
        } else if (fun.equals("-")) {//Minus
            return runTot - n;
        } else if (fun.equals("x")) {//Multiply
            return runTot * n;
        } else if (fun.equals("/")) {//Divide
            return runTot / n;
        } else {
            return 0;
        }
    }
}
