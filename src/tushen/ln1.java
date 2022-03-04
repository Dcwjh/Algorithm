package tushen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln1
 * @Date 2021/9/18 18:38
 * @Version 1.0
 */


public class ln1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String strings = in.nextLine();
        char[] nums = strings.toCharArray();
        char[][] ch = new char[2 * n + 1][n + 1];
        for(int i = 0; i < 2 * n + 1; i++){
            Arrays.fill(ch[i],'.');
        }
        int count = 0;
        int row = 0;
        int col = 1;
        int temp = '0';
        for(int i = 0; i < n; i++) {
            if (nums[i] == temp) {
                if (nums[i] == '+') {
                    count++;
                    ch[n - count][col] = '/';


                } else if (nums[i] == '-') {
                    count--;
                    ch[n - count][col] = '\\';


                } else {
                    ch[n - count][col] = '-';
                }
            } else {
                temp = nums[i];
                if (nums[i] == '+') {
                    ch[n - count][col] = '/';
                } else if (nums[i] == '-') {
                    ch[n - count][col] = '\\';
                } else {
                    ch[n - count][col] = '-';
                }
            }
            col++;
        }

        int statrt = -1;
        int end = -1;
        for(int i = 0; i < ch.length;i++){
            boolean flag = true;
            for(int j = 0; j < ch[0].length; j++) {
                if (ch[i][j] != '.' && statrt == -1) {
                    statrt = i;

                }
                if(ch[i][j] != '.') flag = false;
            }
            if(statrt != -1 && flag){
                end = i;
                break;
            }
        }

        for(int i = statrt ; i < end ; i++){
            for(int j = 1; j < n + 1; j++){
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
    }
}
