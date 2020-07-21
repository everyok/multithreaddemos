package cn.itcast.thread;

import java.util.Date;

//线程创建方式1：继承Thread类
public class MyThread extends Thread{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("mythread线程执行了："+new Date().getTime());
        }
    }
}
