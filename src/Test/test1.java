package Test;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test.test1
 * @Date 2021/8/31 22:28
 * @Version 1.0
 */


public class test1 {
    ThreadLocal<String> t1 = new ThreadLocal<>();
    private String val;
    public String getString(){
        return t1.get();
    }
    public void setString(String val){
        t1.set(val);
    }

    public static void main(String[] args) {
        test1 t = new test1();
        for(int i = 0; i < 5;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (t) {
                        t.setString(Thread.currentThread().getName() + "的数据");
                        System.out.println("-------------------------------");
                        System.out.println(Thread.currentThread().getName() + "------>" + t.getString());
                    }
                }

            });
            thread.setName("线程" + i);
            thread.start();
        }
    }
}
