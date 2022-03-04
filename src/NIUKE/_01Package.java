package NIUKE;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName _01Package
 * @Date 2021/8/17 18:25
 * @Version 1.0
 */


public class _01Package {

    public static int fun(int[][] nums, int V){
        /*
                        物品     重量     价值
                        0        2         6
                        1        2         3
                        2        6         5
                        3        5         4
                        4        4         6

                           j (重量)   0 1 2 3 4 5 6 7 8 9 10
                        i(物品)
                          0           0 0 6 6 6 6 6 6 6 6 6
                          1           0 0 Max(3,6) Max(6,6)
                          2
                          3
                          4

         */
        int[][] dp = new int[nums.length][V + 1];
        for (int j = 0; j < V + 1; j++){
            if(nums[0][0] <= j){
                dp[0][j] = nums[0][1];
            } else{
                dp[0][j] = 0;
            }
        }

        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j < V + 1; j++){  //是当前背包的容量, nums[i][1]容量
                if(j < nums[i][0]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    System.out.println("i:" + i + ",j" + j);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i][0]] + nums[i][1]);
                }
                print(dp);
            }
        }
        return dp[nums.length - 1][V];
    }


    private static void print(int[][] nums){
        System.out.println("========================================");
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i][0] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            nums[i][1] = in.nextInt();
        }
        System.out.println(fun(nums, v));

    }
}
