package mi;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L2
 * @Date 2021/9/8 19:39
 * @Version 1.0
 */

/*
给你一个仅有红，白，蓝三种颜色组成的10个条块序列，现需要你将这些条块按照红，白，蓝的顺序排好，可用1代表红色，2代表白色，3代表蓝色，要求时间复杂度为O(n)。例如，给定彩色条块序列为：

｛蓝、白、红、白、蓝、红、白、白、红、蓝｝

则要求排列结果为：

｛红、红、红、白、白、白、白、蓝、蓝、蓝｝


｛蓝、白、红、白、蓝、红、白、白、红、蓝｝:3 2 1 2 3 1 2 2 1 3
｛红、红、红、白、白、白、白、蓝、蓝、蓝｝:1 1 1 2 2 2 2 3 3 3
 */

public class L2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] str = string.split(" ");
        int[] nums = new int[str.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(str[i]);
        }

        int[] counts = new int[4];
        for(int i = 0; i < nums.length; i++){
            counts[nums[i]]++;
        }

        for(int i = 1; i < counts.length; i++){
            for(int j = 0; j < counts[i]; j++){
                System.out.print(i + " ");
            }
        }

//        Arrays.fill(nums, 1);
//        Arrays.fill(nums, counts[1], counts[2] + counts[1] + 1, 2);
//        Arrays.fill(nums,counts[2] + counts[1], nums.length, 3);

//        //荷兰国企问题
//        int start = -1; //排好序
//        int cur = 0; //游标
//        int end = nums.length;
//        while(cur < end){
//            if(nums[cur] == 1){
//                start ++;
//                cur++;
//            }else if(nums[cur] == 2){
//                cur++;
//            } else if(nums[cur] == 3){
//                end--;
//                int temp = nums[cur];
//                nums[cur] = nums[end];
//                nums[end] = temp;
//            }
//        }

    }
}
//3 2 1 1 2 3 2 2 1 2