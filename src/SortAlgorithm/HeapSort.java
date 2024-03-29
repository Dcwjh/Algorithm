package SortAlgorithm;

import static utils.Swap.swap;

/**
 * @Description 堆排序
 * @Author Jianhai Wang
 * @ClassName HeapSort
 * @Date 2019/11/5 23:31
 * @Version 1.0
 */

//对于一个堆来说，要符合以下两个特点：1. 是一个完全二叉树。2. 所有父节点的值都要大于（或小于）子节点的值

    //第一步：初始建堆：从0开始将元素填充到堆中
    //第二步：取出最大值，放到最后一个位置。
    // 第三步将最后一个位置的前一个位置填充到根节点，跳针堆


public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int size = arr.length;
        //至上而下建立大根堆
        for (int i = 0; i < size; i++) {
            heapInsert(arr, i);
        }

        //取值，重新调整
        while (size > 0) {
            //取出大顶堆顶部他是最大的，交换到最后面，交换大根堆顶部和最后一个
            swap(arr, 0, --size);
            heapify(arr,size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        //建立过程中。index 找到自己的父亲（其父节点以上已经有序），只需要调整节点到自己该到的位置。大根堆，自己比父节点大，调换位置，在找到上一个父节点
        while (arr[index] > arr[(index - 1) / 2]) {  //最后结束肯定是0, arr[0]==arr[0]
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int size) { //调整
        int index = 0; //从顶部开始出发
        //左节点，右节点left + 1
        int left = index * 2 + 1;
        while (left < size) {
            //调整只需要调整一边
            //选取左右子树的最大值
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left; //找出左右子节点中最大值
            //选取的左右子树最大值和父节点进行比较
            largest = arr[largest] > arr[index] ? largest : index; //判断最大值和当前根节点比较。
            //最大还是根节点直接结束
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest; //那里变化了index就在哪一边
            left = index * 2 + 1;
        }
    }

}
