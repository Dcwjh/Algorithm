package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L695岛屿的最大面积
 * @Date 2021/8/12 17:10
 * @Version 1.0
 */


public class L695岛屿的最大面积 {
   static int max = 0;
   static int num = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        print(grid);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    num = 0;
                    dfs(grid, i, j);
                    max = Math.max(num, max);
                }
            }
        }
        return max;
    }

    public static void dfs(int[][] grid, int i, int j){
        if(grid[i][j] == 0) return;

        num++;
        max = Math.max(max, num);
        System.out.println("==================================================");
        grid[i][j] = 9;
        System.out.println("num的数值：" + num);
        print(grid);
        grid[i][j] = 0;
        if(i + 1 < grid.length) dfs(grid, i + 1, j);
        if(j - 1>= 0)  dfs(grid, i, j - 1);
        if(i - 1 >= 0) dfs(grid, i - 1, j);
        if(j + 1 < grid[0].length) dfs(grid, i, j + 1);
    }


    public static void print(int[][] s){

        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s[0].length; j++){
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] s = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(s));
    }



    /*
     int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int i, int j, int num){
        if(grid[i][j] == 0) return;
        grid[i][j] = 0;
        num++;   //Java中是值传递，递归回来就会是原来的值继续递归例如

        //1   1   //第一个1他有两条路径，向下递归在返回的时候，这时候他还是1，在向右递归值才是2，本来应该是5
        //1   0
        //1   0
        //1   0
        max = Math.max(max, num);
        if(i + 1 < grid.length) dfs(grid, i + 1, j, num);
        if(j - 1>= 0)  dfs(grid, i, j - 1, num);
        if(i - 1 >= 0) dfs(grid, i - 1, j, num);
        if(j + 1 < grid[0].length) dfs(grid, i, j + 1, num);
    }
     */
}
