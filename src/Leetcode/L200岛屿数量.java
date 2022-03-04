package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L200岛屿数量
 * @Date 2021/8/7 17:51
 * @Version 1.0
 */


public class L200岛屿数量 {
    static int num = 0;
    public static int numIslands(char[][] grid) {
        int[][] help = new int[grid.length][grid[0].length];
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && help[i][j] == 0){
                    num ++;
                    dfs(help, grid, i, j);
                }
            }
        }
        print(help);
        return num;
    }

    public static void print(int[][] help){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for(int i = 0; i < help.length; i++){
            for(int j = 0; j < help[0].length; j++){
                System.out.print(help[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }

    public static void dfs(int[][] help, char[][] grid, int i, int j){
        //4

        if(help[i][j] != 0 || grid[i][j] == '0') return;
        help[i][j] = num;

        if(i + 1 < grid.length) dfs(help, grid, i + 1, j);
        if(j - 1 >= 0) dfs(help, grid, i, j - 1);
        if(i - 1 >= 0) dfs(help, grid, i - 1, j);
        if(j + 1 < grid[0].length) dfs(help, grid, i, j + 1);
    }

    public static void main(String[] args) {

        char[][] temp = new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
            };
        System.out.println(numIslands(temp));
    }


    //原地修改数组
    public int numIslands2(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != '0'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        if(i + 1 < grid.length) dfs(grid, i + 1, j);
        if(j - 1>= 0)  dfs(grid, i, j - 1);
        if(i - 1 >= 0) dfs(grid, i - 1, j);
        if(j + 1 < grid[0].length) dfs(grid, i, j + 1);
    }

}
