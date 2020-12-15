package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L49_groupAnagrams
 * @Date 12/14/2020 8:50 AM
 * @Version 1.0
 */


public class L49_GroupAnagrams {
    //排序后得字符串作为键值，原来的值作为map的值
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] ans = str.toCharArray();
            Arrays.sort(ans);
            String key = new String(ans);
            List<String> list= map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    //方法二和上面差不多，统计词频，字符和词频为组合键
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            int[] ans = new int[26];
            for(int i = 0; i < str.length(); i++){
                ans[str.charAt(i) - 'A'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if(ans[i] != 0){
                    sb.append('a' + i);
                    sb.append(ans[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }
}
