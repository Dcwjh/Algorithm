package Array;

import java.util.Arrays;

import static utils.Print.printArray;
import static utils.Swap.swap;

/**
 * @Description 荷兰国旗问题：具体参考https://www.jianshu.com/p/356604b8903f
 * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在，要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，
 * 等于K的元素放到数组的中间，最终返回一个整数数组，其中只有两个值，分别是等于K的数组部分的左右两个下标值。
 * @Author Jianhai Wang
 * @ClassName NetherLandFlags
 * @Date 2019/11/5 22:29
 * @Version 1.0
 */


public class NetherLandFlags{
    public static int[] partition(int [] nums, int left, int right, int num){
        int less = left - 1; //小于num 0~less
        int more = right + 1;  //大于num  more ~ nums.length - 1
        int cur = left;
        while(cur < more){
            if(nums[cur] < num)
                swap(nums, ++less, cur++);
            else if(nums[cur] > num)
                swap(nums, --more, cur); // 大于nums的数放在后面，换回来的元素大小不确定
            else
                cur++;
        }
        return new int[]{less + 1, more - 1};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3,56,3,12,3,5,6,7,324,30,30,1,2,3,4,45,93};
        printArray(arr1);
//        System.out.println(Arrays.toString(arr1));
        int[] p = partition(arr1, 0, arr1.length - 1, 30);
        printArray(arr1);
//        System.out.println(Arrays.toString(arr1));
        System.out.println(p[0] + " " + p[1]);
    }
}
