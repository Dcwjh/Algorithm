package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 子树着色问题：
 * 对一棵树进行着色，每个结点可着黑色或白色，相邻结点不能着相同黑色，但可着相同白色。
 * 令树的根为r，请设计一种算法对树中尽量多的节点着黑色。
 * @Author Jianhai Wang
 * @ClassName TreeColor
 * @Date 2019/11/9 11:10
 * @Version 1.0
 */

/*
采用动态规划自下而上的方式求解。

设问题的最优解为opt(r),物理含义为对r为根节点的树着色可着最多黑色节点的数量，
最优解求解公式为$$opt(r) = max(opt(r,0),opt(r,1))$$
第二个参数1表示对根节点着色黑色，0表示着白色。由着色规则可知ci表示r的子节点：
$$opt(r) = \sum max(opt(c_i,0),opt(c_i,1))$$
$$opt(r,0) = \sum opt(c_i,0) + 1$$

具体步骤为初始化叶子节点设其着黑的opt为1，着白色的opt为0.然后向上依据上面两个公式进行求解。
 */

public class TreeColor {
    static class Tree{ //根节点为数组第一个
        int father;
        int childNum;
        int[] child = new int[100];
        public Tree(){
            childNum = 0;
        }
        public Tree(int childNum){
            this.childNum = childNum;
            child = new int[childNum];
        }
    }

    public static int getMaxBlack(Tree[] tree) {
        if(tree == null)
            return 0;
        else if(tree.length == 1)
            return 1;
        int n = tree.length;
        int[] black = new int[n];
        int[] white = new int[n];
        Arrays.fill(black,-1);
        Arrays.fill(white,-1);
        int i;
        for(i = n-1; tree[i].childNum == 0; i--){
            black[i] = 1;
            white[i] = 0;
        }
        for(; i >= 0;i--){
            white[i] = 0;
            for(int j = 0; j < tree[i].childNum;j++){
                white[i] += Math.max(black[tree[i].child[j]],white[tree[i].child[j]]);
            }
            black[i] = 1;
            for(int j = 0; j < tree[i].childNum;j++){
                black[i] += white[tree[i].child[j]];
            }
        }
        System.out.println(Arrays.toString(black));
        System.out.println(Arrays.toString(white));

        return Math.max(black[0],white[0]);
    }

    public static Tree[] build(){
        System.out.print("请输入建立的节点个数：");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree[] tree = new Tree[n];
        for(int i = 0; i < n; i++){
            tree[i] = new Tree();
        }
        System.out.println("请输入每个节点的父节点：");
        for(int i = 0; i < n; i++){
            tree[i].father = in.nextInt();
        }

        for(int i = 0; i < n; i++){  //统计从i节点开始子节点的个数。
            for(int j = 1; j < n; j++)
                if(tree[j].father == i){
                    tree[i].child[tree[i].childNum ++] = j;
                }
        }
        return tree;
    }

    public static void main(String[] args) {
        Tree[] tree = build();
        System.out.println(getMaxBlack(tree));
    }
}
