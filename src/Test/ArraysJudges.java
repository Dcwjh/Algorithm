package Test;

import SortAlgorithm.NewQuickSort;

import java.util.Arrays;

import static SortAlgorithm.InsertSort.insertSort;

/**
 * @Description 基于对数器的测试：随机生成无数个可能性的数组对算法进行测试
 * @Author Jianhai Wang
 * @ClassName ArraysJudges
 * @Date 2019/11/5 22:56
 * @Version 1.0
 */

//对数器测试
    //测试用的


public class ArraysJudges {
    //提供一个绝对正确的方法
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 产生随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // copy数据
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 判断是否和正确的排序结果相同
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        System.out.println(Arrays.toString(arr));
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
           NewQuickSort.newQuickSort(arr2);
            comparator(arr3);
            if (!isEqual(arr2, arr3)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println("排序前数组：");
        printArray(arr);
        insertSort(arr);
        System.out.println("排序后数组：");
        printArray(arr);

    }
}
