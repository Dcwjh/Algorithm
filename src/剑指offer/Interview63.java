package 剑指offer;

/**
 * @Description 股票最低价
 * @Address https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview63
 * @Date 2020/6/29 11:42
 * @Version 1.0
 *
 *
 * 关键点，找到股票最低价
 */


public class Interview63 {


    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int min = prices[0];
        int maxProfit = prices[1] - min;
        int index = 1;
        while(index < prices.length){
            if(min > prices[index])
                min = prices[index];
            if(maxProfit < prices[index] - min)
                maxProfit = prices[index] - min;
            index++;
        }
        return maxProfit;
    }
}
