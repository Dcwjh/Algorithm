package NIUKE;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName NC105
 * @Date 1/12/2021 11:26 AM
 * @Version 1.0
 */


public class NC105 {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int start = 0;
        int end = n - 1;
        int mid = 0;
        while(start < end){
            mid = start + (end - start) / 2;
            if(a[mid] < v){
                start = mid + 1;
            } else if(a[mid] > v){
                end = mid;
            } else{
                break;
            }
        }
        while(mid >=0 && a[mid] >= v) mid--;

        return mid+2>0? mid+2 : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new NC105().upper_bound_(10, 2, new int[]{1, 1, 2, 3, 7, 7, 7, 9, 9, 10}));
    }
}
