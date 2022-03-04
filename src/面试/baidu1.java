package 面试;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName baidu1
 * @Date 2021/9/7 19:44
 * @Version 1.0
 */


public class baidu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = in.nextInt();
            }
        }
        int[][] newnums = new int[n * k][n * k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                fun(newnums, i,j,k, nums[i][j]);
            }
        }
        for(int i = 0; i < n *k;i++){
            for (int j = 0; j < n * k; j++){
                System.out.print(newnums[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fun(int[][] nums,int row, int col, int k, int value){
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                nums[row * k + i][col * k + j] = value;
            }
        }
    }
}
