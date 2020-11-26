package 剑指offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview17
 * @Date 2020/7/2 22:44
 * @Version 1.0
 */


public class Interview17 {

    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++)
            res[i] = i + 1;
        return res;
    }
    //todo 大数问题
    public int[] printNumbers1(int n){
        return null;
    }

    public static void main(String[] args) {
        AtomicInteger m = new AtomicInteger(0);
        m.incrementAndGet();
    }
}
