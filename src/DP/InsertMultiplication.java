package DP;

import java.util.Scanner;

/**
 * @Description 给出N个1-9的数字 ($v_1$,$v_2$,…,$v_N$)，不改变它们的相对位置，在中间加入K个乘号和N-K-1个加号，
 * （括号随便加）使最终结果尽量大。因为乘号和加号一共就是N-1个了，所以恰好每两个相邻数字之间都有一个符号。
 * 例如： N=5, K=2，5个数字分别为1、2、3、4、5，可以加成：
 * 1*2*(3+4+5)=24
 * 1*(2+3)*(4+5)=45
 * (1*2+3)*(4+5)=45
 * 并说明其具有优化子结构性质及子问题重叠性质。
 * @Author Jianhai Wang
 * @ClassName InsertMultiplication
 * @Date 2019/11/9 10:22
 * @Version 1.0
 */
/*
分析：
假设有序列$a_1$, $a_2$, $a_3$, \dots, $a_n$, 其目标结果最大值设为$f(n,k)$, 其中n表示前1~n个数，k表示其中有k个乘号。
于是有子问题：对于序列$a_1$, $a_2$, $a_3$, \dots, $a_i(1 \leq i \leq N)$, 其目标结果最大值设为$f(i,c)$.

对于f(n,k),其最大值取决于乘号的个数和所在的位置，因此对乘号进行动态规划。
其状态取决于：假设将其前1~n个数所在位置m处插入乘号，则1~m个数中的乘号为k-1, 而且剩下的m+1~n个数中全为加号，
乘号此时乘号给全部用完，于是此时的$f(n,k) = f(m, k-1) * \sum_{i = m+1}^n V_i$。

于是状态转移方程为：$$f(n,k) = max_{k\leq m < n}(f(m, k-1) * \sum_{i = m+1}^n V_i)$$
 */
public class InsertMultiplication {

    //求取数组A[start]到A[end]之间元素总和
    public long getSum(int[] A, int start, int end) {
        long sum = 0;
        for(int i = start;i <= end;i++)
            sum += A[i];
        return sum;
    }
    /*
     * 参数start：数组A中开始划分元素的起始位置
     * 参数multi:进行乘法运算的个数
     */
    public long getMax(int[] A, int start, int multi) {

        if(multi == 0)
            return getSum(A, start, A.length - 1);
        long max = 0;
        for(int i = start;i < A.length - 1;i++) {
            //此处i < A.length - 1原因是递归时start = i + 1，且start要小于等于A.length - 1
            //System.out.println("i = " + i + ":" + max);
            long tempMax = getSum(A, start, i) * getMax(A, i + 1, multi - 1);
            max = (Math.max(max, tempMax));

        }
        return max;
    }

    public static void main(String[] args){
        InsertMultiplication test = new InsertMultiplication();
        Scanner in = new Scanner(System.in);
        System.out.println("请分别输入一个整数n（整数的个数）和一个整数k（乘号个数）：");
        int n = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[n];
        System.out.println("请输入" + n + "个数字");
        for(int i = 0;i < n;i++) {
            A[i] = in.nextInt();
        }
        System.out.println(test.getMax(A, 0, k));
    }
}
