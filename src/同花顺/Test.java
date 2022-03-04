package 同花顺;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test
 * @Date 2021/9/13 17:51
 * @Version 1.0
 */


public class Test {
    public void func(String key, String[] args){
        System.out.println(args== null ? "null" : args.length);
    }

    public static void main(String[] args) throws Exception {
        Test obj = new Test();
        Method m = obj.getClass().getMethod("func", String.class, String[].class);
        m.invoke(obj, new String(), new String[2]);
        m.invoke(obj, new String(), new Object[]{new String[]{"a", "b"}});
        m.invoke(obj, new String(), (Object)new String[]{"a", "b"});

    }
}
