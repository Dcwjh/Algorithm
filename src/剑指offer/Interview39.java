package 剑指offer;

/**
 * @Description 数组中出现次数超过一半的数
 * @Address 牛客网：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&&tqId=11181&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @Author Jianhai Wang
 * @ClassName Interview39
 * @Date 2020/6/24 9:41
 * @Version 1.0
 */


public class Interview39 {
    //思想：基于统计规律
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[index] == array[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                index = i;
                count = 1;
            }
        }
        //重新确认
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index]) {
                count++;
            }
        }
        if (count > array.length / 2)
            return array[index];
        return 0;
    }

    //基于快速排序的特点
    //快速排序
    //快速排序

    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array == null || array.length == 0)
            return 0;
        int len = array.length;
        int middle = len >> 1;
        int index=0;
        int left = 0;
        int right = len - 1;
        while(index!=middle){
            index = parttion(array,  left, right);
            if(index < middle){
                left = index + 1;
            } else
                right = index - 1;
        }
        int number = 0;
        for(int i = 0; i < array.length;i++ )
            if(array[index] == array[i])
                number++;
        if(number > middle)
            return array[index];
        else
            return 0;
    }

    private static int parttion(int[] array, int left, int right){
        int index = left;
        while(left < right){
            if(array[left] > array[index] && array[right] < array[index]){
                swap(array, left++, right--);
            }
            if(array[left] <= array[index])
                left ++;
            if(array[right] >= array[index])
                right --;
        }
        swap(array,left,index);
        return left;
    }
    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //其他方法：排序找中文数

    public static void main(String[] args) {

    }

}
