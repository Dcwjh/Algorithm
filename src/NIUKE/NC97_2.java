package NIUKE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC97_2
 * @Date 1/12/2021 11:39 PM
 * @Version 1.0
 */


public class NC97_2 {
    /*
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    //优先队列
    public  String[][] topKstrings (String[] strings, int k) {
        // write code here

        PriorityQueue<MyNode> queue=new PriorityQueue<>(new MyComparator());

        HashMap<String,Integer> map=new HashMap<>(16);
        for (int i=0;i<strings.length;i++){
            if (map.containsKey(strings[i])){
                map.put(strings[i],map.get(strings[i])+1);
            }else {
                map.put(strings[i],1);
            }
        }
        //入堆
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            queue.add(new MyNode(entry.getKey(),entry.getValue()));
        }
        String[][] result=new String[k][2];
        int j=0;
        while (j<k&&!queue.isEmpty()){
            MyNode node=queue.poll();
            result[j][0]=node.val;
            result[j++][1]= String.valueOf(node.num);
        }
        return result;

    }

    class MyNode{
        String val;
        int num;
        MyNode(String val,int num){
            this.num=num;
            this.val=val;
        }
    }

    class MyComparator implements Comparator<MyNode> {

        @Override
        public int compare(MyNode o1, MyNode o2) {
            if (o1.num==o2.num){
                //字典序小的在前 所以 o1 比 o2
                return o1.val.compareTo(o2.val); //出现次数相同时，按字母排序。否则按照数字排序
            }else {
                //数量大的在前所以 o2 - o1
                return o2.num-o1.num;
            }

        }
    }
}
