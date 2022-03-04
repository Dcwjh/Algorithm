package 华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L915Ln1
 * @Date 2021/9/15 19:05
 * @Version 1.0
 */


public class L915Ln1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String[] strings1 = s1.split(" ");
        String[] strings2 = s2.split(" ");
        int[] workstations = new int[strings1.length];
        int[] sterilizers = new int[strings2.length];
        for(int i = 0; i < workstations.length; i ++){
            workstations[i] = Integer.parseInt(strings1[i]);
        }
        for(int i = 0; i < sterilizers.length; i++){
            sterilizers[i] = Integer.parseInt(strings2[i]);
        }

        System.out.println(fun(workstations, sterilizers));
    }

    private static int fun(int[] works, int[] sters){
        if(works == null || sters == null || works.length == 0 || sters.length == 0){
            return 0;
        }

        Arrays.sort(sters);
        Arrays.sort(works);
        int ans = -1;
        for(int work : works){
            int index = Arrays.binarySearch(sters, work);
            if(index < 0){
                index = -(index + 1);
            }
            int d = index - 1 >= 0? work-sters[index - 1] : Integer.MAX_VALUE;
            int d2 = index < sters.length ? sters[index] - work: Integer.MAX_VALUE;
            ans = Math.max(ans, Math.min(d, d2));
        }
        return ans;
    }
}
