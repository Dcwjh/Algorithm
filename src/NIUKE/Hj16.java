package NIUKE;

import java.util.Scanner;


/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Hj16
 * @Date 2021/8/19 13:02
 * @Version 1.0
 */


public class Hj16 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int n = in.nextInt();

        //物品编号 + 主附件标识
        int[][] values = new int[n + 1][3];

        int[][] weight = new int[n + 1][3];
        int index = 1;
        while(index < n + 1){

            int v = in.nextInt();
            int w = in.nextInt();
            int c = in.nextInt();

            if(c == 0){
                values[index][0] = v;
                weight[index][0] = v * w;
            } else {
                if(values[c][1] == 0){
                    values[c][1] = v;
                    weight[c][1] = v * w;
                } else{
                    values[c][2] = v;
                    weight[c][2] = v * w;
                }
            }
            index ++;
        }
        int res = 0;
        int[] dp = new int[N + 1];

        for(int i  = 1; i < n + 1; i++){
            int[] v = new int[4];
            int[] w = new int[4];
            v[0] = values[i][0];
            v[1] = values[i][0] + values[i][1];
            v[2] = values[i][0] + values[i][2];
            v[3] = values[i][0] + values[i][1] + values[i][2];

            w[0] = weight[i][0];
            w[1] = weight[i][0] + weight[i][1];
            w[2] = weight[i][0] + weight[i][2];
            w[3] = weight[i][0] + weight[i][1] + weight[i][2];
            for(int k = N; k >0; k--){
                for(int j = 0; j < 4; j++){
                    if(k >= v[j])
                        dp[k] = Math.max(dp[k], dp[k - v[j]] + w[j]);
                }
            }

        }

        System.out.print(dp[N]);

    }

    private static void printOne(int[] dp) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(int num : dp)
            System.out.print(num + " ");
        System.out.println();
    }

    private static void print(int[][] values) {
        System.out.println("==============================");
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values[0].length; j++){
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }


}
