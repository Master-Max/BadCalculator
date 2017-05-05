package com.example.mx.badcalculator;

import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by mx on 5/5/17.
 */

public class Computations{

    char[] build = new char[512];
    String[] entry = new String[64];

    double runTot, curNum, calNum;
    boolean runningTotal = false, justEqualed = false, mischief = false, conceded = false;

    int bCount = 0;//Build Count
    int eCount = 0;//Entry Count
    String fun;

    String bld;

    StringBuilder dis1, dis2;

    //TextView wrkScreen, ansScreen, chtScreen;
    //RelativeLayout kp;


    int choice;
    int annoy = 0;

    double getRunTot(){
        return runTot;
    }
    double getCurNum(){
        return curNum;
    }
    double getCalNum(){
        return calNum;
    }

    void setECount(int n){
        eCount += n;
    }

    void equalsFunct() {
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
        Log.d("Comp","built: " + n);
        bCount++;
    }
    void numBtRefresh() {//Refreshes Top (Work) Screen, Sets Displayed String to the New Build Array
        char[] b = Arrays.copyOfRange(build, 0, bCount);
        bld = new String(b);
        Log.d("Comp","bld: " + bld);
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
