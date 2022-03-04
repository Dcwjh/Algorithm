package 拼多多;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName rln4
 * @Date 2021/9/22 16:43
 * @Version 1.0
 */


public class rln4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int len = in.nextInt();
            int count = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();
            int[] nums = new int[len];
            for(int j = 0; j < len; j ++){
                nums[j] = in.nextInt();
            }
            for(int j = 0; j < count; j++){
                int x = in.nextInt();
                int y = in.nextInt();
                fun(nums, p, q, x, y);
            }
        }
    }
    private static void fun(int[] nums, int n, int m, int x, int y){
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                x = x > 1? x - 1: x;
            } else if(nums[i] == 2){
                y = y > 1? y - 1: y;
            } else if(nums[i] == 3){
                x = x < n ? x + 1 : x;
            } else if(nums[i] == 4){
                y = y < m? y + 1: y;
            }
        }
        System.out.println(x + " " + y);
    }
}

/*
2
3 4 3 3
1 2 3
1 1
1 3
2 2
3 1
0 1 1 1
1 1
 */