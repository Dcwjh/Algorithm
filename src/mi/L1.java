package mi;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1
 * @Date 2021/9/8 19:32
 * @Version 1.0
 */


public class L1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt( i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
