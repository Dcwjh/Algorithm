package Leetcode;

/**
 * @Description 无重复字符的最长子串
 * @Address https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author Jianhai Wang
 * @ClassName LeetCode3
 * @Date 2020/7/4 22:00
 * @Version 1.0
 */


public class L3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
         int max = 0;
         int[] ch = new int[256];
         int start = 0;
         char[] str = s.toCharArray();
         for(int i = 0; i < s.length();i++){
             if(ch[str[i]] == 0){
                 ch[str[i]]++;
                 max = Math.max(max, i - start + 1);
             } else if(ch[str[i] ] == 1){
                 while(str[start] != str[i]) {
                     ch[str[start]]--;
                     start++;
                 }
                 start++;
             }
         }
         return max;
    }

    public static void main(String[] args) {
        System.out.println(new L3_LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt"));
    }
}
