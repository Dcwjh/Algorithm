package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 数组流中的中位数
 * Address https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author Jianhai Wang
 * @ClassName Interview41
 * @Date 2020/6/24 21:46
 * @Version 1.0
 */

//优先队列了解一下：https://baijiahao.baidu.com/s?id=1665383380422326763&wfr=spider&for=pc
public class Interview41 {
    //默认小根堆，大根堆在左，小根堆在右，且大根堆< 大根堆里面的数。
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);  //正序是o1.compareTo(o2)
        }
    });

    private int number = 0;

    //大根堆  + 小根堆(大根堆都是小的数，小根堆都是大的数)
    public void Insert(Integer num) {
        number++;
        if((number&1)== 1){//奇数  要插入大根堆，但是数太大，需要插入小根堆然后去除最小的数
            //如果数太大，大于小根堆最小值，则需要插入小根堆，且把小根堆最小的值拿出来插入大根堆
            if(!minHeap.isEmpty() && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();//poll是删除并取队首，而peek仅仅是取
            }
            //没有元素或者其他情况
            maxHeap.offer(num);
        } else{ //偶数  插入小根堆
            if(!maxHeap.isEmpty() && num < maxHeap.peek()) {  //太小  需要在大根堆操作一下
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }



    public Double GetMedian() {
        double res = 0;
        if((number&1) == 1){
            res = maxHeap.peek();
        } else {
            //res = maxHeap.peek() + ((minHeap.peek() - maxHeap.peek()) >>1);   这个方法不行，会把小数省略去。整数除2可以
           // res = maxHeap.peek() + (minHeap.peek() - maxHeap.peek()) / 2.0; //可行，防止越界
            res = (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return res;
    }

}
