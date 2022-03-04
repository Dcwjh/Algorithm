package MultiThreading.Print123455;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName TwoLockSynchronized
 * @Date 2021/7/28 22:01
 * @Version 1.0
 */


public class TwoLockSynchronized extends Thread{
    private int start;
    private Object pre;
    private Object self;

    public TwoLockSynchronized(int start, Object pre, Object self) {
        this.pre = pre;
        this.self = self;
        this.start = start;
    }



    public void run() {
        for (int epoch = 0; epoch < 4; epoch++) {
            for (int i = start; i < 11; i += 2) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        self.notifyAll();
                    }
                    if((i == 10 || i == 11) && epoch == 3) {
                        pre.notifyAll();
                    }else {
                        try {
                            pre.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();

        new TwoLockSynchronized(1,a,b).start();
        new TwoLockSynchronized(2, b, a).start();

    }
}
