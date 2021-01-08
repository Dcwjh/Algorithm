package Leetcode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L455_FindContentChildren
 * @Date 12/25/2020 3:02 PM
 * @Version 1.0
 */


public class L455_FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            int ans = 0;
            while(i < g.length && j <s.length){
                if(s[j] >= g[i]){
                    ans++;
                    i++;
                    j++;
                } else{
                    j ++;
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(1.1,100));
    }
}
