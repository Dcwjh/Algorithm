package 拼多多;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In3
 * @Date 2021/8/22 19:54
 * @Version 1.0
 */


public class In3 {

    public static long fun(int count, long y){
        if(y >= (long)Math.pow(10, count)){
            return -1;
        }

        long min = (long)Math.pow(10, count - 1);
        long max = (long)Math.pow(10, count) - 1;
        int num = String.valueOf(y).length();
        if(num > min && num < max) return y;
        long temp = y;
        long pre = y;
        while(temp < min){
            pre = temp;
            temp = temp * 2;
        }
        long add = pre;
        while(pre < min){
            pre += add;
        }

        for(long i = pre; i >= min;){
            //System.out.println("i:" + i + "y:" + y);
            i -= y;

        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            list.add(fun(x,y));
        }
        for(Long L: list){
            System.out.println(L);
        }
    }
}
