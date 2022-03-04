package 拼多多;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName rln3
 * @Date 2021/9/22 15:29
 * @Version 1.0
 */


public class rln3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = in.nextInt();
        }
        int count = 0;
        int xuhao = 1;
        int[] help = new int[n];

        while(xuhao <= nums.length){
            for(int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] == count) {
                    help[j] = xuhao;
                    xuhao++;
                }
            }
            count++;
        }

        for(int i = 0; i < help.length; i++){
            System.out.print(help[i] + " ");
        }
    }
}
/*
4
0 1 2 1
 */