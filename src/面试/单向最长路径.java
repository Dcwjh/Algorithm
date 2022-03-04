package 面试;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 单向最长路径
 * @Date 2021/8/7 16:53
 * @Version 1.0
 */


public class 单向最长路径 {
    public static int getMaximumResource (int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) backtrack(grid,i,j,0);
            }
        }
        return max;
    }
    static int max = 0;
    public static void backtrack(int[][] grid,int i,int j,int sum){
        if(grid[i][j] == 0) return;
        sum += grid[i][j];
        int temp = grid[i][j];
        grid[i][j] = 0;
        max = Math.max(max,sum);
        if(i < grid.length-1) backtrack(grid,i+1,j,sum);
        if(i > 0) backtrack(grid,i-1,j,sum);
        if(j < grid[0].length-1)backtrack(grid,i,j+1,sum);
        if(j > 0) backtrack(grid,i,j-1,sum);
        grid[i][j] = temp;
    }
}
