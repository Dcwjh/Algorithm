package 剑指offer;

/**
 * @Description 数组中数字出现的次数
 * @Author Jianhai Wang
 * @ClassName Interview56
 * @Date 2020/6/28 15:30
 * @Version 1.0
 */


public class Interview56 {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int k = 0;
        for(int num: nums){
            k ^= num;    //k最后的结果就是那两个不同数的异或结果，0 代表那一位的数字相同，1代表哪一位字数不同。只要找出一个1就可以把他们进行分组了
        }
        int mask = 1;   //用1区分
        while((k&mask) == 0) //找到k中第一个1，用mask代替
            mask <<= 1;

        for(int num:nums){   //进行分组
            if((num & mask) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
