package StringAlgorithm;

/**
 * @Description leetcode : 8. 字符串转换整数 (atoi) 网址：https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Author Jianhai Wang
 * @ClassName MyStrToInt
 * @Date 2019/11/16 11:04
 * @Version 1.0
 */


public class MyStrToInt_8 {

    /**
     * 思想：
     * 此题解用到了64位环境变量
     * 1.首先去除字符串左右空格,不符合条件的直接return 0;  改变了原来的数据
     * 2.sign是符号位,start指针指向第一个数字的位置,如果第一位为数字,则sign=1,start=0,否则firstChar接收字符串第一个字符,若为“+”、“-”,sign分别赋值1、-1,start自增1,
     * 3.从字符串第一个为数字的位置开始遍历,res为无符号结果,如果res大于Integer最大值且sign=1,输出Integer的最大值,反之输出Integer最小值,如果遍历到不为数字的字符,则直接返回res*sign;
     * 4.如果遍历时该字符串未超范围,且无非数字字符,则返回res * sign;
     *
     * @param str
     * @return
     */

    public static int strToI(String str){
        if (str == null ||  str.length() == 0)
            return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        // 先判断符号
        if (firstChar == '+') {
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        while(start < str.length()){
            if(!Character.isDigit(str.charAt(start))){
                break;
            }
            res = res * 10 + str.charAt(start) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            start++;
        }
//        for (int i = start; i < str.length(); i++) {
//            if (!Character.isDigit(str.charAt(i))) {
//                return (int) res * sign;
//            }
//            res = res * 10 + str.charAt(i) - '0';
//            if (sign == 1 && res > Integer.MAX_VALUE)
//                return Integer.MAX_VALUE;
//            if (sign == -1 && res > Integer.MAX_VALUE)
//                return Integer.MIN_VALUE;
//        }
        return (int) res * sign;
    }

    /**
     * 此题解用到了32位环境变量
     * 1. 去除空字符串
     * 2. 确定正负号
     * 3. 找出数字部分
     *
     * @param str
     * @return
     */

    public static int strToI2(String str) {
        if (str == null ||  str.length() == 0)
            return 0;
//       跳过空字符串
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        if(i == str.length())
            return 0;

//        确定正负号
        int flag = 1;
        char ch = str.charAt(i);
        if(ch == '+') {
            i++;
        }
        if(ch == '-'){
            flag = -1;
            i++;
        }

        //找出数值
        int res = 0;
        for(; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch < '0' || ch > '9')
                break;
            //先进行溢出判断
            if(flag > 0 && res > Integer.MAX_VALUE / 10) //最后一位，判断除个位以外是否溢出
                return Integer.MAX_VALUE;
            if(flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) // 个位是否溢出
                return Integer.MAX_VALUE;
            if(flag < 0 && -res < Integer.MIN_VALUE / 10)
                return  Integer.MIN_VALUE;
            if(flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + ch - '0';
        }

        return res * flag;

    }

    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "-42";
        String str3 =  "41259 sdfe";
        String str4 = "sefae 987";
        String str5 = "-91283472332";
        String str6 = "1253 srfef 4585 sfe 478 5s df 5s4 ";
        System.out.println(strToI2(str1));
        System.out.println(strToI2(str2));
        System.out.println(strToI2(str3));
        System.out.println(strToI2(str4));
        System.out.println(strToI2(str5));
        System.out.println(strToI2(str6));

//        System.out.println(Integer.MIN_VALUE % 10);  //负数


    }
}
