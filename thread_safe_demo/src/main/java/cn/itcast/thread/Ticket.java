package cn.itcast.thread;

public class Ticket implements Runnable{
    private int ticknum = 100;
    private Object obj = new Object();
    public void run() {
        while(true){
            synchronized (obj){
                if(ticknum>0){
                    //1.模拟出票时间
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //2.打印进程号和票号，票数减1
                    System.out.println("线程："+Thread.currentThread().getName()+";售票："+ticknum--);
                }
            }
        }
    }
}
