package com.example.recupereafficherdonnedistante.Utils;

public class MyThread extends  Thread{
    private  Utils utils;
    @Override
    public void run() {
        super.run();
        System.out.println("run my Thread");

        utils.executeLongActionDuring7seconds();
    }
}
