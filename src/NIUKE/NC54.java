package NIUKE;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC54
 * @Date 2021/1/21 23:18
 * @Version 1.0
 */


public class NC54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return null;
        int n = nums.length;
        Arrays.sort(nums);
        int k = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(k < n - 2){
            int i =  k + 1;
            int j = n - 1;
            while(i < j){
                if(nums[i] + nums[k] + nums[j] < 0){
                    int left = nums[i];
                    while(left == nums[i]&& i< j) i++;
                }
                else if(nums[i] + nums[k] + nums[j] > 0){
                    int right = nums[j];
                    while(right == nums[j] && i < j) j--;
                }
                else{
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[k]);
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    list.add(ans);
                    i ++;
                    j--;
                }
            }
            k++;
        }
        return list;


    }
}
