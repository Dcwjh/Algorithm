package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L76_MinWindow
 * @Date 12/18/2020 9:08 AM
 * @Version 1.0
 */


public class L76_MinWindow {

    /**
     * t指针不用，判断是否成功就使用hash一样判断
     * 算法思想：右指针向右移动过程中，判断两个hash表是否一致，如果不一致，右指针一直向右移动，直到匹配上（匹配成功则更新操作），然后左指针移动，直到不匹配
     * @param s
     * @param t
     * @return
     *
     *
     * @version 1.0
     *
         * 算法思路：右指针一直向右移动：移动过程需要判断两个hash表是否一致，一致，则左指针向右移动，并在移动过程中找到不满足条件（两个hash不相等）的变量，更新操作，并继续右指针
     */
    public static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        //又不需要考虑子串顺序，则使用hash统计词频
        Map<Character, Integer> map1 = new HashMap<>();
        int start = 0;
        int left = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int min = Integer.MAX_VALUE;
        for(char ch: s2){
            map1.put(ch, map1.getOrDefault(ch,0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for(int right = 0; right < s1.length; right++){
            if(map1.containsKey(s1[right])){
                map2.put(s1[right], map2.getOrDefault(s1[right],0) + 1);
                if(compare(map1,map2)){
                    while(compare(map1,map2)){
                        if(map2.containsKey(s1[left])){
                            map2.put(s1[left], map2.get(s1[left]) - 1);
                        }
                        left ++;
                    }
                    if(min > right - left + 2){
                        min = right -left + 2;
                        start = left - 1;
                    }
                }
            }

        }
        return min==Integer.MAX_VALUE? "" : s.substring(start, start + min);
    }


    private static boolean compare(Map<Character, Integer> map1, Map<Character, Integer> map2){
        if(map1 == null || map2 == null)
            return false;
        for(char ch : map1.keySet()){
            if(!map2.containsKey(ch) ||  map1.get(ch) > map2.get(ch))
                return false;
        }
        return true;
    }


    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow1(String s, String t) {
        if(s.length() < t.length())
            return "";
        //又不需要考虑子串顺序，则使用hash统计词频
        Map<Character, Integer> map1 = new HashMap<>();
        int start = 0;
        int left = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int min = Integer.MAX_VALUE;
        for(char ch: s2){
            map1.put(ch, map1.getOrDefault(ch,0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for(int right = 0; right < s1.length; right++){
            if(map1.containsKey(s1[right])){
                map2.put(s1[right],map2.getOrDefault(s1[right], 0) + 1);
            }
            while(compare(map1, map2) && left <= right){  //为什么要等于，因为 "a","a"
                if(min > right - left + 1){
                    start = left;
                    min = right - left + 1;
                }
                if(map2.containsKey(s1[left])){
                    map2.put(s1[left], map2.get(s1[left]) - 1);
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE?"" : s.substring(start, start + min);

    }



    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC",
            "ABC"));
    }
}
