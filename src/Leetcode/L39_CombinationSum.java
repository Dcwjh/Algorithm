package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L39_CombinationSum
 * @Date 1/8/2021 4:55 PM
 * @Version 1.0
 */


public class L39_CombinationSum {

    //自己写的还不够优化，再接再厉
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates.length == 0) return list;
        Arrays.sort(candidates);
        dfs(candidates,target,list, null, candidates[0]);
        return list;
    }

    /**
     *
     * @param candiates
     * @param target  还剩下多少
     * @param list  返回的集合
     * @param res   当前正在添加的集合
     * @param value  当前的正在进行的值（candiates内的值），按序拍好了
     */

    private void dfs(int[] candiates, int target,List<List<Integer>> list, List<Integer> res, int value){
        if(target == 0) {
            list.add(res);
            return;
        }
        if(target < candiates[0]) return;
        for(int index : candiates) {
            List<Integer> temp =new ArrayList<>();
            if( res!= null) temp.addAll(res);
            if (index <= target && index >= value) {
                temp.add(index);
                dfs(candiates, target - index, list,temp, index);
            }
        }
    }


    //参考别人写的，优化很多
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if(candidates.length == 0) return list;
        Arrays.sort(candidates);
        Stack<Integer> res = new Stack<>();
        backtrack(candidates,target, res, 0);
        return list;
    }

    private void backtrack(int[] candidates, int target, Stack<Integer> res, int index){
        if(target == 0){
            list.add(new ArrayList<>(res));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[index] <= target){
                res.push(candidates[index]);
                backtrack(candidates,target-candidates[i],res, i);
                res.pop();
            } else break;
        }
    }






    public static void main(String[] args) {
        new L39_CombinationSum().combinationSum1(new int[]{2,3,6, 7},7);
    }
}
