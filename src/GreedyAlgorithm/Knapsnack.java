package GreedyAlgorithm;

import java.util.Arrays;

/**
 * @Description 贪心算法：优先先择单位重量下价值最大的物品, 物品不能不拆分
 * @Author Jianhai Wang
 * @ClassName Knapsnack
 * @Date 2019/11/23 11:07
 * @Version 1.0
 */

class Pair implements Comparable<Pair>{
    double valuePerWeight;
    int index;

    public Pair(double valuePerWeight, int index){
        this.valuePerWeight = valuePerWeight;
        this.index = index;
    }

    @Override
    public int compareTo(Pair pair) {
        return Double.compare(pair.valuePerWeight, this.valuePerWeight);
    }
}

public class Knapsnack {
    public static void knasnack(double[] Weight, double[] values, double capacity){
        double[] valuePerWeight = new double[Weight.length];
        Pair[] pairs = new Pair[Weight.length];
        for(int i = 0; i < Weight.length; i++){
            valuePerWeight[i] = values[i]/Weight[i];
            pairs[i] = new Pair(valuePerWeight[i],i);
        }

        Arrays.sort(pairs);
        printPair(pairs);

        System.out.println("=================物品==================");
        System.out.println(String.format("%-10s%-10s%-10s","物品","重量","价值"));
        for(int i = 1; i < pairs.length; i++){
                System.out.println(String.format("%-10d%-10.2f%-10.2f",i,Weight[i], values[i]));

        }
        System.out.println("========================================");

        double total = 0;//现在的总重量
        System.out.println("背包容量: " + capacity);
        System.out.println("=============选中物品有==================");
        System.out.println(String.format("%-10s%-10s%-10s","物品","重量","价值"));
        for(int i = 1; i < pairs.length; i++){
            if(total <= capacity && total + Weight[pairs[i].index] <= capacity){
                total += Weight[pairs[i].index];
                System.out.println(String.format("%-10d%-10.2f%-10.2f",pairs[i].index,Weight[pairs[i].index], values[pairs[i].index]));
            }
        }
        System.out.println("========================================");


    }

    public static void printPair(Pair[] pair){
        System.out.println("索引    平均重量");
        for(int i = 1; i < pair.length; i++){
            System.out.println( pair[i].index  + "        "  + pair[i].valuePerWeight );
        }
    }

    public static void main(String[] args) {
        double[] weight = {0,10,20,30};
        double[] value = {0,60,100,120};
//        double[] weight = {0,10,20,30};
//        double[] value = {0,30,70,100};
        knasnack(weight,value,50);
    }
}
