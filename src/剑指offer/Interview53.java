package 剑指offer;

/**
 * @Description 在排序数组中查找数字
 * @Address https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @Author Jianhai Wang
 * @ClassName Interview53
 * @Date 2020/6/28 9:15
 * @Version 1.0
 */


public class Interview53 {
    //二分查找
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int first = getFirstK(nums,0,nums.length-1,target);
        int last = getLastK(nums,0,nums.length-1,target);
        if(first > -1 && last > -1){
            return last - first + 1;
        }
        return 0;
    }

    private static int getFirstK(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;
        int middle = left + ((right - left)>>1);
        if(nums[middle] > target) {//中间数大于目标值，在左边找
            right = middle - 1;
        } else if(nums[middle] < target){
            left = middle + 1;
        } else if(nums[middle] == target){
            if((middle > 0 && nums[middle - 1] != target) || middle == 0)
                return  middle;
            else
                right = middle - 1;
        }
        return getFirstK(nums, left, right,target);
    }

    private static int getLastK(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;
        int middle = left + ((right - left)>>1);
        if(nums[middle] > target) {//中间数大于目标值，在左边找
            right = middle - 1;
        } else if(nums[middle] < target){
            left = middle + 1;
        } else if(nums[middle] == target){
            if((middle < right && nums[middle + 1] != target) || middle == right)
                return  middle;
            else
                left = middle + 1;
        }
        return getLastK(nums, left, right,target);
    }
}
