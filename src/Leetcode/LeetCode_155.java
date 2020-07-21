package Leetcode;

import java.util.LinkedList;

/**
 * @Description 155. 最小栈
 * @Address     https://leetcode-cn.com/problems/min-stack/
 * @Author Jianhai Wang
 * @ClassName LeetCode_155
 * @Date 2020/7/21 20:39
 * @Version 1.0
 */


public class LeetCode_155 {
    LinkedList<Integer> stack;
    LinkedList<Integer> min;
    /** initialize your data structure here. */
    public LeetCode_155() {
         stack = new LinkedList();
         min = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if(min.isEmpty()){
            min.addLast(x);
        }else if(min.getLast() > x) {
            min.addLast(x);
        }

    }

    public void pop() {
        if(min.isEmpty())
            return;
        int x = stack.pollLast();
        if(x == min.getLast())
            min.pollLast();
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.getLast();
    }

    public int getMin() {
        if(min.isEmpty())
            return -1;
        return min.getLast();
    }
}
