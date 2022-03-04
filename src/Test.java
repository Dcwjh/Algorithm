/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test
 * @Date 2021/8/1 11:28
 * @Version 1.0
 */


public class Test {

    private static int fun(String s){
        int n = s.length();
        char[] temp = s.toCharArray();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                dp[i] = 1;
                continue;
            }
            if(temp[i] == temp[i - 1]){
                dp[i] = dp[i - 1];
            } else{
                //找到与他相同颜色的那一个地址
                int j = i - 1;
                while(j >= 0 && temp[j] != temp[i]){
                    j--;
                }
                if(j >= 0)
                    dp[i] = dp[j] + 1;
                else
                    dp[i] = 2;
            }
        }
        return dp[n - 1];


    }

    public static void main(String[] args) {
        System.out.println(fun("BBRBRBBR"));
        System.out.println(fun("RRRR"));

    }
}
