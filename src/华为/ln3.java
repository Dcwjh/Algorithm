package 华为;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln3
 * @Date 2021/9/8 21:28
 * @Version 1.0
 */


public class ln3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        List<String> strings = new ArrayList<>();
        while(in.hasNextLine()){
            String string = in.nextLine();
            strings.add(string);
        }
        Set<String> set = new HashSet<>();
        //开始的标志
        set.add("start");
        //统计所有模块的名称，可以映射
        for(String s: strings){
            String[] temp = s.split(",");
            for(int i = 0; i < temp.length; i++){
                if(i != 1){
                    set.add(temp[i]);
                }

            }
        }
        //将字母映射成数字
        HashMap<String, Integer> mapping = new HashMap<>();
        int index = 0;
        for(String s : set){
            mapping.put(s, index);
            index++;
        }
        //保存节点的下一个节点位置
        HashMap<String, List<String>> relation = new HashMap<>();
        relation.put("start", new ArrayList<String>());
        int[][] weights = new int[set.size()][set.size()];
        for(String s: strings){
            String[] temp = s.split(",");
            //String end = temp[0];
            if(temp.length == 2){
                List<String> start = relation.get("start");
                start.add(temp[0]);
                weights[mapping.get("start")][mapping.get(temp[0])] = Integer.parseInt(temp[1]);
            } else{
                for(int i = 2; i < temp.length; i++){
                    weights[mapping.get(temp[i])][mapping.get(temp[0])] = Integer.parseInt(temp[1]);
                    if(relation.containsKey(temp[i])){
                        List<String> next = relation.get(temp[i]);
                        next.add(temp[0]);
                    } else{
                        List<String> next = new ArrayList<>();
                        next.add(temp[0]);
                        relation.put(temp[i], next);

                    }
                }
            }
        }

        //检查是否有循环依赖
        for(int i = 0; i < set.size() - 1; i++){
            for(int j = i + 1; j < set.size(); j++){
                if(weights[i][j] != 0 && weights[j][i] != 0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        Queue<String> que = new ArrayDeque<>();
        que.add("start");
        //保存执行到该任务需要的最大时间
        int[] end = new int[set.size()];
        int max = 0;
        //从头开始遍历
        while(!que.isEmpty()){
            String node = que.poll();
            //执行到结束的模块
            List<String> nextNodes = relation.get(node);
            //缺少模块，提前终止
            if(!node.equals(name) && (nextNodes.size()==0 || nextNodes == null)){
                System.out.println(-1);
                break;
            }
            //到该任务了，数组到该任务的时候最大时间
            if(node.equals(name)){
                System.out.println(end[mapping.get(node)]);
                break;
            }
            for(String next : nextNodes){
                que.add(next);
                end[mapping.get(next)] = Math.max(end[mapping.get(next)], end[mapping.get(node)] + weights[mapping.get(node)][mapping.get(next)]);
            }

        }
    }
}
/*
m2
m2,10,m1
m1,10,m2
 */
/*
m2
m2,10,m1
 */

/*
m3
m1,10
m2,5
m3,10,m1,m2
 */