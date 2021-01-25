package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC28
 * @Date 2021/1/21 19:59
 * @Version 1.0
 */


public class NC128 {
    public long maxWater (int[] arr) {
        // write code here
        //解法水平面累加问题
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        long res = 0l;
        while(left <= right){

            if(arr[left] <= rightMax){  //右边墙能堵住水流
                if(arr[left] > leftMax) leftMax = arr[left];//墙不高，溜走了
                else res += leftMax - arr[left];//左墙高，能堵住水流
                left ++;
            } else{ //左边的水流跑不了
                if(arr[right] > rightMax) rightMax = arr[right];
                else res += rightMax - arr[right];
                right--;
            }
        }
        return res;




    }


}
