import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test3
 * @Date 2021/8/1 16:05
 * @Version 1.0
 */


public class Test3 {



    static int[] fun(int[] nums) {
        //记录0的位置
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (map.containsKey(nums[i])) {
                    int pre = map.get(nums[i]);

                    if (list.size() == 0 || list.getLast() < pre) {
                        return new int[0];
                    }
                    int temp = -1;
                    Iterator<Integer> it = list.iterator();
                    while ((temp = it.next()) <= pre) ;
                    it.remove();
                    res[temp] = nums[i];
                }
                map.put(nums[i], i);
            } else {
                list.add(i);
            }
        }
        for (int i : list) {
            res[i] = 2;
        }
        return res;
    }


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String arg = input.substring(1, input.length() - 1);
        String[] numstr = arg.split(",");
        int[] nums = new int[numstr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numstr[i]);
            System.out.println(nums[i]);
        }


        System.out.print("[");
        int[] res = fun(nums);
        if (res.length != 0) {
            for (int i = 0; i < res.length; i++) {
                if (i != res.length - 1)
                    System.out.print(res[i] + ",");
                else System.out.print(res[i]);
            }
        }
        System.out.print("]");
    }
}
