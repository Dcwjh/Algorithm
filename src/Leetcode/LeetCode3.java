package Leetcode;

/**
 * @Description 无重复字符的最长子串
 * @Address https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author Jianhai Wang
 * @ClassName LeetCode3
 * @Date 2020/7/4 22:00
 * @Version 1.0
 */


public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int[] temp = new int[256];
        for(int start,end = 0; end < s.length(); end ++){
            char c = s.charAt(end);
            if(temp[c- 'A'] == 0) {
                temp[c - 'A']++;
                count ++;
            } else {
                max = Math.max(count,max);
                count = 0;
                start = end + 1;
            }

        }

        return 0;
    }
}
