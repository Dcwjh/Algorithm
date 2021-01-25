package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC1
 * @Date 2021/1/21 16:37
 * @Version 1.0
 */


public class NC1 {
    public String solve (String s, String t) {
        // write code here
        char[] m = s.toCharArray();
        char[] n = t.toCharArray();
        int len = m.length < n.length? n.length : m.length;
        char[] temp = new char[len];
        int carry = 0;
        int i = m.length - 1;
        int j = n.length - 1;
        int index = len - 1;
        while(i >= 0 && j >= 0){
            int x = m[i] -'0';
            int y = n[j] - '0';
            if(x + y + carry > 9){
                temp[index] = (char)('0'+((x + y + carry) % 10)) ;
                carry = 1;
            } else{
                temp[index] = (char)('0'+(x + y + carry));
                carry = 0;
            }
            i --;
            j --;
            index --;
        }

        while(i >= 0){
            int x = m[i] -'0';
            if(x + carry > 9){
                temp[index] = (char)('0'+((x + carry) % 10)) ;
                carry = 1;
            } else{
                temp[index] = (char)('0'+(x + carry));
                carry = 0;
            }
            i --;
            index --;
        }

        while(j >= 0) {
            int y = n[j] - '0';
            if( y + carry > 9){
                temp[index] = (char)('0'+(y + carry) % 10);
                carry = 1;
            } else{
                temp[index] = (char)('0'+(y + carry));
                carry = 0;
            }
            j --;
            index --;
        }
        if(carry == 1){
            char[] ans = new char[len + 1];
            ans[0] = 1 + '0';
            for(i = 1; i < ans.length;i ++){
                ans[i] = temp[i - 1];
            }
            return new String(ans);
        }else{
            return new String(temp);
        }
    }
    public String solve1 (String s, String t) {
        int si = s.length() - 1,
            ti = t.length() - 1,
            c = 0;
        // 存储倒序结果
        StringBuilder res = new StringBuilder();
        while (si > -1 || ti > -1 || c > 0) {
            int sn = si > -1 ? s.charAt(si--) - '0' : 0,
                tn = ti > -1 ? t.charAt(ti--) - '0' : 0;
            int temp = sn + tn + c;
            c = temp / 10;
            res.append(temp % 10);
        }
        // 反转字符串，得到结果
        return res.reverse().toString();

    }


}
