package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L78_Subsets
 * @Date 1/11/2021 4:27 PM
 * @Version 1.0
 */


public class L78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        list.add(l);
        dfs(list,nums, 0, l);
        return list;
    }

    private void dfs(List<List<Integer>> list, int[] nums, int index,List<Integer> l){
        if(index == nums.length) return;
        for(int i = index; i < nums.length; i++){
            if(l.size() == 0 || l.get(l.size() - 1) < nums[i]) { //剪枝
                l.add(nums[i]);
                list.add(new ArrayList<Integer>(l));
                dfs(list, nums, index + 1, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
