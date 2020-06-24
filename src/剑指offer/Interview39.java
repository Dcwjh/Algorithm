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

}
