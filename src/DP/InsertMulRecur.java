package DP;

import java.util.Scanner;

/**
 * @Description 添加乘号递归形式的解
 * @Author Jianhai Wang
 * @ClassName InsertMulRecur
 * @Date 2019/11/9 10:28
 * @Version 1.0
 */


public class InsertMulRecur {
    public static int getMax(int[] nums, int k){
        if(k == 0)
            return getSum(nums, 0,nums.length - 1);
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[][] dp = new int[k+1][nums.length];
        dp[0][0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[0][i] = dp[0][i - 1] + nums[i];
        }

        for(int row = 1; row <= k; row++){
            for(int end = row; end < nums.length; end++){
                for(int i = row ; i <= end; i++) {
//                    print(dp);
                    dp[row][end] = Math.max(dp[row][end], dp[row - 1][i - 1] * getSum(nums, i, end));
                }
            }
        }
        System.out.println("动态规划表格如下所示：");
        print(dp);
        return dp[k][nums.length - 1];
    }

    public static void print(int[][] dp){
        System.out.println("=================start=======================");
        for(int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================end=========================");
    }
    public static int getSum(int[] nums, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += nums[i];
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入一个整数n（整数的个数）和一个整数k（乘号个数）：");
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入" + n + "个数字");
        for(int i = 0;i < n;i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getMax(nums, k));
    }
}
