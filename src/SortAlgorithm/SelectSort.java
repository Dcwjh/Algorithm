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

    /**
     * 算法思想：
     *          （1）位置从0到数组长度length,每次选出一个位置i，从前到后
     *          （2）最小值待定，暂定为当前位置，然后从当前的下一个位置往后遍历，逐个往后比较，选出符合最小，交换到i，该位置数值确定
     *
     * @param nums
     */
    public static void selectSort(int[] nums){
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex =  nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(nums, i, minIndex);
            //utils.swap(nums, i, minIndex);  //为什么会出错
        }
    }
}
