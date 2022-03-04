package 面试;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName 美团3
 * @Date 2021/8/8 10:31
 * @Version 1.0
 */


public class 美团3 {

    public static int fun(int[] nums){ // 1到n ,移动n + 1的长度
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] pre = new int[nums.length];
        pre[1] = 0;
        stack1.push(nums[1]);
        for(int i = 1; i < nums.length; i++){
            //nums[i] 找到第一个不比自己小的数，然后保留上一个数。
            while(!stack1.isEmpty()){

                if(stack1.peek() < nums[i]){
                    stack2.push(stack1.pop());
                } else break;

            }
            if(stack1.isEmpty() || stack1 .peek() > nums[i]){
                stack1.push(nums[i]);
            }
            if(stack2.isEmpty()){
                pre[i] = 0;
            } else{
                pre[i] = stack2.peek();
            }
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }

        int sum = 0;
        for(int i = 1; i < pre.length; i++){
            sum += pre[i] * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1; i < nums.length; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(fun(nums));
    }
}
