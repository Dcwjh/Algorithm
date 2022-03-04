package Leetcode;

import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L739_DailyTemperatures
 * @Date 2021/6/11 11:05
 * @Version 1.0
 */


public class L739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < res.length - 1; i++) {
            int count = 0;
            int j = i + 1;
            while (j < res.length) {
                if (temperatures[i] < temperatures[j]) {
                    break;
                } else {
                    j++;
                }
            }
            if (j < res.length && temperatures[i] < temperatures[j]) {
                res[i] = j - i;
            }
        }
        return res;
    }

    //单调栈
    //若栈为空或者当日温度小于等于栈顶温度则直接入栈；
    //反之，若当日温度大于栈顶温度，说明栈顶元素的升温日已经找到了，则将栈顶元素出栈，计算其与当日相差的天数即可
    //出栈时统计个数
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i ++){
            if(stack.isEmpty()){
                stack.push(i);
            } else{
                if(temperatures[i] <= temperatures[stack.peek()]){
                    stack.push(i);
                } else{
                    while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                        res[stack.peek()] = i - stack.pop();
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }

}
