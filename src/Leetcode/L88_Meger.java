package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L88_Meger
 * @Date 12/15/2020 1:59 PM
 * @Version 1.0
 */


public class L88_Meger {
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =  m + n -1;
        while( m > 0 && n > 0){
            if(nums1[m -1] > nums2[n -1]){
                nums1[i --] = nums1[m -1];
                m--;
            } else{
                nums1[i--] = nums2[n -1];
                n--;
            }
        }
        while(m > 0){
            nums1[i --] = nums1[m -1];
            m--;
        }
        while(n > 0){
            nums1[i --] = nums2[n -1];
            n--;
        }

    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
        // 1.当，p1>=0时，nums[p1],nums[p2]对比
        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
        // 循环结束条件：p2<0

        int p1=m-1,p2=n-1,p3=m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6},3);
    }
}
