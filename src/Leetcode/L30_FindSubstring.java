package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L30_FindSubstring
 * @Date 12/16/2020 4:17 PM
 * @Version 1.0
 */


public class L30_FindSubstring {
    /**
     * 暴力法+ 两个hash表
     * @param s
     * @param words
     * @return
     *
     * 思路解析：暴力法破解，因为需要从字符串s从0开始，则需要对比子串和words数组内所有单词的排列组合，为了防止这种复杂度，我们采用统计的方法。
     * 将words的内容单词的频率存储在第一个hash表中，key为单词，value，为出现的次数。
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int wordNum = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        //暴力遍历子串
        loop:for(int i = 0; i < s.length() - wordLen * wordNum + 1; i++){
            Map<String, Integer> map2 = new HashMap<>();
            for(int j = 0; j < wordNum; j++){
                String temp = s.substring(i + j * wordLen, i + (j+1) * wordLen );
                if(map.containsKey(temp)){
                    map2.put(temp, map2.getOrDefault(temp,0) + 1);
                    if(map2.get(temp) > map.get(temp)){
                        continue  loop;
                    }
                }else{
                    continue loop;
                }
            }
            list.add(i);

        }
        return list;
    }


    /**
     *
     * 加速不成功日后在优化
     * 作为固定的滑动窗口。一共出现三种情况：
     * 优化：
     *      1.子串出现不存在的单词。循环定位到子串从不存在单词的下一个。
     *      2.子串词频超了。循环就从超了了这个单词从新开始
     *      3.匹配上了。循环就移动一个单词的长度
     */

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int wordNum = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        //暴力遍历子串
        loop:for(int i = 0; i < s.length() - wordLen * wordNum + 1;){
            Map<String, Integer> map2 = new HashMap<>();
            for(int j = 0; j < wordNum; j++){
                String temp = s.substring(i + j * wordLen, i + (j+1) * wordLen );
                if(map.containsKey(temp)){
                    map2.put(temp, map2.getOrDefault(temp,0) + 1);
                    if(map2.get(temp) > map.get(temp)){
                        //词频超了那就从当前单词开始，找到第一次出现这个单词开始
                        for(int m = 0; m < wordNum; m++){
                            String findFirstWord = s.substring(i + m * wordLen, i+ (m+1) * wordLen );
                            if(temp.equals(findFirstWord)) {
                                i = i + (m+1) * wordLen;
                                continue  loop;
                            }
                        }

                    }
                }else{
                    //子串出现不存在的单词。循环定位到子串从不存在单词的下一个。
                    //i = i + (j+1) * wordLen;
                    i ++;
                    continue loop;
                }
            }
            //匹配上了。循环就移动一个单词的长度, 如果字母都相同呢
            list.add(i);
            i = i + wordLen;

        }
        return list;
    }


    //"barfoofoobarthefoobarman"  6    ，9，12
    // ["bar","foo","the"]

    //"wordgoodgoodgoodbestword" 8
    //["word","good","best","good"]
    public static void main(String[] args) {
        //6,9,12
        System.out.println(new L30_FindSubstring().findSubstring2("aaaaaaaaaaaaaa", new String[]{"aa","aa"}));
    }
}
