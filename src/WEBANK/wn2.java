package WEBANK;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName wn2
 * @Date 2021/8/27 21:11
 * @Version 1.0
 */


public class wn2 {

    public static int add(int num, int x){
        return num + x;
    }

    public static int sub(int num, int x){
        return num - x;
    }

    public static int div(int num, int x){
        if(num > 0){
            int temp = num / x;
            if(temp * x == num){
                return temp;
            }else {
                return temp + 1;
            }
        } else{
            int temp = num / x;
            if(temp * x == num){
                return temp;
            }else {
                return temp - 1;
            }
        }
    }

    public static int sqart(int num){
        if(num > 0  ){
            int temp = (int)Math.sqrt(num);
            if(Math.pow(temp, 2) == num)
                return temp;
            return temp+ 1;
        }

        else {
            int temp = (int)Math.sqrt(-num);
            if(Math.pow(temp, 2) == -num){
                return -temp;
            }
            return -(temp + 1);
        }
    }

    public static int reverse(int num){
        return -num;
    }

    public static int cal(int num, String s){
        if(s.charAt(0)=='+'){
            return add(num, Integer.parseInt(s.substring(2, s.length())));
        }
        if(s.charAt(0)=='-'){
            return sub(num, Integer.parseInt(s.substring(2, s.length())));
        }
        if(s.charAt(0) == '/'){
            return div(num, Integer.parseInt(s.substring(2, s.length())));
        }

        if(s.charAt(0)=='s'){
            return sqart(num);
        }
        if(s.charAt(0)=='n')
            return reverse(num);
        return 0;
    }
    /*
3
+ 2
n
/ 2
- 5
s

     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if(n == 1) {
            System.out.println(1);
            System.out.println(1);
        }

        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = 1;
        min[0] = 1;
        String[][] str = new String[n][n];
        str[0][0] = "1";
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                str[i][j] = in.nextLine();
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(j == 0 ){
                    int temp1 = cal(max[0], str[i][j]);
                    int temp2 = cal(min[0], str[i][j]);
                    max[j] = Math.max(temp1, temp2);
                    min[j] = Math.min(temp1, temp2);
                } else if(j == i) {
                    int temp1 = cal(max[j - 1], str[i][j]);
                    int temp2 = cal(min[j - 1], str[i][j]);
                    max[j] = Math.max(temp1, temp2);
                    min[j] = Math.min(temp1, temp2);
                }
                else {
                    int temp1 = cal(max[j - 1], str[i - 1][j]);
                    int temp2 = cal(min[j - 1], str[i - 1][j]);
                    int temp3 = cal(max[j - 1], str[i][j]);
                    int temp4 = cal(min[j - 1], str[i][j]);
                    max[j] = Math.max(temp1, temp2);
                    max[j] = Math.max(max[j], temp3);
                    max[j] = Math.max(max[j], temp4);
                    min[j] = Math.min(temp1, temp2);
                    min[j] = Math.min(min[j], temp3);
                    min[j] = Math.min(min[j], temp4);
                }

            }
            System.out.println("第"+ (i+1) +  "行");
            for(int m = 0; m <= i; m++){
                System.out.println("第"+ (m+1) +  "列" + "max:" + max[m]);
                System.out.println("第"+ (m+1) +  "列" + "min:" + min[m]);
            }
        }



        for(int i = 0; i < n; i++){
            System.out.print(max[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(min[i] + " ");
        }


    }
}
