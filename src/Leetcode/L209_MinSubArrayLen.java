package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L209_MinSubArrayLen
 * @Date 12/21/2020 5:22 PM
 * @Version 1.0
 */


public class L209_MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int count = nums.length + 1;
        int sum = 0;
        //满足其和 ≥ s 的长度最小的 连续 子数组.小于s，右指针向右移动，大于s,左指针向左移动
        while(end < nums.length){
            if(sum < s){
                sum += nums[end];
                end++;
            }
            while(sum >= s){  //若满足条件则左指针一直向左移动
                count = Math.min(count, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return count > nums.length? 0 : count;
    }

    public static void main(String[] args) {
        new L209_MinSubArrayLen().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
