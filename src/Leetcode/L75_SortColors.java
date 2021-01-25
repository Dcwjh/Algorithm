package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L75_SortColors
 * @Date 1/11/2021 3:58 PM
 * @Version 1.0
 */


public class L75_SortColors {
    //双指针
    public void sortColors(int[] nums) {
        if(nums.length < 2) return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while(index <= right){
            if(nums[index] == 0){
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left++;
                index++;
            } else if(nums[index] == 2){
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            } else{
                index++;
            }
        }
    }
}
