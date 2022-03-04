# 模板
- 先从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
- 如果目标元素大于中间元素，那么数组中小于中间元素的值都可以排除（由于数组有序，那么相当于是可以排除数组左侧的所有值），解空间可以收缩为 [mid+1, r]。
- 如果目标元素小于中间元素，那么数组中大于中间元素的值都可以排除（由于数组有序，那么相当于是可以排除数组右侧的所有值），解空间可以收缩为 [l, mid - 1]。
- 如果在某一步骤解空间为空，则代表找不到。


## 查找一个数
```java
public int binarySearch(int[] nums, int target) {
    // 左右都闭合的区间 [l, r]
    int left = 0;
    int right = nums.length - 1;

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid;
        if (nums[mid] < target)
                  // 解空间变为 [mid+1, right]
            left = mid + 1;
        if (nums[mid] > target)
            // 解空间变为 [left, mid - 1]
            right = mid - 1;
    }
    return -1;
}
```

##  能力检测二分

```java
private boolean possible(mid){
    pass
}
public int funcc(int[] nums, int h) {
      Arrays.sort(piles);
      int l = 0;
      int r = nums.length - 1;
      while(l <= r){
          int mid = l + (r - l) / 2;
          if(possible(mid, h)){
              r = mid - 1;
          } else {
              l = mid + 1;
          }     
      }
      return l;
  }
```


一个问题能否用二分解决的关键在于检测一个值的时候是否可以排除解空间中的一半元素。比如我前面反复提到的如果 x 不行，那么解空间中所有小于等于 x 的值都不行。


# 题目
- [875. 爱吃香蕉的珂珂](L875_MinEatingSpeed.java)
- [Leecode 719 , BinarySearch 817. Kth Pair Distance](https://binarysearch.com/problems/Kth-Pair-Distance): [解法](B817_Solve.java)

