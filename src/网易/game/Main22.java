package 网易.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Main2
 * @Date 2021/8/28 16:30
 * @Version 1.0
 */




public class Main22 {

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
    // 1
    public static int fun(Node[] nodes){
        int n = nodes.length; //
        Set<Integer> set = new HashSet<>(); //daib
        for(int i = 1; i < nodes.length; i++){
            if(nodes[i].pre.size() == 0){
                set.add(i);
                nodes[i].end = nodes[i].time;
            }
        }
        while(true){
            for(int i = 1; i < n; i++){
                //该任务执行过
                if(set.contains(i)){
                    continue;
                }
                //这个任务没有执行过，就先确定先置任务的执行
                ArrayList<Integer> pretask = new ArrayList<>(nodes[i].pre);
                for(Integer p : pretask){
                    if(set.contains(p)){
                        nodes[i].end = Math.max(nodes[p].end + nodes[i].time, nodes[i].end);
                        nodes[i].pre.remove(p);
                    }
                }
                //没有前置任务执行完了，证明本任务也可以结束了
                if(nodes[i].pre.size() == 0){
                    set.add(i);
                }

            }
            if(set.size() == n - 1){
                break;
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


2
3
5 0
10 1 1
15 1 1
4
3 0
4 1 3
7 1 1
9 2 1 2

 */
