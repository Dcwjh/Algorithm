/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Singleton
 * @Date 2021/8/12 11:02
 * @Version 1.0
 */


public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
