package 面试;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName huwei
 * @Date 2021/9/26 16:44
 * @Version 1.0
 */
public class huwei {
    private static int[] fun(int[] array) {
        if (array == null) return array;
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while (index < size) {
            //当前元素大于，栈顶元素。说明找到了栈顶的对应的那个值
            while (!stack.isEmpty() && array[index] > array[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = index - temp;
            }
            stack.push(index);
            index++;

        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 20, 500, 100, 400};
        System.out.println(Arrays.toString(fun(nums)));
    }




}
