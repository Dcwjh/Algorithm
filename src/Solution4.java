import java.math.BigInteger;
import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Solution4
 * @Date 2021/7/25 19:32
 * @Version 1.0
 */


public class Solution4 {
    private static BigInteger fun(int[] nums){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            if(nums[i] != 0){
                for(int j = 0; j < nums[i]; j++){
                    list.add(i);
                }
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 0; i < list.size(); i ++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        int len = list.size();
        int i = 0;
        boolean flag  = true;
        while(i < len){
             if(flag) {
                n1.append(list.get(i++));
                if (i < list.size()) {
                    n2.append(list.get(i++));
                }
                flag = false;
            } else{
                n2.append(list.get(i++));
                if (i < list.size()) {
                    n1.append(list.get(i++));
                }
                flag = true;
            }
        }
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        BigInteger bi1 = new BigInteger(n1.toString());
        BigInteger bi2 = new BigInteger((n2.toString()));
        return bi2.multiply(bi1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for(int i = 0; i < 10; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.toString(nums);
        System.out.println(fun(nums));
    }
}
