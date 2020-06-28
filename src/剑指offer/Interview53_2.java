package 剑指offer;

/**
 * @Description 找出0到n-1却是的数字
 * Address:
 * @Author Jianhai Wang
 * @ClassName Interview53_2
 * @Date 2020/6/28 9:40
 * @Version 1.0
 */


public class Interview53_2 {
    //参考： ../Search/二分查找.md
    //模板一：while(left <= right )
    public int missingNumber1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right ) {
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == middle){
                left = middle + 1;
            } else{
                if((middle > 0 && nums[middle - 1] == (middle - 1)) || middle == 0){
                    return  middle;
                } else
                    right = middle - 1;
            }
        }
        return nums.length;
    }


    //模板二： while(left < right )
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right ) {   //为啥非要小于等于，小于不行
            //查看参考链接：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
            int middle = left + ((right - left) >> 1); //向下取整
            if(nums[middle] == middle){
                left = middle + 1;
            } else{
                if((middle > 0 && nums[middle - 1] == (middle - 1)) || middle == 0){
                    return  middle;
                } else
                    right = middle;
            }
        }
        return nums.length;
    }


}
