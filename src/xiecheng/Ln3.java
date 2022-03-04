package xiecheng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Ln3
 * @Date 2021/9/9 20:01
 * @Version 1.0
 */


public class Ln3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String[] lines = line1.split(" ");
        int n = Integer.parseInt(lines[1]);
        int[] v = new int[n];
        int[] w = new int[n];
        for(int i = 0; i < n; i++){
            String temp = in.nextLine();
            String[] t = temp.split(" ");
            v[i] = Integer.parseInt(t[0]);
            w[i] = Integer.parseInt(t[1]);
        }
        ArrayList<Integer> bags = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < line2.length(); i++){
            if(line2.charAt(i) == '1'){
                start ++;
            } else {
                if(start != 0){
                    bags.add(start);
                    start = 0;
                }
            }
            if(i == line2.length() - 1 && line2.charAt(i) == '1'){
                bags.add(start);
            }
        }

        int sum = 0;
        for(Integer i: bags){
            sum += fun(i,v,w);
        }
        System.out.println(sum);

    }
    private static int fun(int C, int[] v, int[] w){
        int[] dp = new int[C + 1];
        dp[0] = 0;
        int N = v.length;
        for(int i = 0; i < C + 1; i++){
            for(int j = 0; j < N; j++){
                if(i >= v[j]){
                    dp[i] = Math.max(dp[i], dp[i - v[j]] + w[j]);
                }
            }
        }

        return dp[C];
    }
}
