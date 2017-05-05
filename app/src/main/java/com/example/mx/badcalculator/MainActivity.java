package com.example.mx.badcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.sql.DriverManager.println;
import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    char[] build = new char[512];
    String[] entry = new String[64];

    String[] modE = new String[64];
    double[] c = new double[64];
    
    double runTot, curNum, calNum;
    boolean runningTotal = false, justEqualed = false;

    int bCount = 0;//Build Count
    int eCount = 0;//Entry Count
    int mCount = 0;
    String fun;
    
    String bld;

    StringBuilder dis;
    
    TextView wrkScreen, ansScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wrkScreen = (TextView) findViewById(R.id.tv1);
        ansScreen = (TextView) findViewById(R.id.tv2);

        RelativeLayout kp = (RelativeLayout) findViewById(R.id.keypad);

        ///////////////////////////////////
                //NUM PAD BUTTONS//
        ///////////////////////////////////

        Button num0 = (Button) findViewById(R.id.bt0);
        num0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('0');
                numBtRefresh();
            }
        });
        Button num1 = (Button) findViewById(R.id.bt1);
        num1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('1');
                numBtRefresh();
            }
        });
        Button num2 = (Button) findViewById(R.id.bt2);
        num2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('2');
                numBtRefresh();
            }
        });
        Button num3 = (Button) findViewById(R.id.bt3);
        num3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('3');
                numBtRefresh();
            }
        });
        Button num4 = (Button) findViewById(R.id.bt4);
        num4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('4');
                numBtRefresh();
            }
        });
        Button num5 = (Button) findViewById(R.id.bt5);
        num5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('5');
                numBtRefresh();
            }
        });
        Button num6 = (Button) findViewById(R.id.bt6);
        num6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('6');
                numBtRefresh();
            }
        });
        Button num7 = (Button) findViewById(R.id.bt7);
        num7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('7');
                numBtRefresh();
            }
        });
        Button num8 = (Button) findViewById(R.id.bt8);
        num8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('8');
                numBtRefresh();
            }
        });
        Button num9 = (Button) findViewById(R.id.bt9);
        num9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buildIt('9');
                numBtRefresh();
            }
        });
        Button dot = (Button) findViewById(R.id.btDot);
        dot.setOnClickListener(new View.OnClickListener(){
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
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    fun = "+";
                    if (!runningTotal) {//Not a Running Total (First Operation Button Pressed)
                        runTot=0;
                        setCurrentNum();
                        setRunT(curNum);
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        runningTotal = true;
                    } else {//There is a Running Total
                        setRunT(curNum);
                        setCurrentNum();
                        addEntry(String.valueOf(curNum));
                        addEntry(fun);
                        setWrkScreen(getEntries());
                        setAnsScreen(String.valueOf(runTot));
                    }

                }catch(Exception e){System.out.println(e);}
            }
        });

        ///////////////////////////////////
                //CONTROL BUTTONS//
        ///////////////////////////////////

        Button clr = (Button) findViewById(R.id.btClear);//CLEAR BUTTON
        clr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                resetBuild();
                resetEntries();
                runTot=0;
                runningTotal=false;
                justEqualed=false;
            }
        });
        Button eqls = (Button) findViewById(R.id.btEq);//EQUALS BUTTON
        eqls.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearScreen();
                calculate();
            }
        });
    }

    /////////////////////////////
            //FUNCTIONS//
    /////////////////////////////

    void buildIt(char n){//Enters Numbers and the '.' character into the Build Array
        build[bCount] = n;
        bCount++;
    }
    void numBtRefresh(){//Refreshes Top (Work) Screen, Sets Displayed String to the New Build Array
        bld = new String(build);
        if(!runningTotal){//If there hasn't been an operation yet
            setWrkScreen(bld);
        }else{
            setWrkScreen(getEntries(bld));
            setAnsScreen(String.valueOf(getRunT(Double.parseDouble(bld))));
        }
    }
    void setCurrentNum(){
        curNum = Double.parseDouble(bld);
        resetBuild();
    }
    void resetBuild(){//Empties Build Array
        for(int i=0;i<=bCount;i++){
            build[i] = ' ';
        }
        bCount=0;
    }

    void addEntry(String s){
        entry[eCount]=s;
        eCount++;
        Log.d("Add Entry", "eCount:" + eCount + "\nentry" + entry[eCount]);
    }
    String getEntries(){
        dis  = new StringBuilder();
        for(int i = 0; i < eCount; i++){
            dis.append(entry[i]);
        }
        return dis.toString();
    }
    String getEntries(String s){
        dis  = new StringBuilder();
        for(int i = 0; i < eCount+1; i++){
            dis.append(entry[i]);
        }
        dis.append(s);
        return dis.toString();
    }
    void resetEntries(){
        for(int i=0;i<eCount;i++){
            entry[i] = " ";
        }
        eCount = 0;
    }

    void clearScreen(){
        setWrkScreen(" ");
        setAnsScreen(" ");
    }
    void setWrkScreen(String s){wrkScreen.setText(s);}
    void setAnsScreen(String s){
        s = "= " + s;
        ansScreen.setText(s);
    }

    void setRunT(double n){//Sets the Running Total (double runTot)
        if(fun.equals("+")){//Plus
            runTot = runTot + n;
        }else if(fun.equals("-")){//Minus
            runTot = runTot - n;
        }else if(fun.equals("x")){//Multiply
            if(runTot!=0){
                runTot = runTot * n;
            }else {
                runTot = n;
            }
        }else if(fun.equals("/")) {//Divide
            if (runTot != 0) {
                runTot = runTot / n;
            } else {
                runTot = n;
            }
        }
    }

    double getRunT(double n){
        if(fun.equals("+")){//Plus
            return runTot + n;
        }else if(fun.equals("-")){//Minus
            return runTot - n;
        }else if(fun.equals("x")){//Multiply
            return runTot * n;
        }else if(fun.equals("/")) {//Divide
            return runTot / n;
        }else{return 0;}
    }

    double calculate(){
        if(fun.equals("+")){//Plus
            return runTot + curNum;
        }else if(fun.equals("-")){//Minus
            return runTot + curNum;
        }else if(fun.equals("x")){//Multiply
            return runTot + curNum;
        }else if(fun.equals("./")) {//Divide
            return runTot + curNum;
        }else
            return 0;
    }
}

//OLD PLUS BUTTON
                /*
                setFun(1);
                if(!runningTotal){//No Running Total
                    setCurrentNum();//Sets curNum to the value in build
                    wrkScreen.setText(String.valueOf(curNum + " + "));//Sets Top Screen
                    runningTotal = true;//Running Total is now TRUE
                }else{
                    setRunT(curNum);//Sets runTot to runTot + curNum(the last number entered)
                    setCurrentNum();//Sets curNum to the value in build
                    //wrkScreen.setText(String.valueOf(runTot + " + " + curNum));//Sets Top Screen

                    ansScreen.setText(String.valueOf("= " + calc()));//Sets Bottom Screen
                }
                resetBuild();//Clears the build array
                */

//OLD setFun Method

/*
    void setFun(int f){//Sets the Function(Fun) Value for calculation
        if(f==1){//Plus
            fun = 1;
        }else if(f==2){//Minus
            fun = 2;
        }else if(f==3){//Multiply
            fun = 3;
        }else if(f==4){//Divide
            fun = 4;
        }
    }*/

//BETTER CALCULATE FUNCTION THAT WILL TAKE TOO LONG TO MAKE

    /*
    double calculate(){
        //modE = entry;
        for(int i=0;i<eCount;i++){
            try {
                if (entry[i].equals("x") > 0) {
                    modE[mCount] = String.valueOf(Double.parseDouble(entry[i - 1]) * Double.parseDouble(entry[i - 1]));
                } else if (entry[i].equals("/") > 0) {
                    modE[mCount] = String.valueOf(Double.parseDouble(entry[i - 1]) / Double.parseDouble(entry[i - 1]));
                }
            }catch (Exception e){System.out.println(e);}
        }




        for(int i=0;i<eCount;i++){
            if(entry[i].equals("+")>0){

            }else if(entry[i].equals("-")>0){

            }else if(entry[i].equals("*")>0){

            }else if(entry[i].equals("/")>0){

            }
        }

        return 0;
    }*/
