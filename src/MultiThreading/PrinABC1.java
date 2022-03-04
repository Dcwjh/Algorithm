package MultiThreading;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName PrinABC1
 * @Date 2021/7/28 13:27
 * @Version 1.0
 */


public class PrinABC1 implements Runnable {
    private String name;
    private Object pre;
    private Object self;

    public PrinABC1(String name, Object pre, Object self){
        this.name = name;
        this.pre = pre;
        this.self= self;
    }

    @Override
    public void run(){
        int count = 10;
        while(count > 0){
            synchronized (pre){
                synchronized (self){
                    System.out.print(name);
                    count--;
                    self.notifyAll();
                }
                if(count > 0) {
                    try {
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrinABC1 pa = new PrinABC1("A", c, a);
        PrinABC1 pb = new PrinABC1("B", a, b);
        PrinABC1 pc = new PrinABC1("C", b, c);

        new Thread(pa).start();
        Thread.sleep(5000);

        new Thread(pb).start();
        Thread.sleep(5000);

        new Thread(pc).start();
        Thread.sleep(5000);
    }
}
