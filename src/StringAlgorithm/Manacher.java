package StringAlgorithm;

/**
 * @Description 马拉车算法：返回长回文子序列
 * @Author Jianhai Wang
 * @ClassName Manacher
 * @Date 11/26/2020 3:51 PM
 * @Version 1.0
 */


public class Manacher {

    //暴力破解通过
    public static String longestPalindrome(String s){
        if(s == null || s.length() < 2)
            return s;
        int max = 1; //最长回文子序列长度, 注意一个字母也是回文序列
        int begin = 0;
        //测试任意区间是否为回文序列
        for( int i = 0; i < s.length() ; i ++)
            for( int j = i + 1; j < s.length(); j++){
                if(j - i + 1 > max && validity(s, i, j)){
                    begin = i;
                    max = j - i + 1;
                }
            }
        return s.substring(begin, begin + max);
    }

    private static boolean validity(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;

        }
        return true;
    }




    //最大回文子串：扩展原始串，
    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() *2 + 1];
        int index = 0; //原字符串下标
        for(int i = 0; i < res.length; i++){
            res[i] = ( i & 1) == 0 ? '#':charArr[index ++];  //奇数为#
        }
        return res;
    }

    /**
     *
     * 三种情况：
     * （1） i 在边界外 --》暴力扩
     * （2） i 在边界内
     *      1） i'   在L，R内     Z[k(aba)t F ta b abk]Y    O(1)
     *      2） i'   在L,R外    (ab[cdcba)t t tabc d c]F     O(1)
     *      3） i'   L压线   T[abcbak k kabcba]k
     */
    //借助辅助数组求每个数据的回文半径，分为实轴和虚轴，虚轴就是为了让字符串不管是奇数个还是偶数个都能统一格式
    public static int maxLcpsLength(String str){
        if(str ==null|| str.length() == 0)
            return 0;
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length]; //保存回文半径
        int C = -1;//回文中心
        int R = -1; //回文右边界
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < charArr.length; i++){ //i代表每一个字符求其回文中心
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R-i) : 1;   //这就是边界min(pArr[2 * C - i], R-i)，是否更大需要自己去比较
            //2*C - i 就是i的对称点。当i < R的时候，就是i在回文边界里面就会有一个不用验的区域。
            //R-i右边区域界定，pArr[2 * C - i]对称点的回文半径。不管压不压线，下面继续对比。


            //pArr[i] 至少是1，以i为中心继续扩.  没有回文序列半径就是1，就是他自己
            //           # a # b # c # 1 # 2 # 3 # 4 # 3 # 2 # 1 # a # b #
            //pArr       1 2 1 2 1 2 1 2 1 2 1 2 1 8 1 2 1 2 1 2 1 2 1 2 1
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                //直径小于字符串长度，且有有边界。半径加上当前中心没超边界
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if(i + pArr[i] > R){//更新最大的右边界与之对应的中心
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);   //最大回文长度
            print(pArr);
        }
        return max - 1;
    }

    private static void print(int[] a){
        System.out.print("[");
        for(int i = 0; i < a.length - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[a.length - 1]+"]");
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("1211121"));
    }
}
