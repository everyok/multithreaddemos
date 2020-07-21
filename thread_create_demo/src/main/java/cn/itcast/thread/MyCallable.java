package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.Callable;
//线程创建的方式3，实现Callable接口
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间是："+new Date().getTime()+"；循环次数是："+i);
        }
        return "MyCallable执行完毕";
    }
}
