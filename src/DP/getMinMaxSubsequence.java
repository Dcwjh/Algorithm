package DP;

import java.util.Arrays;

/**
 * @Description 给定一长度为N的整数序列$(a_1, a_2, \ dots, a_N)$ ，将其划分成多个子序列（此问题中子序列是连续的一段整数），
 * 满足每个子序列中整数的和不大于一个数B，设计一种划分方法，最小化所有子序列中最大值的和。
 * 说明其具有优化子结构及子问题重叠性质。
 *
 * \quad \quad 例如： 序列长度为8的整数序列(2,2,2,8,1,8,2,1)，B=17，可将其划分成三个子序列(2,2,2)，(8,1,8)以及(2,1)，
 * 则可满足每个子序列中整数和不大于17，所有子序列中最大值的和12为最终结果。
 * @Author Jianhai Wang
 * @ClassName getMinMaxSubsequence
 * @Date 2019/11/9 11:04
 * @Version 1.0
 */
/*
假设A[i,j] = $(a_i, a_{i + 1}, \dots, a_j)$, 其各元素和为s(i,j) = $a_i$ + $a_{i + 1}$ + $a_j$, 其中1 $\leq i\leq j \leq n$.

设序列$(a_i, a_{i + 1}, \dots, a_j)$的所有子序列中最大值的最小和为dp(i,j), 对于其中子序列$a_k$, $a_{k + 1}$, \dots $a_j$中的最大值的最小和为dp[k,j]($i \leq k \leq j$).

则动态方程为dp[i,j] = $min_{i \leq k \leq j - 1}$(max(A[i,k]) + sum(k +1,j))，其中max(s(i,k)) $ \leq B$, s(i, k)为A[i,k]中各元素的和。

则根据上述动态方程可以得到序列$a_1, a_2,\dots, a_n$的最小化所有子序列中最大值的和的动态方程为dp[1,n] = $min_{1 \leq k \leq n - 1}$(max(A[1,k]) + sum(k +1,n))
 */

public class getMinMaxSubsequence {
    //方法一：一维数组
    public static int getMin(int[] nums, int limit){
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for(int i = 1 ; i <= nums.length; i++){
            int j = i - 1;
            int max = nums[j];
            int sumTemp = nums[j];
            int sumMin = nums[j] + dp[j];
            while(j > 0 && sumTemp + nums[j-1] <= limit){
                sumTemp += nums[j - 1];
                max = Math.max(max, nums[j - 1]);
                sumMin = Math.min(sumMin, dp[j - 1] + max);
                j--;
            }
            System.out.println(Arrays.toString(dp));
            dp[i] = sumMin;
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }

    //方法二：二维数组
    public static int getMin2(int[] a, int limit){
        if(a == null)
            return 0;
        if(a.length == 1)
            return a[0];
        int len = a.length;
        int[] nums = new int[len + 1];
        System.arraycopy(a,0,nums, 1,len);
        int[][] dp = new int[len + 1][len + 1];

        for(int i = 1; i <= len; i++){
            for(int j =1; j <=len; j++){
                dp[i][j] = getMax(nums, i, j, limit);
            }
        }

        for(int i = 1; i <= len; i++)
            for(int j = i+1; j <= len; j++)
                for(int k = i + 1; k <= j; k++)
                    if(getMax(nums, k + 1, j,limit) != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j],dp[i][k] + getMax(nums, k + 1,j,limit));
        print(dp);
        return dp[1][len];
    }

    //和上面方法相似：只是下标不同
    public static int getMin3(int[] nums, int limit){
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int len = nums.length;

        int[][] dp = new int[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j <len; j++){
                dp[i][j] = getMax(nums, i, j, limit);
            }
        }

        for(int i = 0; i < len; i++)
            for(int j = i+1; j < len; j++)
                for(int k = i + 1; k <= j; k++)
                    if(getMax(nums, k + 1, j,limit) != Integer.MAX_VALUE)
                        //符合条件则更新
                        dp[i][j] = Math.min(dp[i][j],dp[i][k] + getMax(nums, k + 1,j,limit));
        print(dp);
        return dp[0][len - 1];
    }

    public static int getMax(int[] nums, int start, int end, int limit){
        int sum = 0;
        int max = 0;
        while(start <= end){
            max = Math.max(nums[start],max);
            sum += nums[start++];
        }
        if(sum > limit)
            return Integer.MAX_VALUE;
        return max;
    }

    public static void print(int[][] nums){
        System.out.println("=================================");
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.format("%-12d",nums[i][j]);
            }
            System.out.println();
        }

    }

    //方法三：易于理解方法
    static int getMinMaxSum(int[] a, int limit) {
        int n = a.length;
        int[] num = new int[a.length + 1];
        int[][] dp = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1]; // sum[i][j]存储num[i]到num[j]的和
        int[][] max = new int[n + 1][n + 1]; // max[i][j]存储num[i]到num[j]的最大值
        System.arraycopy(a, 0, num, 1, n);
        // 初始化sum和max数组
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                max[i][j] = num[i];
                for (int s = i; s <= j; s++) {
                    sum[i][j] += num[s];
                    max[i][j] = Math.max(max[i][j], num[s]);
                }
            }
        }
        // 初始化dp数组为num[i]到num[j]之和（显然如果这样做符合要求的话那一定是最小的），
        // 若不满足条件则初始化为无穷大
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = sum[i][j] <= limit ? max[i][j] : Integer.MAX_VALUE;
            }
        }
        // 开始dp
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k < j; k++) {
                    // 若符合条件，则更新
                    if (sum[k + 1][j] <= limit) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + max[k + 1][j]);
                    }
                }
            }
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,8,1,8,2,1};
        System.out.println(getMin3(nums, 17));
    }

}
