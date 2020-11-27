package StringAlgorithm;

/**
 * @Description 马拉车算法：返回长回文子序列
 * @Author Jianhai Wang
 * @ClassName Manacher
 * @Date 11/26/2020 3:51 PM
 * @Version 1.0
 */


public class Manacher {

    /**
     * 暴力破解通过
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int max = 1; //最长回文子序列长度, 注意一个字母也是回文序列
        int begin = 0;
        //测试任意区间是否为回文序列
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > max && validity(s, i, j)) {
                    begin = i;
                    max = j - i + 1;
                }
            }
        return s.substring(begin, begin + max);
    }

    private static boolean validity(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        }
        return true;
    }

    /**
     * 动态规划
     * 该方法是错误的：
     * 填表的时候参考的值还未计算出来，这叫"有后效性"
     * 就是后面将要计算的状态值需要参考的状态值还未计算出来。此时状态转移是错误的。
     *
     *
     * 状态有效性：当前状态是根据数据的左下角计算出来的，因此需要先要确定左下角的状态。
     * 错误方法示例
     */
    private static String funcDP(String s) {
        if (s == null || s.length() < 2)
            return s;
        char[] str = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        int max = 1;
        int begin = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (str[i] == str[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (j - i + 1 > max && dp[i][j] == true) {
                    begin = i;
                    max = j - i + 1;
                }
            }
            printdp(dp);
            System.out.println();
        }

        return s.substring(begin, begin + max);
    }


    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
       if(s == null || s.length() < 2)
           return s;
       char[] str = s.toCharArray();
       boolean[][] dp = new boolean[s.length()][s.length()];
       for(int i = 0; i < s.length(); i++){
           dp[i][i] = true;
       }
       int begin = 0;
       int max = 1;
       for(int j = 1; j < s.length(); j ++){
           for(int i = 0; i < j; i++){
               if(str[i] == str[j]){
                   if(j - i < 3) //两个字符
                       dp[i][j] = true;
                   else
                       dp[i][j] = dp[i + 1][j - 1];
               }
               if(dp[i][j] && j - i + 1 > max){
                   max = j - i + 1;
                   begin = i;
               }
           }
           printdp(dp);
           System.out.println();
       }
       return s.substring(begin, begin + max);
    }



    public static void printdp(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j])
                    System.out.print("T ");
                else System.out.print("F ");
            }
            System.out.println();
        }
    }


    /**
     * 马拉车算法
     *
     * @param str
     * @return
     */

    //最大回文子串：扩展原始串，
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0; //原字符串下标
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];  //奇数为#
        }
        return res;
    }

    /**
     * 三种情况：
     * （1） i 在边界外 --》暴力扩
     * （2） i 在边界内
     * 1） i'   在L，R内     Z[k(aba)t F ta b abk]Y    O(1)
     * 2） i'   在L,R外    (ab[cdcba)t t tabc d c]F     O(1)
     * 3） i'   L压线   T[abcbak k kabcba]k
     */
    //借助辅助数组求每个数据的回文半径，分为实轴和虚轴，虚轴就是为了让字符串不管是奇数个还是偶数个都能统一格式
    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length]; //保存回文半径
        int C = -1;//回文中心
        int R = -1; //回文右边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) { //i代表每一个字符求其回文中心
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;   //这就是边界min(pArr[2 * C - i], R-i)，是否更大需要自己去比较
            //2*C - i 就是i的对称点。当i < R的时候，就是i在回文边界里面就会有一个不用验的区域。
            //R-i右边区域界定，pArr[2 * C - i]对称点的回文半径。不管压不压线，下面继续对比。


            //pArr[i] 至少是1，以i为中心继续扩.  没有回文序列半径就是1，就是他自己
            //           # a # b # c # 1 # 2 # 3 # 4 # 3 # 2 # 1 # a # b #
            //pArr       1 2 1 2 1 2 1 2 1 2 1 2 1 8 1 2 1 2 1 2 1 2 1 2 1
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                //直径小于字符串长度，且有有边界。半径加上当前中心没超边界
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (i + pArr[i] > R) {//更新最大的右边界与之对应的中心
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);   //最大回文长度
            print(pArr);
        }
        return max - 1;
    }

    private static void print(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[a.length - 1] + "]");
        System.out.println();
    }


    public static void main(String[] args) {

        System.out.println(maxLcpsLength("babab"));

    }
}
