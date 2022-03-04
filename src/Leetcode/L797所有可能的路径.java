package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L797所有可能的路径
 * @Date 2021/9/7 9:49
 * @Version 1.0
 */


public class L797所有可能的路径 {
   static  List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        dfs(graph, 0,ans);
        return res;
    }

    private static void dfs(int[][] graph, int row, List<Integer> ans){
        if(row == graph.length - 1 || (graph[row][0] == row && graph[row].length == 1)){
            if(!res.contains(ans))
                res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = row; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j] != 0) {
                    int temp = graph[i][j];
                    graph[i][j] = 0;
                    ans.add(temp);
                    dfs(graph, temp, ans);
                    graph[i][j] = temp;
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }



    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if(graph == null || graph.length == 0){
            return res;
        }
        Queue<List<Integer>> que = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        que.add(path);
        while(!que.isEmpty()){
            List<Integer> tempPath = que.poll();
            int node = tempPath.get(tempPath.size() - 1);
            int[] nextNode = graph[node];
            for(int n : nextNode){
                List<Integer> t = new ArrayList<>(tempPath);
                t.add(n);
                if(n == graph.length - 1){
                    res.add(t);
                }else{
                    que.add(t);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
