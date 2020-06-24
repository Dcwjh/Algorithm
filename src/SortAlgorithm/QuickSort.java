package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 常规思路
 * @Author Jianhai Wang
 * @ClassName QuickSort
 * @Date 2019/11/5 22:51
 * @Version 1.0
 */


public class QuickSort {
    public static void quickSort(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        quickSort1(nums, 0, nums.length - 1);
    }

    /**
     * 时间复杂度：
     * 最好：O(nlogn)
     * 最坏: O(n^2)
     * 平均: O(nlogn)
     * 空间复杂度：O(logn ~ n)
     * 稳定性： 不稳定
     * @param nums
     * @param left
     * @param right
     */

    public static void quickSort1(int[] nums, int left, int right) {
        if(left < right) {
            int pivot = partition(nums, left, right);
            quickSort1(nums, left, pivot - 1);
            quickSort1(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1;
        int r = right;
//        System.out.println("pivot: " + pivot + " 当前结果： " + Arrays.toString(nums));
//        System.out.println("pivotIndex: " + pivotIndex + ";  l,r: " + l + " " + r);
        while(l < r) {   //不能=     为什么？？？
            if(nums[l] > pivot && nums[r] < pivot){
                swap(nums, l++, r--);
//                System.out.println("排序过程：" + Arrays.toString(nums));
            }
            if(nums[l] <= pivot) l++;
            if(nums[r] >= pivot) r--; //与pivot小的元素交换，返回r
        }

        swap(nums, pivotIndex, r); //（l > r）
//        System.out.println("此轮结束：" + Arrays.toString(nums));
//        System.out.println();
        return r;
    }
}
