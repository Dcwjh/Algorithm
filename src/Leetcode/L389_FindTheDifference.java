package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L389
 * @Date 12/18/2020 8:50 AM
 * @Version 1.0
 */


public class L389_FindTheDifference {
    /**
     *
     * 常规思路：统计
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] res = new int[26];
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        for(char ch : s1)
            res[ch-'a']++;
        for(char ch : s2){
            res[ch-'a']--;
            if(res[ch-'a'] < 0)
                return ch;
        }
        return ' ';

    }

    /**
     * 求和
     */
    public char findTheDifference1(String s, String t) {
        int sum = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        for(char ch : s2)
            sum += ch - 'a';
        for(char ch : s1){
            sum -= ch - 'a';
        }
        return (char)(sum+'a');

    }

    /**
     * 位运算
     */
    public char findTheDifference2(String s, String t) {
        int bit = 0;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        for(char ch : s2)
            bit ^= ch;
        for(char ch : s1){
            bit^=ch;
        }
        return (char)bit;
    }
}
