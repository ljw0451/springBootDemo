package com.ljw.utils;

/**
 * @Author : lijianwen
 * @Date : 2020-04-07
 * @Version : 1.0
 */
public class TestThread extends Thread{

    @Override
    synchronized public void run() {
//        count --;
        System.out.println("线程"+Thread.currentThread().getName()+"执行");
    }

}

