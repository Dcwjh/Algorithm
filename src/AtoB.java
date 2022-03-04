import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName AtoB
 * @Date 2021/9/10 19:11
 * @Version 1.0
 */


//把a变成b的最小操作次数
//  1 2 3 4 5 6 7 = b - a

public class AtoB {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(fun(b - a));
        }
    }

    private static int fun(int num) {
        if (num == 0) return 0;

        int k = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num);
        while (true) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            list.clear();
            for (Integer i : temp) {
                list.add(i + k);
                list.add(i - k);
                if (i + k == 0 || i - k == 0)
                    return k;
            }
            k++;
        }
    }
}
