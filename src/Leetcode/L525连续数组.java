package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L525连续数组
 * @Date 2021/8/6 16:40
 * @Version 1.0
 */


public class L525连续数组 {

    public int findMaxLength(int[] nums) {
        //前缀和
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1); //从下标-1开始，一开始和为0
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                sum ++;
            } else{
                sum --;
            }
            if(map.containsKey(sum)){
                count = Math.max(count,i - map.get(sum));  //只保留最远的那一个
            } else map.put(sum, i);
        }
        return count;
    }
}
