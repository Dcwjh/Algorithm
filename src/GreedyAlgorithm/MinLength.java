package GreedyAlgorithm;

import java.util.Stack;

/**
 * @Description 给定直线上 2n个点的序列P[1,2,… ,2n]，每个点 P[i]要么是白点要么是黑点，其中共有n个白点和 n个黑点，
 * 相邻两个点之间距离均为1，请设计一个算法将每个白点与一黑点相连，使得连线的总长度最小。
 * 例如，图中有4个白点和4个黑点，以图中方式相连，连线总长度为1+1+1+5=8。
 * @Author Jianhai Wang
 * @ClassName MinLength
 * @Date 2019/11/24 16:30
 * @Version 1.0
 */

class pair{
    int value;
    int index;
    public pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

public class MinLength {

    public static int getMinLength(int[] nums){
        Stack<pair> stack = new Stack<>();
        int totalLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty()) {
                stack.push(new pair(nums[i],i));
            }else{
                if(stack.peek().value != nums[i]){
                    totalLength += (i - stack.pop().index);
                } else{
                    stack.push(new pair(nums[i],i));
                }
            }
        }
        return totalLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,1,1,1,0}; //0代表黑, 1代表白
        System.out.println("连线最小总长度位:" + getMinLength(nums));
    }
}
