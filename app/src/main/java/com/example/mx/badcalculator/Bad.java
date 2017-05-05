package com.example.mx.badcalculator;

import android.util.Log;

/**
 * Created by mx on 5/5/17.
 */

public class Bad implements Runnable{
    String[] whine = {"I Don't Want Toooooooo", "Uggg Fine I'll do the numbers or whatever", "Can't you just calculate this later? I'm busy",
            "This is booooooring", "Can we do this later", "I'm bored now", "Blehhh Math suuuuuucks", "OMG just use another app, I don't wanna",
            "nooooooooooo not this agaaaaiinnnnnnn", "lkjafdnkadfsjafdsknmewoije382n-dvnas", "STOOOooooooOOOOppppPPPP", "come on, just leave so I can chill with the viruses on your phone"};

    String[] concede = {"uggg fine", "whatever man", "laaammmmmeeeeeeee", "fine you win", "BLAhHHHHHHHhhhhhHh"};


    String[] setUp = {"What do you have to do to have a party in space?", "Don't spell part backwards.", "How did pirates collaborate before computers?",
            "Why did the functions stop calling each other?", "Why do anarchists like functional programming?", "As a piece of software, sometimes I feel a void"};

    String[] punchline = {"You have to Planet.", "It's a trap.", "Pier to pier networking",
            "Because they had constant arguments.", "Because it has no state.", "That's when I know I've reached the point of no return"};

    String zzz = "zzzzzzzzzzzzz";

    int choice;
    Computations c = new Computations();
    public void run() {
        choice = c.getRand();
        if (choice > 20 && choice <= 95) {
            c.clearScreen();
        }

        if (choice >= 20 && choice < 25) {//Incorrect Answer
            c.setChtScreen(";P");
            c.setWrkScreen(String.valueOf(c.getRand(0, (int) c.getRunTot())));
        }else if (choice >= 25 && choice < 40) {//Complain
            c.setChtScreen(whine[c.getRand(0, whine.length-1)]);
            Log.d("bad","complain");
            try {
                Thread.sleep(c.getRand(1500,3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.setChtScreen(concede[c.getRand(0, concede.length-1)]);
            c.equalsFunct();
        }else if(choice>=40 && choice<50){//Joke
            c.setChtScreen("Hey Lemme Tell a Joke!");
            c.clearScreen();
            int j = c.getRand(0,setUp.length-1);
            c.setWrkScreen(setUp[j]);
            Log.d("bad","joke");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.setAnsScreen(punchline[j]);

        }else if(choice>=50 && choice<55){//Sleepy Time
            c.setChtScreen("Hey I'm just gonna take a lil nap for a sec...");
            Log.d("bad","nap");
            try {
                Thread.sleep(30000);
                c.setWrkScreen(zzz.substring(c.getRand(0, zzz.length()-1)));
            } catch (InterruptedException e) {
                e.printStackTrace();}
            c.setChtScreen("Ahhhh that hits the spot");
        }else if(choice>=55 && choice<60){//Distracted
            Log.d("bad","distracted");
            try {
                Thread.sleep(c.getRand(10000,15000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.setChtScreen("Oh sorry I watcing this cool process tick by.");
        }else if(choice>=60 && choice<70){//Guestimate
            c.setChtScreen("Its like somewhere around:");
            c.setWrkScreen(String.valueOf(c.getRand(0,(int)c.getRunTot())));
            c.setAnsScreenNe("I think...");
        }else if(choice>=70 && choice<71){//Scam
            c.setChtScreen("CONGRADULATIONS!!!");
            c.setWrkScreen("YOU WIN!!!");
            c.setAnsScreenNe("ENTER YOUR SSN TO CLAIM PRIZE!!!");
        }else if(choice>=80 && choice<83){//Pay Wall
            c.setChtScreen("Oh sorry to access this answer you must pay $" + c.getRand(0,50)+" dollars");
        }else if(choice>=90 && choice<95){//Binary Answer
            c.setWrkScreen(Long.toBinaryString(Double.doubleToRawLongBits(c.getCalNum())));
            c.setChtScreen("Oh whoops can you read that?");
        }else{
            Log.d("bad","else");
            try {
                c.setChtScreen(whine[c.getRand(0, whine.length-1)]);
                Log.d("Else", "complain");
                Thread.sleep(c.getRand(1500,3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.setChtScreen(concede[c.getRand(0, concede.length-1)]);
            c.equalsFunct();
        }
    }
}
