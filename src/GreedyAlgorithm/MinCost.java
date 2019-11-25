package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @Description
 * 某公司有个工厂和仓库。由于原材料等价格波动，工厂每个月的生产成本也会波动，令第i个月产品的单位生产成本为$c_i$
 * （该月生产一个产品的成本为$c_i$）。仓库储存产品的也有成本，假设每个月产品的单位储存成本为固定值1（存储一个产品一个月的成本为1）。
 * 令第i个月需要供应给客户的产品数量为$y_i$，仓库里的和生产的产品均可供应给客户。假设仓库的容量无限大，供应给客户剩余的产品可储存在仓库中。
 * 若已知n个月中各月的单位生产成本$c_i$、以及产品供应量$y_i$，设计一算法决策每个月的产品生产数量$x_i$，使得𝑛个月的总成本最低。
 * 例如：$𝑛=3，c_i:2,5,3，y_i:2,4,5$，则$x_i$:6,0,5，即第1个月生产6个供应2个（代价2×2=4），储存4个供应给第2个月（代价(2+1)×4=12），
 * 第3个月生产5个供应5个（代价3×5=15），使总成本4+12+15=31最小。
 * @Author Jianhai Wang
 * @ClassName MinCost
 * @Date 2019/11/23 22:45
 * @Version 1.0
 */


public class MinCost {

    public static int[] greedy(int[] cost, int[] supply){
        int[] produce = new int[supply.length];
        int store = 1;
        int temp = 0;
        int lastSupply = 10000;
        int myPos = 0;
        for(int i = 0; i < supply.length; i++){
//            如果超额生产的产品即使算上存储成本也比之后的某个月生产成本要低
            if(lastSupply + store < cost[i]){
//                引入一个myPos变量，用来记录那些需要超额生产的月份，当前月份则是i
                produce[myPos] += supply[i];
            }
            else {
                myPos = i;
//                自产自销的月份
                produce[i] += supply[i];
            }
            lastSupply = Math.min(lastSupply + store, cost[i]);
            temp += lastSupply * supply[i];
        }
        System.out.println("成本为:" + temp);
        System.out.println(Arrays.toString(produce));
        return produce;

    }

    public static void main(String[] args) {
        int[] cost = {2,5,3};
        int[] supply = {2,4,5};
//        int[] cost = {2,3,5,9,4};
//        int[] supply = {2,2,1,3,5};
        greedy(cost,supply);
    }
}
