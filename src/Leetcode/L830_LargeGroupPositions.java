package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L830_LargeGroupPositions
 * @Date 1/5/2021 9:10 AM
 * @Version 1.0
 */


public class L830_LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] str  = s.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        if(s.length() < 3) return res;
        int start = 0;
        int end = 0;
        for(int i = 1;i < str.length; i++){
            if(str[i] == str[end]){
                end = i;
                if(i == str.length - 1 && end - start >=2){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
            }else {
                if(end - start  >= 2){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
                start = i;
                end = i;
            }
        }
        return res;
    }

    /**
     * 其他思路
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) { //当字符是最后一个字符或者，下一个字符不等于上一个字符，统计
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;  //统计完成，重新统计
            } else {
                num++;
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        new L830_LargeGroupPositions().largeGroupPositions("abcdddeeeeaabbbcd");
    }
}
