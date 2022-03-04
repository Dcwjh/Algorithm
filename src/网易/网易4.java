package 网易;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 网易4
 * @Date 2021/8/21 15:51
 * @Version 1.0
 */


public class 网易4 {

    private static int cost = Integer.MAX_VALUE;
    private static boolean flag = false;
    public static int minSailCost (int[][] nums) {
        // write code here
        int m = nums.length;
        int n = nums[0].length;
        if(nums[0][0] == 2 || nums[m - 1][n - 1] == 2)
            return -1;
        dfs(nums, 0, 0, 0);
        return cost;
    }

    private static void dfs(int[][] nums, int row, int col, int sum){

        System.out.println(" row : " + row + ", col: " + col +", sum:" +  sum );
        if(row == nums.length - 1 && col == nums[0].length - 1) {
            cost = Math.min(cost, sum);
            return;
        }
        if(row + 1 < nums.length && nums[row + 1][col] == 1){
            dfs(nums, row + 1, col, sum + 1);
        }
        if(col + 1 < nums[0].length && nums[row][col + 1] == 1){
            dfs(nums, row, col + 1, sum + 1);
        }
        if(row + 1 < nums.length && nums[row + 1][col] == 0){
            dfs(nums, row + 1, col, sum + 2);
        }
        if(col + 1 < nums[0].length && nums[row][col + 1] == 0) {
            dfs(nums, row, col + 1, sum + 2);
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {1,1,1,1,0},
            {0,1,0,1,0},
            {1,1,2,1,1},
            {0,2,0,0,1}
        };
        System.out.println(minSailCost(nums));
    }
}
