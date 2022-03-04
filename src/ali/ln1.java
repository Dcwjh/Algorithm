package ali;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln1
 * @Date 2021/9/17 19:02
 * @Version 1.0
 */


public class ln1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int m = in.nextInt();
            int k = in.nextInt();
            System.out.println(fun(m,k));
        }

    }
    //ny + k = x
//    private static int fun(int n, int k){
//        if(k > n) return 0;
//        int res = 0;
//
//        //System.out.println(n);
//        for(int x = 1; x <= n; x ++){
//            for(int y = 1; y <= n; y++){
//                if(x % y == k){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }


    private static int fun(int n, int k){
        if(k > n) return 0;
        int res = 0;

        int y = 1;
        while(y <= n){
            int i = 0;

            while(true){
                if(y > k && i * y + k <= n){
                    res++;
                    i++;
                } else{
                    break;
                }
            }
            y++;
        }
        return res;
    }
}
