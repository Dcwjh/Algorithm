package DP;

/**
 * @Description 背包问题：1. 正常的背包问题：容量有限（totalWeight），求在不超过容量情况下的最大价值
 *                       2. 限制个数：设定拿取物品个数不超过totalSize，求能拿取的最大价值
 *                       3. 背包正好装满时的最大价值
 * @Author Jianhai Wang
 * @ClassName helloworld
 * @Date 2019/11/5 14:35
 * @Version 1.0
 */

public class CB {
    static class Bean {
        int weight = 0;
        int value = 0;
        Bean(int w, int v) {
            weight = w;
            value = v;
        }
        @Override
        public String toString() {
            return weight + "  " + value;
        }
    }

    /**
     * @Description 1. 正常的背包问题：容量有限（totalWeight），求在不超过容量情况下的最大价值
     * @param data
     * @param totalWeight
     * @return
     */

    public static int getMaxValue1(Bean[] data, int totalWeight) {
        int n = data.length;
        int[][] dp = new int[n][totalWeight + 1];
        for (int i = 1; i < n; i++) { //物品 只有一个物品
            for (int w = 1; w <= totalWeight; w++) {  //背包大小
                if (data[i].weight > w) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    dp[i][w] = dp[i - 1][w];
                } else { //装得下，Max{装物品i， 不装物品i}
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - data[i].weight] + data[i].value);
                }
            }
        }
        for (int f = 0; f < dp.length; f++) {
            System.out.print("[ ");
            for(int j = 0; j < dp[0].length; j++) {
                System.out.format("%-3d", dp[f][j]);
            }
            System.out.print("]");
            System.out.println();
        }
        return dp[n - 1][totalWeight];
    }

    /**
     * @Description 2. 限制个数：设定拿取物品个数不超过totalSize，求能拿取的最大价值
     * @param data   物品集合
     * @param totalWeight
     * @param totalSize
     * @return
     */
    public static int getMaxValue2(Bean[] data, int totalWeight, int totalSize) {
        int n = data.length;
        int[][] dp = new int[n][totalWeight + 1];
        int[][] number = new int[n][totalWeight + 1];  //表示此刻状态下的物品个数
        for (int i = 1; i < n; i++) { //物品
            for(int w = 1; w <= totalWeight; w++){
                if(data[i].weight > w) {
                    dp[i][w] = dp[i - 1][w];
                    number[i][w] = number[i-1][w];
                } else {
                    if(dp[i - 1][w] < dp[i - 1][w - data[i].weight] + data[i].value && number[i - 1][w - data[i].weight] < totalSize){
                        dp[i][w] = dp[i - 1][w - data[i].weight] + data[i].value;
                        number[i][w] = number[i - 1][w - data[i].weight] + 1;
                    } else if(dp[i - 1][w] >= dp[i][w-1]){
                        dp[i][w] = dp[i - 1][w];
                        number[i][w] = number[i - 1][w];
                    } else {
                        dp[i][w] = dp[i][w - 1];
                        number[i][w] = number[i][w - 1];
                    }
                }
            }
        }
        for (int f = 0; f < dp.length; f++) {
            System.out.print("[ ");
            for(int j = 0; j < dp[0].length; j++) {
                System.out.format("%-3d", dp[f][j]);
            }
            System.out.print("]");
            System.out.println();
        }
//        System.out.println("size: ");
//        for (int f = 0; f < number.length; f++) {
//            System.out.print("[ ");
//            for(int j = 0; j < number[0].length; j++) {
//                System.out.format("%-3d", number[f][j]);
//            }
//            System.out.print("]");
//            System.out.println();
//        }
        return dp[n - 1][totalWeight];
    }


    /**
     * @Description 3. 背包正好装满时的最大价值
     * @param data
     * @param totalWeight
     * @return
     */
    public static int getMaxValue3(Bean[] data, int totalWeight) {
        int n = data.length;
        int[][] dp = new int[n][totalWeight + 1];
        for (int i = 0; i < n; i++) { //物品
            for (int w = 0; w <= totalWeight; w++) {  //背包大小
                dp[i][w] = -1000;
//                table[i][w] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) { //物品
            for (int w = 1; w <= totalWeight; w++) {  //背包大小
                if (data[i].weight > w) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    dp[i][w] = dp[i - 1][w];
                } else { //装得下，Max{装物品i， 不装物品i}
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - data[i].weight] + data[i].value);
                }
            }
        }
        for (int f = 0; f < dp.length; f++) {
            System.out.print("[ ");
            for(int j = 0; j < dp[0].length; j++) {
                System.out.format("%6d", dp[f][j]);
            }
            System.out.print("]");
            System.out.println();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            if(dp[i][dp[0].length - 1] > 0)
                max = Math.max(max, dp[i][dp[0].length - 1]);
        }
        return max;
    }



    public static void main(String[] args) {
        int totalWeight = 9;                    //物品个数，背包容量
        int totalSize = 2;
        Bean[] data = new Bean[]{new Bean(0, 0),
                new Bean(2, 6), new Bean(2, 3), new Bean(6, 5), new Bean(5, 4), new Bean(4, 6)};
        System.out.format("%-3d", getMaxValue1(data, totalWeight));
        System.out.println();
        System.out.println("=============================================");
        System.out.println(getMaxValue2(data,totalWeight,totalSize));
        System.out.println();
        System.out.println("=============================================");
        System.out.println(getMaxValue3(data,totalWeight));
    }
}