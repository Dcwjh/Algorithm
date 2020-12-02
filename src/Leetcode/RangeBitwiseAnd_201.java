package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName RangeBitwiseAnd
 * @Date 12/1/2020 11:02 AM
 * @Version 1.0
 */


public class RangeBitwiseAnd_201 {
    //该方法是求m和n的公共部分
    public static int  TwoNumberOfRangeBitwiseAnd(int m, int n) {
        int ans = 0 ;
        int i = 0;
        while((m != 0) && (n != 0)){

            if((m&1) == 1&& (n &1) == 1){
                ans += (1 << i);
            }
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return ans;
    }

    //求最长公共子串，且保留其位置
    public int rangeBitwiseAndBest(int m, int n) {
        int i = 0;
        while(m < n){
            m = m >> 1;
            n = n >> 1;
            i++;
        }
        return m << i;
    }

    //Brian Kernighan 算法: 以后再研究
    public int rangeBitwiseAndBK(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }






    //算法正确，只是超出了时间限制
    public static int rangeBitwiseAnd1(int m, int n) {
        if(m == n)
            return m;
        //统计n的二进制位数
        int count = 0;
        int temp = n;
        while(temp != 0){
            count++;
            temp = temp>>1;
        }
        int[] help = new int[count + 1];
        int num = n - m + 1;
        //只要某位统计出现0，就改为置为-1，不在统计
        for(int i = 1; i <= count; i++){
            for(int j = m; j <= n; j++){
                if(help[i] == -1)
                    break;
                else{
                    if((j>>i & 1) == 1){
                        help[i] ++;
                    }else
                        help[i] = -1;
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= count; i++){
            if(help[i] != -1){
                res += 1<<i;
            }
        }

        return res;
   }


   //简化答案，求最长公共前缀
    //第一步求出第一个开始的前缀，然后求出终结前缀，结束循环
   public static int rangeBitwiseAnd(int m, int n) {
        if(m == n)
            return m;
        int p1 = 0;
        int temp = m;
       while(temp != 0){
           p1++;
           temp = temp>>1;
       }
       int p2 = 0;
       temp = n;
       while(temp != 0){
           p2++;
           temp = temp>>1;
       }
       int[] help = new int[p2 + 1];
       if(p1 != p2) {
           for (int i = p1 + 1; i <= p2; i++) {
               help[i] = -1;
           }
       }
       loop1:for(int i = p1; i > 0; i--){
           for(int j = m; j <= n; j++){//找到最长公共前缀
               int flag = (m >>(i - 1)) & 1;
               if(((j>>(i - 1))&1) != flag){
                   for(int l = i; l > 0; l--)
                       help[l] = -1;
                   break loop1;
               }
               help[i]=flag;

           }

       }
       int res = 0;
       for(int i = 1; i <= p2; i++){
           if(help[i] == 1){
               res += 1<<(i-1);
           }
       }
       return res;
   }




    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(10,11));
    }
}
