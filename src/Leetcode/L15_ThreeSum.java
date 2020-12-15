package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ThreeSum_15
 * @Date 2019/11/28 15:53
 * @Version 1.0
 */


public class L15_ThreeSum {
    /**
     * 数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * 时间复杂度：O(n^2)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return null;
        List<List<Integer>> lists = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //和上一个书相同，去重
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else right--;

            }
        }
        return lists;
    }

    public static void print(List<List<Integer>> lists){
        for(int i = 0; i < lists.size(); i++){
            ListIterator<Integer> it = lists.get(i).listIterator();
            System.out.print("[");
            while(it.hasNext()){
                if(it.nextIndex() == lists.get(i).size() - 1)
                    System.out.print(it.next());
                else
                    System.out.print(it.next() + ", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        print(threeSum(nums));
    }
}
