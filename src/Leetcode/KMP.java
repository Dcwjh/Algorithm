package Leetcode;

/**
 * @Description 最大字串的第一序号，解决的是子串的问题  就是getIndexOf函数的核心思想
 * @Author Jianhai Wang
 * @ClassName KMP
 * @Date 2020/7/5 7:28
 * @Version 1.0
 *
 *
 * 两个概念：子序列可以连续也可以不连续
 *          子数组和子串：必须连续
 *
 *
 *          暴力思想：遍历字符串，每次都和子串比较。 O(N*M)
 *
 *          KMP: O(N)  辅助数组：需要保存最大前序串和最大后续串相等的最大值
 *
 *          a   b   a    b    a    c
 *         -1   0   0    1    2    3
 */




public class KMP {
    //辅助数组
    public static int[] getNextArray(char[] str2){
        if(str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;  //开始的位置
        next[1] = 0; //没有。要求最前子串不包括最后一个，最后子串不包括第一个
        int i = 2; //下表
        int cn = 0; //跳的位置
        while(i < next.length){
            if(str2[i - 1] == str2[cn]){  //当前位置是否等于跳的位置的下一个，根据前一个状态算后面的next状态/
                //cn个数变下标，所以就是代表下一个
                next[i ++] = ++cn; //个数，因为cn是下标，所以需要先++
            } else if(cn > 0) { //cn 有的跳，继续跳
                cn = next[cn];
            }
            else {
                next[i++] = 0;  //没得跳，证明没有相等的最前子串和最后子串，设置为0
            }
        }
        return next;
    }


    public static int getIndexOf(String s, String m){
        if(s == null || m == null ||m.length() < 1|| s.length() < m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){//配，继续配。
                //加快的步骤原因：第一不用每次都和str2从头开始配了。对接上直接开始下一个字符的匹配
                i1++;
                i2++;
            } else if(next[i2] == -1){ //不能跳，第一个字符都配不上
                i1++;
            } else{   //能跳，配就配下一个，就是找需要和i1配的那一个，以为前面都配上了
                i2 = next[i2]; //前面都配上了，直接比较下一个字符，就是减少了比较的次数
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }




}










