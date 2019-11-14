package DP;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description Leetcode: 140题
 * @Author Jianhai Wang
 * @ClassName WordsBreak_140
 * @Date 2019/11/13 1:04
 * @Version 1.0
 */


public class WordsBreak_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            LinkedList<String> str = new LinkedList<>();
            for(int j = 0; j < i; j++){
                if(dp[j].size() > 0  && wordDict.contains(s.substring(j,i))){
                    for(String l: dp[j])
                        str.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                }
            }
            dp[i] = str;
        }
        return dp[s.length()];

    }
}
