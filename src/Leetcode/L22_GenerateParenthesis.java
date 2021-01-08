package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L22_GenerateParenthesis
 * @Date 1/8/2021 2:12 PM
 * @Version 1.0
 */


public class L22_GenerateParenthesis {
    //深度优先遍历
    //当前左右括号都有大于 00 个可以使用的时候，才产生分支；
    //产生左分支的时候，只看当前是否还有左括号可以使用；
    //产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
    //在左边和右边剩余的括号数都等于 00 的时候结算。
    //
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0)
            return list;
        if(n == 1){
            list.add("()");
            return list;
        }
        String curr = new String();
        dfs(curr, n, n, list);
        return list;
    }

    /**
     * @param curr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param       左括号、右括号一共得用几个
     * @param list    结果集
     */


    private void dfs(String curr, int left, int right, List<String> list){
        if(left == 0&& right == 0){
            list.add(curr);
            return;
        }
        if(left > right)
            return;
        if(left > 0)
            dfs(curr +"(", left - 1, right, list);
        if(right > 0)
            dfs(curr + ")",left, right - 1, list);
    }


    class Node{
        private String res;
        private int left;
        private int right;
        public Node(String str, int left, int right){
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }
    //广度优先遍历
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;
        if (n == 1) {
            list.add("()");
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left == 0 && temp.right == 0){
                list.add(temp.res);
            }
            //这里面不需要剪枝，因为不是递归
            if(temp.left > 0){
                queue.offer(new Node(temp.res + "(", temp.left - 1, temp.right));
            }
            if(temp.right > 0 && temp.left < temp.right){  //这个temp.left < temp.right条件很重要
                queue.offer(new Node(temp.res + ")", temp.left, temp.right -1));
            }
        }
        return list;
    }


}
