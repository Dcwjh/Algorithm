package 网易.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main2
 * @Date 2021/8/28 16:30
 * @Version 1.0
 */


class Node{
    int index;//1
    int time;
    ArrayList<Integer> pre;
    int end;


    public Node(int index, int time, ArrayList<Integer> pre){
        this.index = index;
        this.time = time;
        this.pre = pre;
    }
}

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //几组数据
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            //几个任务
            int m = in.nextInt();
            Node[] nodes = new Node[m + 1];
            for(int j = 1; j < m + 1; j++){
                int time = in.nextInt();
                int pre_num = in.nextInt();
                ArrayList<Integer> t = new ArrayList<>();
                for(int k = 0; k < pre_num; k++){
                    int temp = in.nextInt();
                    t.add(temp);
                }
                nodes[j] = new Node(j, time, t);
            }
            System.out.println(fun(nodes));
        }

    }

    public static int fun(Node[] nodes){
        int n = nodes.length;
        for(int i = 1; i < n; i++){
            //没有前置时间可以直接执行ii
            if(nodes[i].pre.size() == 0){
                nodes[i].end = nodes[i].time;
                //System.out.println("没有前置的标号" + i);
            }
            //如果有前置任务让他们执行完，在执行自己，选择一个最大的
            ArrayList<Integer> a = nodes[i].pre;
            for(Integer index : a){
               // System.out.println(i + "的前置:" + index);
                nodes[i].end = Math.max(nodes[index].end + nodes[i].time, nodes[i].end);
               // System.out.println("end:" + nodes[i].end);
            }

        }
        int max = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(max, nodes[i].end);
            //System.out.println("i: " + i + "   end: "+  nodes[i].end );
        }
        return max;

    }
}

/*


3
3
5 0
10 1 1
15 1 1
4
3 0
4 0
7 1 1
6 2 1 2
4
3 0
4 1 3
7 1 1
6 2 1 2

 */
