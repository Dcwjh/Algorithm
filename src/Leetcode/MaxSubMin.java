package Leetcode;

import java.util.LinkedList;

/**
 * @Description 最大值减去最小值小于或者等于num的子数组数量
 * @Author Jianhai Wang
 * @ClassName MaxSubMin
 * @Date 2020/7/6 19:14
 * @Version 1.0
 */


public class MaxSubMin {
    public static int getNum(int[] arr, int num){
        if(arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while(start < arr.length) {
            while(end < arr.length){
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[end]){
                    qmin.pollLast();
                }
                qmin.addLast(end);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end]){
                    qmax.pollLast();
                }
                qmax.addLast(end);
                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){
                    break;
                }
                end ++;
            }
            if(qmin.peekFirst() == start) {
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == start){
                qmax.pollFirst();
            }
            res += end-start;
            start++;
        }
        return  res;
    }
}
