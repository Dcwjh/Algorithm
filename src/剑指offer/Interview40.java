package 剑指offer;

import java.util.ArrayList;

/**
 * @Description 最小K个数
 * @Address
 * @Author Jianhai Wang
 * @ClassName Interview40
 * @Date 2020/6/24 14:43
 * @Version 1.0
 */


public class Interview40 {
    //快速排序思想  复杂度：O(n)
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length ==0 )
            return list;
        if(k == input.length){
            for(int i = 0; i < input.length; i++){
                list.add(input[i]);
            }
            return list;
        }
        if(k > input.length|| k == 0)
            return list;
        int left = 0;
        int right = input.length - 1;
        int index = partition(input, left, right);;
        while(index != k - 1){

            if(index > k - 1){
                right = index - 1;
            } else{
                left = index + 1;
            }
            index = partition(input, left, right);
        }
        for(int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }
    private static int partition(int[] array, int left, int right){
        int index = left;
        while(left < right){  //为什么不能写==
            if(array[index] < array[left] && array[index] > array[right]){
                swap(array, left++, right--);
            }
            if(array[left] <= array[index])
                left ++;
            if(array[index] <= array[right])
                right--;
        }
        swap(array,index, right);
        return right;
    }

    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //方法二： 要求不能改变数组，采用红黑树.可以适用于海量数据（大根堆）
    /**
     * 创建k个大小的数组容器来存储这k个元素。
     * 一开始：不断像容器中插入元素。
     * 容器已满：1.在容器中找到最大数（大根堆，红黑树）
     *          2. 删除最大数
     *          3. 插入新数值
     */
}
