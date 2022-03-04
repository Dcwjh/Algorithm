package 面试;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 递增子序列
 * @Date 2021/8/7 15:39
 * @Version 1.0
 */

/*
数组中,数组中没有重复
三个数递增或者递减的个数

 */

public class 递增子序列 {
    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static int fun(int[] nums){
        backtrack1(new ArrayList<Integer>(),nums, 0);
        backtrack2(new ArrayList<Integer>(), nums, 0);
        return list.size();
    }

    public static void backtrack1(ArrayList<Integer> res, int[] nums, int start){
        if(res.size() == 3){
            list.add(res);
        }
        for(int i = start; i < nums.length; i++){
            if(!res.contains(nums[i]) && res.size() < 3 && res.get(res.size() - 1) < nums[i]){
                res.add(nums[i]);
                backtrack1(res, nums, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void backtrack2(ArrayList<Integer> res, int[] nums, int start){
        if(res.size() == 3){
            list.add(res);
        }
        for(int i = start; i < nums.length; i++){
            if(!res.contains(nums[i])  && res.size() < 3 && res.get(res.size() - 1) > nums[i]){
                res.add(nums[i]);
                backtrack2(res, nums, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }

}
