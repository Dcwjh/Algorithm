package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ReorganizeString_767
 * @Date 11/30/2020 8:52 AM
 * @Version 1.0
 */


public class L767_ReorganizeString {

    //自己解决错误版本
    public String reorganizeString(String S) {
        if(S == null && S.length() < 2)
            return S;
        char[] str = S.toCharArray();
        int p = 0;
        while(p < str.length - 1){
            int i = p + 1;
            if(str[p] != str[i]){
                p ++;
                continue;
            } else if(i == str.length - 1){
                return "";
            }else{
                for(int j = i + 1; j < str.length; j++){
                    if(str[i] != str[j]){
                        char temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                        break;
                    }
                    if(j == str.length - 1)
                        return "";
                }
            }
        }
        return String.valueOf(str);
    }


    //统计字符频率，进行重排。
    public String reorganizeString1(String S) {

        int[] chs = new int[26];

        //记录字符出现的最长长度
        int maxLen = 0;
        for(char ch : S.toCharArray()){
            maxLen = Math.max(maxLen, ++chs[ch - 'a']);
        }

        int len = S.length();
        /*
            如果长度为奇数个：那么极端情况是 aaa bc，能够组成 abaca，即最长字符的长度不能超过 len / 2 向上取整，即 不能超过 (len + 1) / 2
            如果长度为偶数个，那么极端情况是 aaa bcd，能够组成 abacad，即最长字符的长度不能超过 len / 2，即 6 / 2

            综上
            总长度为 奇数，最长字符长度不能超过 长度的一半（向上取整）
            总长度为 偶数，最长字符串长度不能超过 长度的一半

            偶数：
            len / 2 == (len + 1) / 2
            如果 len = 8，那么结果为 4
            len / 2 + 1
            如果 len = 8，那么结果为 5

            奇数：
            len / 2
            如果 len == 7，那么结果为 3
            len / 2 + 1 == (len + 1) / 2 （向上取整）
            如果 len == 7，那么结果为 4

            为了方便，我们可以写成 (len + 1) / 2
        */
        if(maxLen > (len + 1) / 2){
            return "";
        }

        /*
        aaaa bbb
        0 1 2 3 4 5 6
          a b a b a

        索引位置从 0 开始算

        aaa bb ccc
        0 1 2 3 4 5 6 7
        b a c a c a c b

        aaaa b ccc
        0 1 2 3 4 5 6 7
        b a c a c a c a

        aaaa bbbb
        0 1 2 3 4 5 6 7
        b a b a b a b a

        对于总长度为奇数，如果 字符 长度为 (len + 1) / 2，即向上取整，那么这个字符首先需要放在首尾，即偶数位（因为需要夹紧其他字符，比如 ababa）
        对于总长度为偶数，没有什么特别要求，因为无论怎么整，字符的长度最长只能为总长度的一半，那么只要间隔存放，奇数位偶数位没差别（比如 abababab）

        综上，我们只需要处理 总长度奇数 的情况即可，
        这里我们先写出放在奇数位的条件，chs[i] < (len + 1) / 2
        但这里写的话会有问题，因为如果总长度是 偶数的话， 如果存在这么一个情况 aaaabbbb，
        那么 每个字符出现的次数都是 4，占了总长度一半，如果写成 chs[i] < (len + 1) / 2，（我们上面说了 对于偶数长度，len / 2 == (len + 1) / 2），
        即 只有在 chs[i] < len / 2 的情况才能放在奇数
        那么对于 这个 a 来说，由于 chs[i] < len / 2 不成立，因此不会放在奇数，都放在偶数位，然后下一个 b ,同样也不会放在奇数，导致奇数位不会被放置，结果错误

        因此，我们需要修改成既能限制 奇数长度的放置，又能不影响 偶数长度的放置
        因为对于 奇数长度来说，len / 2 + 1 == (len + 1) / 2，而对于偶数长度来说是不一样的，因此我们采用 len / 2 + 1 这个写法，
        这样的话，对于 a 来说，就是 4 < 5 了，a 放置完奇数位，然后奇数位越界，因此 b 会 放置在偶数位，那么结果就是 abababab
        */
        char[] res = new char[len];
        int even = 0;
        int odd = 1; //奇数，位置上是偶数。
        for(int i = 0; i < 26; i++){
            //先填充第二个字符（先填充偶数），考虑到特殊情况个数必须要小于len/2 + 1,
            //元素个数不为 0 并且 长度 小于 len / 2 + 1，并且奇数位下标还没越界，那么将元素放在奇数位
            //为什么会有这个条件？？？防止出现这种情况，总个数为奇数，例如aaaa bbb, 最长的那个字符必须放在第一个字符上
            while(chs[i] > 0 && chs[i] < len/2 + 1 && odd < len){
                res[odd] = (char)(i + 'a');
                chs[i]--;
                odd += 2;
            }
            //当 odd 越界了，或者 长度等于 len / 2 + 1，那么就会放在偶数位
            while(chs[i] > 0){
                res[even] = (char)(i + 'a');
                chs[i]--;
                even += 2;
            }
        }
        return new String(res);
    }


    //
    public String reorganizeString2(String s) {
        if(s.length() < 2)
            return s;
        //统计
        int[] count = new int[26];
        char[] str = s.toCharArray();
        int max = 0;
        for(char temp : str){
            count[temp - 'a']++;
            max = Math.max(max,count[temp - 'a']);
        }

        if(max > (s.length() + 1)/2)
            return "";
        //重组
        int even = 0;
        int odd = 1;
        for(int i = 0; i < 26; i++){
            //奇数个 例如aaaa bbb   ==> 7/2 + 1 = 4   4 < 4
            while(count[i] > 0 && count[i] < s.length()/2 + 1 && odd < s.length()){
                str[odd] = (char)(i+'a');
                count[i]--;
                odd += 2;
            }
            while(count[i] > 0 && even < s.length()){  //even < s.length()条件多余
                str[even] = (char)(i + 'a');
                count[i] --;
                even += 2;
            }
        }
        return new String(str);
    }


    public static void main(String[] args) {

    }
}
