package 剑指offer;

import java.util.LinkedList;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Interview59
 * @Date 2020/6/30 11:08
 * @Version 1.0
 */


public class Interview59 {

    //窗口对应的数据结构为 双端队列 ，本题使用 单调队列 即可解决以上问题。遍历数组时，每轮保证单调队列 dequedeque ：
    //小于最大值放在队列后面，大于的，把队列全部删除


    //队列单调非递增
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k == 0)
            return new int[0];

        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && queue.peekFirst() == nums[i - 1]) queue.pollFirst();
            while(!queue.isEmpty() && nums[j] > queue.peekLast()) queue.pollLast();
            queue.add(nums[j]);
            if(i >= 0) res[i] = queue.peekFirst();
        }


//        queue.add(nums[0]);
//        for(int i = 1; i < nums.length; i++){
//           while(queue.size() > 0 && nums[i] > queue.peekLast())
//               queue.pollLast();
//           queue.add(nums[i]);
//           if(i > k- 1){
//               res[i - k] = queue.peekFirst();
//               if(nums[i - k] == queue.peekFirst()){
//                   queue.pollFirst();
//               }
//
//           }
//        }
        return res;
    }

    public static void main(String[] args) {
        Interview59 test = new Interview59();
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = test.maxSlidingWindow(a,3);
        for(int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }
}
