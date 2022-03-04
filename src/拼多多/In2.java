package 拼多多;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName In2
 * @Date 2021/8/22 19:02
 * @Version 1.0
 */


public class In2 {
    //[-2,-1,1,2n]
    public static int fun(int x, int y){
        if(x == y) return 0;
        if(x > y){
            return (x - y + 1) / 2;
        }
        else {
            int count = 0;
            while(x < y){
                if(y % 2  == 0){
                    y /= 2;
                    count ++;
                }else{
                    y += 1;
                    y /= 2;
                    count += 2;
                }
            }
            count += x - y;
            return Math.max(y - x, count);
        }
    }





    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(fun(x,y));
        }
    }
}
