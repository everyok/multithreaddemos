package cn.itcast.thread;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadCreateDemo {
    public static void main(String[] args) {
        //1.线程创建方式1，继承thread类
        /*        //1.1创建自定义线程类实例
        MyThread myThread = new MyThread();
        //1.2启动线程
        myThread.start();
        //1.3在main主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println("main主线程执行了："+new Date().getTime());
        }*/
//========================================================================================================
        //2.线程创建方式2：实现Runnable接口
/*        //2.1在主线程打印信息
        for (int i=0;i<10;i++){
            System.out.println("main主线程执行了："+new Date().getTime());
        }
        //2.2通过thread类执行myrunnable类
        Thread thread = new Thread(new MyRunnable(),"myRunnable");
        thread.start();*/
//========================================================================================================
        //3.线程创建方式3，实现Callable接口
        /*//3.1创建FutureTask实例，创建MyCallable实例
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        //3.2创建Thread实例，执行FutureTask
        Thread thread = new Thread(task, "MyCallable");
        thread.start();
        //3.3在主线程打印信息
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间是："+new Date().getTime()+"；循环次数是："+i);
        }
        try {
            String s = task.get();
            System.out.println("MyCallable执行结果是："+s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
//========================================================================================================
        //4.使用线程池创建线程
        //4.1使用Executor获取线程池对象
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //4.2通过线程池对象获取线程并执行MyRunnable实例
        executorService.execute(new MyRunnable());
        //4.3主线程打印信息
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"执行时间是："+new Date().getTime()+"；循环次数是："+i);
        }
    }
}
