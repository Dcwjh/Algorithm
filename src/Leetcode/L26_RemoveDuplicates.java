package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L26_RemoveDuplicates
 * @Date 12/14/2020 4:02 PM
 * @Version 1.0
 */


public class L26_RemoveDuplicates {
    //值相等就跳过，不相等时，将值复制给l+1.(l != r) 但是l + 1 == r
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int l = 0;
        for(int r = 1; r < nums.length; r++){
            if(nums[l] != nums[r] ){
                l++;
                nums[l] = nums[r];
            }
        }
        return l + 1;
    }
}
