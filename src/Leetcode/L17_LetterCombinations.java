package Leetcode;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L17_LetterCombinations
 * @Date 1/7/2021 5:15 PM
 * @Version 1.0
 */


public class L17_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        for(int i = 0; i < digits.length(); i++){
            String temp = map.get(digits.charAt(i) - '0');
            String[] s= new String[res.size()];
            for(int m = 0; m < s.length; m++){
                s[m] = res.get(m);
            }
            res.clear();
            for(int j = 0; j < temp.length(); j++){
                if(s.length == 0)
                    res.add(temp.charAt(j) + "");
                else{
                    for(String t : s){
                        res.add(t+temp.charAt(j));
                    }
                }

            }
        }
        return res;
    }


    //官网题解
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    //DFS
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination); //深度优先遍历
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        new L17_LetterCombinations().letterCombinations("23");
    }
}
