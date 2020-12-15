package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NumArray_303
 * @Date 11/30/2020 2:23 PM
 * @Version 1.0
 */


public class L303_NumArray {
    /**
     * 方法一：
     */

    /*
    private int[] data;

    public NumArray_303(int[] nums) {
        data = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        for(int p = i; p <= j; p++){
            res += data[p];
        }
        return res;
    }

     */


    private Map<Integer, Integer> map;  //存储带i的和

    public L303_NumArray(int[] nums){
        if(nums.length == 0)
            return;
        map = new HashMap<>();
        map.put(0,nums[0]);
        for(int i = 1; i< nums.length; i++){
            map.put(i, map.get(i - 1) + nums[i]);
        }
    }


    public int sumRange(int i, int j) {
        if(i == 0)
            return map.get(j);
        return map.get(j) - map.get(i - 1);

    }
}
