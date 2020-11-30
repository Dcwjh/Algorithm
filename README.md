# Algorithm
   记录Leetcode，剑值Offer等算法题目(每天五道题)
# 目录
  - [LeetCode](#LeetCode)
  - [剑指Offer](#剑指offer)
  - [链表](#链表)
  - [动态规划](#动态规划)
  - [贪心算法](#贪心算法)
  - [数组](#数组)
  - [排序](#排序)
  - [对数器](#对数器)
  - [字符串](#字符串)





## LeetCode

  - [55.跳跃游戏I](./src/Array/CanJump_55.java)
  - [139.拆分数组](./src/DP/WordsBread_139.java)
  - [滑动窗口2](./src/Leetcode/MaxSubMin.java)
  - [141.环形链表](./src/Leetcode/LeetCode_141.java)
  - [155.最小栈](./src/Leetcode/LeetCode_155.java)
  - [167. 两数之和 II - 输入有序数组](./src/Leetcode/LeetCode_167.java)
  - [168](./src/Leetcode/LeetCode_168.java)
  - [198.打家劫舍](./src/DP/Rob_198.java)
  - [213.打家劫舍II](./src/DP/Rob2_213.java)
  - [239.滑动窗口1](./src/Leetcode/LeetCode239.java)
  - [303.区间和检索-数组不可变](./src/Leetcode/NumArray_303.java)
  - [454.四数之和](./src/Leetcode/FourSumCount_454.java)
  - [746.使用最小花费爬楼梯](./src/Leetcode/MinCostClimbingStairs_746.java)
  - [767.重构字符串](./src/Leetcode/ReorganizeString_767.java)
  
## 剑指offer

  - [最长回文子序列](./src/Leetcode/Mancher.java)
  - [数组中出现次数超过一数的数](./src/剑指offer/Interview39.java)
  - [最小K个数](./src/剑指offer/Interview40.java)
  - [数据流中的中位数](./src/剑指offer/Interview41.java)
  - [连续数组中的最大和](./src/剑指offer/Interview42.java)
  - [1到n中出现1的次数](./src/剑指offer/Interview43.java)
  - [数组中的逆序数对](./src/剑指offer/Interview51.java)
  - [两个链表的公共节点](./src/剑指offer/Interview52.java)
  - [在排序数组中查找数字](./src/剑指offer/Interview53.java)
  - [找出0到n-1却是的数字](./src/剑指offer/Interview53_2.java)
  - [数组中数值和下表相等的元素](./src/剑指offer/Interview53_3.java)
  - [二叉搜索树的第K大节点（树的中序遍历）](./src/剑指offer/Interview54.java)
  - [判断是否是平衡二叉树](./src/剑指offer/Interview55.java)
  - [数组中数字出现的次数](./src/剑指offer/Interview56.java)
  - [数组中唯一出现一次的数字](./src/剑指offer/Interview56_2.java)
  - [和为s的数字](./src/剑指offer/Interview57.java)
  - [和为s的连续正数序列](./src/剑指offer/Interview57_2.java)
  - [反转字符串](./src/剑指offer/Interview58.java)
  - [左旋转字符串](./src/剑指offer/Interview58_2.java)
  - [滑动窗口的最大值](./src/剑指offer/Interview59.java)
  - [队列最大值](./src/剑指offer/Interview59_2.java)
  - [n个骰子的点数](./src/剑指offer/Interview60.java)
  - [扑克牌中的顺子](./src/剑指offer/Interview61.java)
  - [圆圈中最后剩下的数字](./src/剑指offer/Interview62.java)
  - [股票的最大利润](./src/剑指offer/Interview63.java)
  - [求1+2+…+n](./src/剑指offer/Interview64.java)
  - [不用加减乘除做加法](./src/剑指offer/Interview65.java)
  - [构建乘积数组](./src/剑指offer/Interview66.java)
 
  
  
  
  

## 链表
  - [两个单链表相交问题:](./src/LinkList/CircleLinkNode.java) [详情参考博客](https://blog.csdn.net/Dcwjh/article/details/102649895)

## 动态规划
    动态规划思想：
    动态规划的每个阶段可以从之前的某个阶段的“某个”或“某些”转态得到，得到的这样状态即为“状态转移”
  - [三个经典背包问题](./src/DP/CB.java)
  - [带权活动选择问题](./src/DP/ActivityChoose.java)
  - [数组添加乘号使其值最大](./src/DP/InsertMultiplication.java) ([递归形式的解](./src/DP/InsertMulRecur.java))
  - [划分数组，最小化子序列最大值之和](./src/DP/getMinMaxSubsequence.java)
  - [最长回文子序列](./src/DP/LongestPalindrome.java)
  - [树着色问题](./src/DP/TreeColor.java)
  - [NLP最大化所有词的质量和](./src/DP/QualityWords.java)
  - [拆分数组I](./src/DP/WordsBread_139.java)
  - [拆分数组II](./src/DP/WordsBreak_140.java)
  - [跳跃游戏I](./src/Array/CanJump_55.java)
  - [198.打家劫舍](./src/DP/Rob_198.java)
  - [213.打家劫舍II](./src/DP/Rob2_213.java)
  - [746.使用最小花费爬楼梯](./src/Leetcode/MinCostClimbingStairs_746.java)
  
## 贪心算法
    总是做出局部最优的选择，寄希望这样的选择能选出全局最优解
    首先考虑用动态规划方法解决这个问题，然后证明一直做出贪心选择就可以得到最优解，从而得到一个贪心算法。
    贪心算法求的不一定是最优解，但肯定是一个比较接近最优解的一个解。
  - [跳跃游戏I](./src/Array/CanJump_55.java)
  - [买卖股票问题](./src/Array/MaxProfit_122.java)
  - [背包问题（可以拆分）](./src/GreedyAlgorithm/KnapsnackPart.java)
  - [背包问题（不可以拆分）](./src/GreedyAlgorithm/Knapsnack.java)
  - [产品生产使成本最小](./src/GreedyAlgorithm/MinCost.java)
  - [建造最小基站](./src/GreedyAlgorithm/BaseStation.java)


## 数组
  - [消失的数组范围](./src/Array/MissingRanges.java)
  - [荷兰国旗问题](./src/Array/NetherLandFlags.java)
  - [二位数值“之”型打印](./src/Array/PrintMatric_ZHI.java)
  - [跳跃游戏I](./src/Array/CanJump_55.java)
  
## 排序
  - [经典快速排序](./src/SortAlgorithm/QuickSort.java)
  - [基于荷兰国旗的快速排序](./src/SortAlgorithm/NewQuickSort.java)
  - [选择排序](./src/SortAlgorithm/SelectSort.java)
  - [归并排序](./src/SortAlgorithm/MergeSort.java)
  - [插入排序](./src/SortAlgorithm/InsertSort.java)
  - [冒泡排序](./src/SortAlgorithm/BubbleSort.java)
  - [堆排序](./src/SortAlgorithm/HeapSort.java)
  - [归并排序应用：小和问题](./src/SortAlgorithm/MinSum.java): 利用右子数组的有序性，减少比较次数
  - [归并排序应用：逆数对问题](./src/SortAlgorithm/NumberOfInverse.java)：利用左子数组的有序性，减少比较次数
  
  
## 对数器
  - [判断数组排序](./src/Test/ArraysJudges.java)

## 字符串
  - [KMP](./src/StringAlgorithm/KMP.java)
  - [KMP](./src/Leetcode/KMP.java)
  - [Mancher:最大回文子序列](./src/StringAlgorithm/Manacher.java)
  
## Top-k问题
  - [BFPRT](./src/Leetcode/BFPRT.java)
  - [解决方法](./src/Leetcode/topk.md)

## 专题

#### 左神
1. [字符串处理（KMP,马拉车算法 ）](./src/StringAlgorithm/Manacher.java)
2. 滑动窗口
3. 单调栈的应用
- [求最大子矩阵的大小]()

#### 滑动串口


  


