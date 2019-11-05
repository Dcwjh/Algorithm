package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 基于荷兰国旗问题的快速排序算法
 * @Author Jianhai Wang
 * @ClassName NewQuickSort
 * @Date 2019/11/5 23:03
 * @Version 1.0
 */

public class NewQuickSort {

    public static void newQuickSort(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        newQuickSort1(nums, 0, nums.length - 1);
    }

    public static void newQuickSort1(int[] nums, int left, int right){
        if(left < right){
            swap(nums, left + (int)(Math.random() *(right - left + 1)), right);
            int[] p = partition2(nums, left, right);
            newQuickSort1(nums, left, p[0] - 1);
            newQuickSort1(nums, p[1] + 1, right);
        }
    }
    public static int[] partition(int[] nums, int left, int right){
        int less = left - 1; //less 是小于基于比教的数 0~less
        int more = right;  //最后一个数就是基于比较的数
        while(left < more){  //left 作为游标
            if(nums[left] < nums[right]){
                swap(nums, ++less, left++);
            } else if(nums[left] > nums[right]){
                swap(nums, --more, left);  //more指向的是不确定的数字，交换后left不能++
            } else{
                left++;
            }
        }
        swap(nums, more, right); //交换一个大于num的数
        return new int[]{ less + 1, more};
    }

    public static int[] partition2(int[] nums, int left, int right){
        int less = left - 1;
        int more = right;
        int num = nums[right];
        while(left < more){
            if(nums[left] < num){
                swap(nums, ++less, left++);
            } else if(nums[left] > num){
                swap(nums, --more, left);
            } else{
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }
}
