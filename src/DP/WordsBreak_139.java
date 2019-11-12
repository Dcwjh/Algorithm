package DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Description LeetCode 139 单词拆分：https://leetcode-cn.com/problems/word-break/
 * @Author Jianhai Wang
 * @ClassName WordBread_139
 * @Date 2019/11/11 14:42
 * @Version 1.0
 */

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */

public class WordsBreak_139 {
    public static boolean worksBreak(String s, List<String> wordDict){
        //提高效率
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // s[0,j] s[j+1,i]
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                //前面的s[0,j]已经在字典中，看后面的
                if(dp[j] && wordDictSet.contains(s.substring(j, i))) { //substring从0开始，前置一个条件代表从j开始匹配，比较s[j,i]
                    dp[i] = true;
                    print(dp);
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void print(boolean[] dp){
        System.out.println("动态数组为：");
        for(int i = 0; i < dp.length; i++){
            if(dp[i])
                System.out.print("T" + " ");
            else
                System.out.print("F" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s= "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(worksBreak(s,wordDict));
    }
}










