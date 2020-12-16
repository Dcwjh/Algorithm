package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L290_WordPattern
 * @Date 12/16/2020 10:23 AM
 * @Version 1.0
 */


public class L290_WordPattern {

    /**
     * 一个hashmap解法， 先将不存在的值存在map中，若已存在则取出，比较对应值
     * @param pattern
     * @param s
     * @return
     * @version 1.0 错误用例: "abba"   "dog dog dog dog"
     */
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        if(str.length != pattern.length()) return false;
        for(int i =0; i < str.length; i++){
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), str[i]);
                continue;
            }
            if(!map.get(pattern.charAt(i)).equals(str[i]))
                return false;
        }
        return true;
    }
    /**
     *
     * 在添加到map中，需要多添加一个判断
     * @Version 2.0
     *
     */

    public boolean wordPattern2(String pattern, String s) {
        String[] str = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        if(str.length != pattern.length()) return false;
        for(int i =0; i < str.length; i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(!map.containsValue(str[i])) {
                    map.put(pattern.charAt(i), str[i]);
                }else{
                    return false;
                }
                continue;
            }
            if(!map.get(pattern.charAt(i)).equals(str[i]))
                return false;
        }
        return true;
    }
}
