package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 选择排序
 * @Author Jianhai Wang
 * @ClassName SelectSort
 * @Date 2019/11/5 23:21
 * @Version 1.0
 */


public class SelectSort {
    //时间复杂度严格为：O（N^2）
    public static void selectSort(int[] nums){
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex])
                    minIndex = j;
            }
            swap(nums, i, minIndex);
            //utils.swap(nums, i, minIndex);  //为什么会出错
        }
    }
}
