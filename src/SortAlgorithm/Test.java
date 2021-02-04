package SortAlgorithm;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName Test
 * @Date 2021/1/25 15:54
 * @Version 1.0
 */


public class Test {
    public void heapSort(int[] nums){
        if(nums == null || nums.length < 2) return;
        for(int i = 0; i < nums.length; i++){
            heapInsert(nums, i);
        }

        int size = nums.length - 1;
        while(size >= 0){
            swap(nums, 0, --size);
            heapify(nums, size);
        }
    }

    private void heapInsert(int[] nums, int index){
        while(nums[index] > nums[(index - 1)/2]){ // index = 0时， (index - 1) / 2 = 0,不用考虑终止条件
            swap(nums, index, (index- 1) / 2); //和下面互为逆运算
            index = (index-1)/2;
        }
    }

    private void heapify(int[] nums, int size){
        int index = 0;
        int left = index * 2 + 1; //左子树
        while(left <  size){
            int larger = left + 1 <= size && nums[left + 1] > nums[left]? left + 1: left; //可能时left调整，也可能去了left + 1调整
            larger = nums[index] < nums[larger]? larger : index;
            if(index == larger){
                break;
            }
            swap(nums, index, larger);
            index = larger;  //哪里变化就去哪里
            left = index * 2 + 1;
        }
    }

    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }



}
