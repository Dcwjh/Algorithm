package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L31_NextPermutation
 * @Date 1/8/2021 3:39 PM
 * @Version 1.0
 */


public class L31_NextPermutation {
    //大小具有传递性

    /**
     * 思路：从后向前找到第一个正序的排列，记下下标i，然后在右边找到最小值（且最小值比i所在值大），交换。
     * 然后把i之后的数组进行反转
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;  //找到想要的值
            //找到右边比所在值大，从最小的开始找
        if(i >= 0){
            int j = nums.length - 1;
            while(j > i && nums[i] >= nums[j])
                j--;
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
        reverse(nums, i + 1);
    }
    private void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while( start < end){ //这样交换有一个限制，两个数不能相等
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end --;
        }

    }
}
