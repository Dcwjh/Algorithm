package StringAlgorithm;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName KMP
 * @Date 2019/11/6 13:51
 * @Version 1.0
 */


public class KMP {
    public static int getMaxStringIndex(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() <1 || str2.length() > str1.length())
            return -1;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int[] next = getNextArray(str2);
        int i1 = 0;
        int i2 = 0;
        while(i1 < arr1.length && i2 < arr2.length){
            if(arr1[i1] == arr2[i2]){
                i1++;
                i2++;
            } else if(next[i2] == -1)
                i2 = next[i2];
            else
                i1++;

        }
        return i2 == arr2.length?  i1 - i2 : -1;



    }

    public static int[] getNextArray(String str){
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i =2;
        while(i < chars.length){
            if(chars[i - 1] == chars[cn]){
                next[i++] = ++cn;
            }
        }
        return next;
    }
}
