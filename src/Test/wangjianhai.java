package Test;

public interface wangjianhai {
    public abstract void fun();
    default void func(){
        System.out.println("hecsa");
    }
}
