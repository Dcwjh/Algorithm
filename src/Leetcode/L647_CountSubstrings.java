package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L647_CountSubstrings
 * @Date 2021/6/17 17:38
 * @Version 1.0
 */


public class L647_CountSubstrings {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder temp = new StringBuilder(sb);
        StringBuilder t = sb;  //指针，如果sb改变，则t也会改变，不应该设置指针，应该是实体
        sb.reverse();//sb会反转
        System.out.println(temp.toString().equals(sb.toString()));
    }
}
