package Blili;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/13 20:00
 * @Version 1.0
 */


public class ln2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == -1 || m == -1) break;
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
            int [] ans = fun(nums);
            for(int i = 0; i < ans.length; i ++){
                System.out.print(ans[i]);
                if(i == ans.length - 1){
                    break;
                }
                System.out.print(",");
            }
            System.out.println();
        }
        // if(n == -1 || m == -1) break;

    }
    public static int[] fun(int[][] nums){
        int l = 0, r = nums[0].length - 1, t = 0,b = nums.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true){
            for(int i = l; i <= r; i++){
                res[x++] = nums[t][i];
            }
            if(++t > b) break;
            for(int i = t; i <= b; i++){
                res[x++] = nums[i][r];
            }
            if(l >--r) break;
            for(int i = r; i >= l; i--){
                res[x++] = nums[b][i];
            }
            if(t > --b)break;
            for(int i = b; i >=t; i--){
                res[x++] = nums[i][l];
            }
            if(++l > r) break;
        }
        return res;
    }

}
