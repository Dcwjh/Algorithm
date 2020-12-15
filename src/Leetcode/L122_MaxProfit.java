package Leetcode;

/**
 * @Description 122. 买卖股票的最佳时机 II:
 * @Author Jianhai Wang
 * @ClassName MaxProfit_122
 * @Date 2019/11/22 10:01
 * @Version 1.0
 */


public class L122_MaxProfit {
    /**
     * 贪心算法
     * @description 从第 i 天（这里 i >= 1）开始，与第 i - 1 的股价进行比较，如果股价有上升（严格上升），
     * 就将升高的股价（ prices[i] - prices[i- 1] ）记入总利润，按照这种算法，得到的结果就是符合题意的最大利润。
     *
     */
    public static int maxProfit(int[] nums){
        int max = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > 0)
                max += (nums[i] - nums[i - 1]);
        }
        return max;
    }

    //TODO 暴力。动态规划参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/

}
