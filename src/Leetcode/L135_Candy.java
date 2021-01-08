package Leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L135_Candy
 * @Date 12/24/2020 10:43 AM
 * @Version 1.0
 */


public class L135_Candy {

    //https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
    //规则定义： 设学生 A 和学生 B 左右相邻，A 在 B 左边；
    //左规则： 当 ratingsB>ratingsA时，B 的糖比 A 的糖数量多。
    //右规则： 当 ratings_A>ratingsB时，A 的糖比 B 的糖数量多。
    //相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则

    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        int ans = 0;
        for(int i = right.length - 2 ; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = 0; i < ratings.length; i++){
            ans += Math.max(left[i],right[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        new L135_Candy().candy(new int[]{1,0,2});
    }
}
