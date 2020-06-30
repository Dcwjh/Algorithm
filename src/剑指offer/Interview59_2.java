package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview59_2
 * @Date 2020/6/30 16:18
 * @Version 1.0
 */


public class Interview59_2 {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> maxQue;

    public Interview59_2() {
        queue = new LinkedList<>();
        maxQue = new LinkedList<>();
    }

    public int max_value() {
        if(maxQue.isEmpty())
            return -1;
        return maxQue.peekFirst();
    }

    public void push_back(int value) {
        while(!maxQue.isEmpty() && value > maxQue.peekLast()) maxQue.pollLast();
        maxQue.offerLast(value);
        queue.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty())
            return -1;

        //注意：如果是直接peek两个队列的数比较，请注意这样就是在比较两个Integer对象而不是基本类型int，要用equals不要用==，否则对于非缓存数字（-128 - 127）可能会出现明明值一样 == 却返回false的情况！
        if(queue.peekFirst().equals(maxQue.peekFirst()))
            maxQue.pollFirst();
        return queue.poll();
    }
}
