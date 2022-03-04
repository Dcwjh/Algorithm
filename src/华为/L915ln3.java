package 华为;

import java.util.*;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L915ln3
 * @Date 2021/9/15 19:27
 * @Version 1.0
 */


public class L915ln3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(in.hasNextLine()){
            input.add(in.nextLine());
        }
        Map<Integer, String> map = new HashMap<>();
        int[][] nums = new int[input.size()][2];
        int n = nums.length;
        for(int i = 0; i < input.size(); i++){
            String[] temp = input.get(i).split(",");
            int a = Integer.parseInt(temp[1]);
            int b = Integer.parseInt(temp[2]);
            //重复选择第一个乘客
            if(!map.containsKey(a*n + b)){
                nums[i][0] = a;
                nums[i][1] = b;
                map.put(a*n + b, temp[0]);
            }
        }
        int real = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i][0] != 0)
                real++;
        }
        int[][] travals = new int[real][2];
        for(int i = 0; i < real; i++){
            travals[i][0] = nums[i][0];
            travals[i][1] = nums[i][1];
        }


        ArrayList<Integer> list = fun(travals, n);

        List<String> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            res.add(map.get(list.get(i)));
        }

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < res.size(); i++){
            if(i != res.size() - 1){
                System.out.print(res.get(i) + " ");
            }else{
                System.out.println(res.get(i));
            }
        }
        System.out.println();
    }

    private static ArrayList<Integer> fun(int[][] nums, int n){
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
//        for(int i = 0; i < nums.length; i++){
//            for(int j = 0; j < nums[0].length; j ++){
//                System.out.print(nums[i][j] + " ");
//            }
//            System.out.println();
//        }
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(res.size() == 0){
                res.add(nums[i][0] * n + nums[i][1]);
                ans.add(nums[i]);
            } else{
                int[] temp = ans.get(ans.size() - 1);
                if(temp[1] <= nums[i][0]){
                    res.add(nums[i][0] * n + nums[i][1]);
                    ans.add(nums[i]);
                }
            }
        }

        return res;
    }
}
/*

a, 1 5
b, 1 3
c, 3 5
 */