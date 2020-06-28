package 剑指offer;

/**
 * @Description 数组中数值和下表相等的元素
 * @Author Jianhai Wang
 * @ClassName Interview53_3
 * @Date 2020/6/28 10:31
 * @Version 1.0
 */


public class Interview53_3 {
    //模板一： while(left <= right)
    public int getNumberSameAsIndex1(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right= nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left) >>1);
            if(nums[middle] == middle)
                return middle;
            else if(nums[middle] > middle){
                right = middle - 1;
            } else{
                left = middle + 1;
            }
        }
        return -1;
    }

    //模板二： while(left < right)
    public int getNumberSameAsIndex2(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right= nums.length - 1;
        while(left < right){
            int middle = left + ((right - left) >>1); //向下取整
            if(nums[middle] > middle){
                right = middle;
            } else{
                left = middle + 1;
            }
        }
        if(nums[left] == left)
            return left;
        return -1;
    }
}
