package 剑指offer;

/**
 * @Description 和为s的数字
 * @Author Jianhai Wang
 * @ClassName Interview57
 * @Date 2020/6/28 15:58
 * @Version 1.0
 */


public class Interview57 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;
        int first = 0;
        int last = nums.length - 1;
        while(first < last){
            if(nums[first] + nums[last] < target){
                first++;
            } else if(nums[first] + nums[last] > target){
                last --;
            } else
                break;
        }

        if(nums[first] + nums[last] == target)
            return new int[]{nums[first], nums[last]};
        return null;
    }
}
