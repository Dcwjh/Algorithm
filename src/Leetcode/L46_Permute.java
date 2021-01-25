package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L46_Permute
 * @Date 1/8/2021 7:29 PM
 * @Version 1.0
 */


public class L46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(list, nums, res);
        return list;

    }

    private void dfs(List<List<Integer>> list, int[] nums, List<Integer> res){
        if(res.size() == nums.length){
            list.add(new ArrayList<>(res));
            return ;
        }
        for(int num : nums){
            if(!res.contains(num)) {
                res.add(num);
                dfs(list, nums, res);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new L46_Permute().permute(new int[]{1,2,3});
    }
}
