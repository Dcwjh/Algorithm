package MultiThreading;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName SellTicket
 * @Date 2021/7/29 11:26
 * @Version 1.0
 */


public class SellTicket extends Thread{
    private Object o;
    private int total = 100;
    private int num = 1;

    public SellTicket(Object o){
        this.o = o;
    }

    @Override
    public void run() {
        while(true){
            //使用同一把锁
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                if(num <= 100){
                    System.out.println(Thread.currentThread().getName() + "：售出第" + num + "票");
                    num++;
                }else{
                    System.out.println("票已经售完！");
                    System.exit(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Object o = new Object();


        //下面的代码错误在于，没有共享变量，导致每个售票窗口都打印1~100
//        Thread t1 = new SellTicket(o);
//        Thread t2 = new SellTicket(o);
//        Thread t3 = new SellTicket(o);
//        Thread t4 = new SellTicket(o);
//        t1.setName("售票窗口1");
//        t2.setName("售票窗口2");
//        t3.setName("售票窗口3");
//        t4.setName("售票窗口4");

        SellTicket sell = new SellTicket(o);



        //第一个对象，多开几个线程
        Thread t1 = new Thread(sell, "售票窗口1");
        Thread t2 = new Thread(sell, "售票窗口2");
        Thread t3 = new Thread(sell, "售票窗口3");
        Thread t4 = new Thread(sell, "售票窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
