package StringAlgorithm;

/**
 * @Description KMP:返回目标和模式匹配的第一个子串的首字符位置。 返回匹配到字符的首个索引。
 * @Author Jianhai Wang
 * @ClassName KMP
 * @Date 2019/11/6 13:51
 * @Version 1.0
 *
 *
 * 核心思想：辅助数组
 * 找出被匹配字符串的辅助数组加快匹配速度：最长前缀和最长后缀的匹配长度。
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
            if(arr1[i1] == arr2[i2]){  //
                i1++;
                i2++;
            } else if(next[i2] == -1)//next[0] = -1,但此时也不能匹配上，证明没有可以匹配的，从头开始， i1++, i2 = 0
                i1++;
            else
                i2 = next[i2];  ///next[i2]是当前匹配子串的最大匹配长度，跳转到最大匹配长度的下一个字符，看能否匹配上

        }
        return i2 == arr2.length?  i1 - i2 : -1;

    }
    // 这个是基于前面的求解出来的辅助数组
    public static int[] getNextArray(String str){
        char[] chars = str.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;  //起始位置，就是这样定义，表示不能跳转
        next[1] = 0; //第二个字符，前面只有一个字符，所以不能匹配，就是0
        int cn = 0;   //若为数值代表，最长匹配长度。若为下表代表最长匹配长度的下一个
        int i = 2;
        while(i < chars.length){
            if(chars[i - 1] == chars[cn]){//匹配上，就长度加一
                next[i++] = ++cn;
            }else if(cn > 0){   // 没有匹配上，判断最长长度是否大于0，看还有没有能配上的可能。如果cn = 1，那么此次cn就会被被赋值为0，从头开始匹配
                cn = next[cn];  //如果cn = 1，
            } else{  //cn = 0都没有匹配上，没希望了，最大长度就是0
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {

        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getMaxStringIndex(str, match));

    }
}
