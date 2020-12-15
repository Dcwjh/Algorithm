package Leetcode;

/**
 * @Description 167. 两数之和 II - 输入有序数组
 * @Address https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Author Jianhai Wang
 * @ClassName LeetCode_167
 * @Date 2020/7/21 22:56
 * @Version 1.0
 */


public class L167_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            if(numbers[start] + numbers[end] < target){
                start++;
            } else if(numbers[start] + numbers[end] > target){
                end--;
            } else
                return new int[]{start + 1, end + 1};
        }
        return null;
    }
}
