package Leetcode;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L873最长的斐波那契子序列的长度
 * @Date 2021/8/16 15:30
 * @Version 1.0
 */


public class L873最长的斐波那契子序列的长度 {

    public int lenLongestFibSubseq(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int a1 = nums[i];
                int a2 = nums[j];
                int k = j + 1;
                int count = 0;
                while(k < nums.length){
                    if(a1 + a2 == nums[k]){
                        count ++;
                        a1 = a2;
                        a2 = nums[k];
                    }
                    k++;
                }
                max = Math.max(max, count);
            }
        }
        if(max > 0)
            return max + 2;
        else return 0;
    }


    public int lenLongestFibSubseq2(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int a1 = nums[i];
                int a2 = nums[j];
                int k = j + 1;
                int count = 0;

                while(k < nums.length){
                    int temp = a1 + a2;
                    if(map.containsKey(temp)){
                        count ++;
                        a1 = a2;
                        a2 = temp;
                    }
                    k = map.get(temp) + 1;
                }
                max = Math.max(max, count);
            }
        }
        if(max > 0)
            return max + 2;
        else return 0;
    }
}
