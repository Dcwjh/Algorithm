package Leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L322_CoinChange
 * @Date 1/7/2021 1:50 PM
 * @Version 1.0
 */


public class L322_CoinChange {
    //贪心算法，从最大硬币开始算起：缺点，可能不是最优解。因为数字的原因可能有解但是因为数字凑不出来，如果coins里面的数字都互质，则可以使用贪心算法

    //2，6，9   19   可以使用9+6+2+2，然后使用9+9却没有数字可以组合。故数字必须互质才能使用贪心算法例如硬币1，2，3，5，7，11
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int minCount = 0;
        int index = coins.length - 1;
        while(index >= 0){
            while(amount-coins[index] >= 0){
                amount -= coins[index];
                minCount++;
            }
            if(amount - coins[index] < 0){
                index--;
            }
        }
        return amount==0? minCount:-1;
    }

    //动态规划：自低向上，从底部求解只需要数组保存上次求解过程
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i] , dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    //动态规划：自顶向下。需要递归，先求父问题，在求解子问题

    public int coinChange3(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange4(coins, amount, new int[amount]);
    }

    private int coinChange4(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange4(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }




    //贪心算法：不断试错 + 剪枝
    int res = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        Arrays.sort(coins);
        minCoin(coins, amount, coins.length - 1, 0);
        return res==Integer.MAX_VALUE? -1:res;
    }

    private void minCoin(int[] coins, int amount, int index, int count){
        if(amount == 0){
            res =  Math.min(res, count);
            return;
        }
        if(index < 0)
            return;
        //i + count < res; 寻求最优解，排序可以减少循环
        for(int i = amount/coins[index]; i >= 0 && i + count < res; i--)
            minCoin(coins,amount - i * coins[index], index -1, count + i);
    }


    private int[] sort(int[] arr){
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++ ){
                if(arr[j] < arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new L322_CoinChange().coinChange2(new int[]{9,5,7,2,3,10,38,4,6,23,42}, 11);
    }

}
