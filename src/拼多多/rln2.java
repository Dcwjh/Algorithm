package 拼多多;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName rln2
 * @Date 2021/9/22 16:10
 * @Version 1.0
 */


public class rln2 {
    static  int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int i = 0; i < p; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();
            int[][] nums = new int[n][m];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    nums[j][k] = in.nextInt();
                }
            }
            res = 0;
            dfs(nums, 0, 0, new ArrayList<Integer>());
            System.out.println(res);
        }
    }

    private static  void dfs(int[][] nums, int row, int col, ArrayList<Integer> ans){
        int n = nums.length;
        int m = nums[0].length;
        if(!ans.contains(nums[row][col])){
            ans.add(nums[row][col]);
        }
        if(row == n - 1 &&  col == m - 1 && ans.size() == n + m - 1){
            res ++;
            return;
        }

        if(row + 1 < n  && !ans.contains(nums[row + 1][col])){
            dfs(nums, row + 1, col, ans);
            ans.remove(ans.size() - 1);
        }

        if(col  + 1< m && !ans.contains(nums[row][col + 1])){
            ans.add(nums[row][col + 1]);
            dfs(nums, row, col + 1, ans);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}
/*
3
3 3 7
1 1 2
5 5 8
3 9 7
3 3 6
10 9 6
10 10 10
1 7 4
3 3 7
1 4 9
10 6 10
3 3 5
 */