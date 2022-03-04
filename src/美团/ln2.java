package 美团;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName ln2
 * @Date 2021/9/11 16:20
 * @Version 1.0
 */


public class ln2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 0; i < m; i++ ){
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == b) continue;
            nums[a] ++;
            nums[b] ++;

        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);

        for(int i = 1; i < n + 1; i++){
            list.add(nums[i]);
        }

        int[] map = new int[n + 1];
        for(int i = 1; i < n + 1; i++){
            map[i] = i;
        }
        for(int i = 0; i < q; i++ ){
            int a = in.nextInt();
            int b = in.nextInt();
            int temp = map[a];
            map[a] = map[b];
            map[b] = temp;
        }
        for(int i = 1; i < n + 1; i ++){
            System.out.print(list.get(map[i]) + " ");
        }
        System.out.println();
    }
}
