package cn.itcast.thread;

//案例：龟兔赛跑
public class Race implements Runnable{
    private static String winner;

    public void run() {
        for(int i=0;i<=100;i++){
            if(Thread.currentThread().getName().equals("兔子") && i%10==0){//模拟兔子休息
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gameOver(i)){//判断比赛是否结束,如果比赛结束了，就结束程序
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
    }
    private boolean gameOver(int i){
        if(winner!=null) return true;
        if(i==1000){
            winner = Thread.currentThread().getName();
            System.out.println(Thread.currentThread().getName()+"赢了");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        Thread t1 = new Thread(race, "乌龟");
        Thread t2 = new Thread(race,"兔子");

        t1.start();
        t2.start();
    }
}
