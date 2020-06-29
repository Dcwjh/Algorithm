package 剑指offer;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description 反转字符串
 * @Address https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/
 * @Author Jianhai Wang
 * @ClassName Interview58
 * @Date 2020/6/29 9:03
 * @Version 1.0
 */


public class Interview58 {

    /**
     * 方法1：自行编写对应的函数
     *
     * 主要函数作用：第一步：去除多余的空格
     *              第二步：反转真个字符串
     *              第三步: 反转每个单词
     *
     * 去除多余的字符串  StringBuffer 字符串变量（线程安全）
     * StringBuilder 字符串变量（非线程安全）
     */
    private StringBuilder trimSpace(String s){
        //去除首位多余的空格键
        StringBuilder sb = new StringBuilder();
        //计算s第一个非空的字符
        int left = 0;
        while(left < s.length() && s.charAt(left) == ' ') left ++;
        //计算s最后一个非空字符
        int right = s.length() - 1;
        while(right > left && s.charAt(right) == ' ') right--;
        int index = left;
        //去除中间的非空字符
        while(index < right) {
            if(s.charAt(index) != ' ')
                sb.append(s.charAt(index++));
            else if(s.charAt(index - 1)!=' '){
                sb.append(s.charAt(index++));
            } else index++;
        }
        return sb;
    }

    //翻转字符串
    private void reverse(StringBuilder sb, int left, int right) {
        while(left < right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }


    public  String reverseWords(String s) {
        //去除多余的字符串
        StringBuilder sb = trimSpace(s);
        System.out.println("trime :" + sb);
        //反转整个字符串
        reverse(sb, 0, sb.length()-1);
        System.out.println("reverse " + sb);

        //反转单词
        int left = 0;
        int right = 0;
        while(right < sb.length()){
            if(sb.charAt(left) == ' '){
                left++;
                right++;
            } else if(sb.charAt(right) == ' '){
                reverse(sb, left, right-1);
                left = ++right;
            } else if(right == sb.length() - 1){  //特殊情况，最后一个单词需要单独处理
                reverse(sb, left, right);
                right++;
            } else
                right++;
        }
        return sb.toString();
    }


    /**
     * 方法2： 自带库函数
     *
     */
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    //上面的用不好，用下面这个
    public String reverseWords2_2(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }


    /**
     * 方法3： 双指针（推荐使用）
     *
     * 从尾部扫描字符串
     * 我写的方法
     */
    public String reverseWords3(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;
        while(start >= 0){

            if(start == 0) {
                sb.append(s.substring(start, end + 1));
                start--;
            } else if(s.charAt(start) !=' ') {
                start--;
            } else if(s.charAt(start) == ' '){
                sb.append(s.substring(start + 1, end + 1) + " ");
                while(start >=0 && s.charAt(start) == ' ')
                    start--;
                end = start;
            }  else
                start--;
        }
        return sb.toString();
    }

    //大佬的方法：双指针定位单词======》》推荐使用
    public String reverseWords3_2(String s) {
        //去除首位空格
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;
        while(start >= 0){
            //找到首个空字符或者第一个单词，并添加。
            while(start >= 0 && s.charAt(start) != ' ') start--; //搜索首个空字符 牛逼。到了最后一个单词不满足条件，下面也把单词加上去了
            sb.append(s.substring(start + 1, end + 1) + " ");
            //找到第一个非空字符，即下一个单词的尾字符
            while(start>=0 && s.charAt(start) == ' ')   start--; //搜索首个非空字符
            end = start;  //找到尾字符
        }
        return sb.toString().trim();
    }



    public static void main(String[] args) {
        Interview58 test = new Interview58();
        String s = "the sky is blue";
        System.out.println(test.reverseWords3_2(s));
    }
}
