package Leetcode;

import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L1046_LastStoneWeight
 * @Date 12/31/2020 3:33 PM
 * @Version 1.0
 */


public class L1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue queue = new PriorityQueue<Integer>((a,b)-> b-a);
//        peek()//返回队首元素
//        poll()//返回队首元素，队首元素出队列
//        add()//添加元素
//        size()//返回队列元素个数
//        isEmpty()//判断队列是否为空，为空返回true,不空返回false
        for(int i : stones)
            queue.add(stones);
        while(queue.size() > 1){
            int a = (int)queue.poll();
            int b = (int)queue.poll();
            if(a-b > 0)
                queue.add(a-b);
        }
        return queue.isEmpty()? 0 : (int)queue.peek();

    }
}
