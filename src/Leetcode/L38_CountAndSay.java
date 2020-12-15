package Leetcode;

/**
 * @Description 题目不好理解
 * @Author Jianhai Wang
 * @ClassName CountAndSay
 * @Date 2019/12/16 20:50
 * @Version 1.0
 * 1
 * 2 描述的是1，是一个1，也就是11
 * 3 描述的是11，是两个1，也就是21
 * 4 描述的是21，是一个2一个1，也就是12-11
 * 5 描述的是1211, 是一个1，一个2，两个1，也就是11-12-21
 * 6 描述的是111221，是三个1，两个2，一个1，也就是31-22-11
 * 7 描述的是312211，是一个3一个1两个2两个1，也即是13-11-22-21
 * 以此类推
 *
 */


public class L38_CountAndSay {
    public static String countAndSay(int n ){
        if(n == 1)
            return "1";
        String pre = countAndSay( n - 1);
        StringBuilder sb = new StringBuilder();

        int index = 0;
        char ch = '#';
        for(int i = 0; i < pre.length(); i++){
            if(ch!= pre.charAt(i)){
                int len = i - index;
                sb.append(len);
                sb.append(ch);
                index = i;
                ch = pre.charAt(i);
            }
        }

        int len = pre.length() - index;
        sb.append(len);
        sb.append(ch);
        System.out.println(sb.substring(2));
        return sb.substring(2);


    }

    public static void main(String[] args) {
        countAndSay(5);
    }
}
