package 美团;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln1
 * @Date 2021/9/11 16:02
 * @Version 1.0
 */


public class ln1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        BigInteger big = new BigInteger(s);

        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') continue;
            for(int j = i + 2; j <= s. length(); j++ ){
                String temp = s.substring(i,j);
                BigInteger t = new BigInteger(temp);
                if(t.remainder(BigInteger.valueOf(22)).equals("0")) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
