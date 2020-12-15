package Leetcode;

import java.util.LinkedList;

/**
 * @Description 滑动窗口最大值
 * @Address https://leetcode-cn.com/problems/sliding-window-maximum/
 * @Author Jianhai Wang
 * @ClassName LeetCode239
 * @Date 2020/7/6 9:37
 * @Version 1.0
 */


public class L239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < 1 || nums.length < k)
            return null;
        //qmax保存最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            while(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i])
                qmax.pollLast();
            qmax.addLast(i);
            if(qmax.peekFirst() == i - k){
                qmax.pollFirst();
            }
            if(i >= k - 1){
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }

}
