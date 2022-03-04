package 剑指offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview13
 * @Date 2021/8/8 9:37
 * @Version 1.0
 */


public class Interview13 {
    int res = 0;
    public int movingCount(int m, int n, int k) {
        int[][] nums = new int[m][n];
        dfs(nums, 0, 0, k);
        return res;
    }

    public void dfs(int[][] nums, int i, int j, int k){
        if(i/10 + i % 10 + j /10 + j %10 > k || nums[i][j] != 0) return;
        res ++;
        nums[i][j] = 1;
        if(i - 1 > 0) dfs(nums, i - 1, j, k);
        if(i + 1 < nums.length) dfs(nums, i + 1, j, k);
        if(j - 1 > 0) dfs(nums, i, j - 1, k);
        if(j + 1 < nums[0].length) dfs(nums, i, j+ 1, k);
    }


    public int movingCount2(int m, int n, int k) {
        int res = 0;
        int[][] nums = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        nums[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){

            }
        }
        return 1;
    }
}
