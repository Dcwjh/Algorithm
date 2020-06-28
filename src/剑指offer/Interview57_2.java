package 剑指offer;

import java.util.LinkedList;

/**
 * @Description 和为s的连续正数序列
 * @Author Jianhai Wang
 * @ClassName Interview57_2
 * @Date 2020/6/28 16:04
 * @Version 1.0
 */


public class Interview57_2 {

    //滑动窗口，双指针
    public int[][] findContinuousSequence(int target) {
        LinkedList<int []> list = new LinkedList<>();
        int sum = 1;
        int left = 1;
        int right = 1;
        while(right <= (target/2 + 1)) {

            if(sum < target){
                right++;
                sum += right;
            } else if(sum > target){
                sum-= left;
                left++;
            } else {
                int[] arr = new int[right - left + 1];
                for (int i = 0; i <= right - left; i++) {
                    arr[i] = left + i;
                }
                list.add(arr);
                // 左边界向右移动
                sum -= left;
                left++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }


}
