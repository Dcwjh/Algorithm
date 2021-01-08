package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L714_MaxProfit
 * @Date 12/17/2020 11:10 AM
 * @Version 1.0
 */


public class L714_MaxProfit {

    /**
     * 动态规划：手续费放在卖出时进行计算
     * @param prices
     * @param fee
     * @return
     */
    //
    public static int maxProfit(int[] prices, int fee) {
        int pocket = 0; //一开始收益为0
        int hold = -prices[0];  //手里有一个股票，初始化
        for (int p : prices) {
            hold = Math.max(hold, pocket - p); //今天必须要继续持有一直股票： hold:昨天的不卖出继续持有（今天股价增加），packet-p:昨天可能手里没有股票现在买入股票(说明今天股票价格更低，上次的不买入了，今天买入)
            pocket = Math.max(pocket, hold + p - fee); //今天必须要没有股票：pocket:不买入（收益还是昨天的收益，昨天就已经卖出），hold + p - fee: 昨天的卖出
        }
        return pocket;
    }

    /**
     *
     * 贪心算法：将手续费放在买入时进行计算
     * 我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利
     * @param
     */

    public static int maxProfit1(int[] prices, int fee) {
        int profit = 0;
        int buy = prices[0] + fee;
        for(int price : prices){
            if(price + fee < buy){
                buy = price  + fee; //发现下一个单价更低时，更新买入操作   1,8,9  （若执行到下面了，只要后一个价格低，就会跟新该操作，否则下一个就很大，就继续计算利润且没有申购费）
            } else if(price > buy){  //发现当前价格高，则卖出，若发现更高的，则继续卖出，且没有手续费
                profit += price - buy;  //price[4] -
                buy = price;  //不要申购费
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{1,8,9},2));
    }
}
