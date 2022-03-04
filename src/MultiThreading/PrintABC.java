package MultiThreading;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrintABC
 * @Date 2021/7/28 12:08
 * @Version 1.0
 */


public class PrintABC {
    final Object monitor = new Object();
     volatile int  count = 1; //统计次数，保证可见性

    String id = "A";
    int printCount;
    public PrintABC(int printCount){   //总的打印次数
        this.printCount = printCount;
    }
    public void printA() throws InterruptedException{
        while (count < printCount){
            synchronized (monitor){
                while(!id.equals("A")){ //等于A直接跳过，      不等于A则需要进入等待队列
                    monitor.wait();
                }
                System.out.println(Thread.currentThread().getName() + "打印：" + id);
                id = "B";
                monitor.notifyAll();
            }
        }
    }

    public void printB() throws InterruptedException{
        while (count < printCount){
            synchronized (monitor){
                while(!id.equals("B")){
                    monitor.wait();
                }
                System.out.println(Thread.currentThread().getName() + "打印：" + id);
                id = "C";
                monitor.notifyAll();
            }
        }
    }

    public void printC() throws InterruptedException{
        while (count < printCount + 1){
            synchronized (monitor){
                while(!id.equals("C")){
                    monitor.wait();
                }
                System.out.println(Thread.currentThread().getName() + "打印：" + id);
                id = "A";
                count += 1;
                System.out.println();
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC(100);
        Thread t1 = new Thread(()-> {
            try {
                printABC.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("A线程");

        Thread t2 = new Thread(()-> {
            try {
                printABC.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("B线程");

        Thread t3 = new Thread(()-> {
            try {
                printABC.printC(); //调用方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.setName("C线程");

        t2.start();
        t3.start();
        t1.start();
    }

}
