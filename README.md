# Algorithm
   记录Leetcode，剑值Offer等算法题目(坚持练题)
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
  - [单调栈](#单调栈)
  - [滑动窗口](#滑动窗口)
  - [HASH方法](#HASH)
  - [双指针](#双指针)
  - [题目考频](#题目考频)
  - [并查集](#并查集)





## LeetCode
  - [3.无重复字符的最长子串](./src/Leetcode/L3_LengthOfLongestSubstring.java):滑动窗口，双指针
  - [6. Z 字形变换](./src/Leetcode/L6_Convert.java)
  - [8. 字符串转换整数 (atoi)](./src/Leetcode/L8_MyStrToInt.java)
  - [13. 罗马数字转整数](./src/Leetcode/L13_IntToRoman.java)
  - [15. 三数之和](./src/Leetcode/L15_ThreeSum.java)
  - [17. 电话号码的字母组合](./src/Leetcode/L17_LetterCombinations.java):HashMap
  - [19. 删除链表的倒数第N个节点](./src/Leetcode/L19_RemoveNthFromEnd.java)
  - [22. 括号生成](./src/Leetcode/L22_GenerateParenthesis.java):BFS,DFS
  - [26. 删除排序数组中的重复项](./src/Leetcode/L26_RemoveDuplicates.java)
  - [30. 串联所有单词的子串](./src/Leetcode/L30_FindSubstring.java)
  - [31. 下一个排列](./src/Leetcode/L31_NextPermutation.java): 思路反转
  - [33. 搜索旋转排序数组](./src/Leetcode/L33_Search.java)
  - [34. 在排序数组中查找元素的第一个和最后一个位置](./src/Leetcode/L34_SearchRange.java)
  - [38. 外观数列](./src/Leetcode/L38_CountAndSay.java)
  - [39. 组合总和](./src/Leetcode/L39_CombinationSum.java):回溯算法
  - [46. 全排列](./src/Leetcode/L46_Permute.java):DFS,回溯算法
  - [49.字母异位词分组](./src/Leetcode/L49_GroupAnagrams.java)
  - [50. Pow(x, n)](./src/Leetcode/L50_MyPow.java)
  - [53. 最大子序和](./src/Leetcode/L53_MaxSubArray.java): 滑动窗口，动态规划，分治法
  - [55.跳跃游戏I](./src/Leetcode/L55_CanJump.java)
  - [56. 合并区间](./src/Leetcode/L56_Merge.java)
  - [58. 最后一个单词的长度](./src/Leetcode/L58_LengthOfLastWord.java)
  - [62. 不同路径](./src/Leetcode/L62_UniquePaths.java)
  - [66. 加一](./src/Leetcode/L66_PlusOne.java)
  - [67. 二进制求和](./src/Leetcode/L67_AddBinary.java)
  - [76. 最小覆盖子串](./src/Leetcode/L76_MinWindow.java)
  - [83. 删除排序链表中的重复元素](./src/Leetcode/L83_DeleteDuplicates.java)
  - [100. 相同的树](./src/Leetcode/L100_IsSameTree.java)
  - [101. 对称二叉树](./src/Leetcode/L101_IsSymmetric.java)
  - [104. 二叉树的最大深度](./src/Leetcode/L104_MaxDepth.java)
  - [108.将有序数组转换为二叉搜索树](./src/Leetcode/L108_SortedArrayToBST.java)
  - [118. 杨辉三角](./src/Leetcode/L118_Generate.java)
 
  - [122. 买卖股票的最佳时机 II](./src/Leetcode/L122_MaxProfit.java)
  - [125. 验证回文串](./src/Leetcode/L125_IsPalindrome.java)
  - [135. 分发糖果](./src/Leetcode/L135_Candy.java):思想很好
  - [136. 只出现一次的数字](./src/Leetcode/L136_SingleNumber.java): Hash,位运算
  - [139.拆分数组](./src/Leetcode/L139_WordsBreak.java)
  - [140. 单词拆分 II](./src/Leetcode/L140_WordsBreak.java)
  - [141.环形链表](./src/Leetcode/L141_HasCycle.java)
  - [155.最小栈](./src/Leetcode/L155_MinStack.java)
  
  - [167. 两数之和 II - 输入有序数组](./src/Leetcode/L167_TwoSum.java)
  - [168. Excel表列名称](./src/Leetcode/L168_ConvertToTitle.java)
  - [171. Excel表列序号](./src/Leetcode/L171_TitleToNumber.java)
  - [172. 阶乘后的零](./src/Leetcode/L172_TrailingZeroes.java)
  - [188.n买卖股票的最佳时机 IV](./src/Leetcode/L188_MaxProfit.java)
  - [189. 旋转数组](./src/Leetcode/L189_Rotate.java):旋转常规思路
  - [190. 颠倒二进制位](./src/Leetcode/L190_ReverseBits.java):位运算基础，继续理解
  - [198.打家劫舍](./src/Leetcode/L198_Rob.java)
  - [201. 数字范围按位与](./src/Leetcode/L201_RangeBitwiseAnd.java)
  - [209. 长度最小的子数组](./src/Leetcode/L209_MinSubArrayLen.java):滑动窗口
  - [213.打家劫舍II](./src/Leetcode/L213_Rob2.java)
  - [217. 存在重复元素](./src/Leetcode/L217_ContainsDuplicate.java)
  - [239.滑动窗口1](./src/Leetcode/L239_MaxSlidingWindow.java):滑动窗口
  - [290. 单词规律](./src/Leetcode/L290_WordPattern.java):hash表
  - [303.区间和检索-数组不可变](./src/Leetcode/L303_NumArray.java)
  - [321. 拼接最大数](./src/Leetcode/L321_MaxNumber.java)
  - [322. 零钱兑换](./src/Leetcode/L322_CoinChange.java):动态规划，贪心算法（+剪枝）
  - [387. 字符串中的第一个唯一字符](./src/Leetcode/L387_FirstUniqChar.java): hash，统计
  - [389. 找不同](./src/Leetcode/L389_FindTheDifference.java): 统计，位运算
  - [402.移掉K位数字](./src/Leetcode/L402_RemoveKdigits.java)
  - [454.四数之和](./src/Leetcode/L454_FourSumCount.java)
  - [621. 任务调度器](./src/Leetcode/L621_LeastInterval.java)
  - [659.分割数组为连续子序列](./src/Leetcode/L659_IsPossible.java)
  - [738. 单调递增的数字](./src/Leetcode/L738_MonotoneIncreasingDigits.java)
  - [746.使用最小花费爬楼梯](./src/Leetcode/L746_MinCostClimbingStairs.java)
  - [767.重构字符串](./src/Leetcode/L746_MinCostClimbingStairs.java)
  - [830. 较大分组的位置](./src/Leetcode/L860_LemonadeChange.java):滑动窗口，双指针    
  - [842. 将数组拆分成斐波那契序列](./src/Leetcode/L842_SplitIntoFibonacci.java)
  - [860. 柠檬水找零](./src/Leetcode/L860_LemonadeChange.java)
  - [990. 等式方程的可满足性](./src/Leetcode/L990_EquationsPossible.java):并查集
  - [1025.除数博弈](./src/Leetcode/L1025_DivisorGame.java)
  - [1046. 最后一块石头的重量](./src/Leetcode/L1046_LastStoneWeight.java):优先队列
  - [1202. 交换字符串中的元素](./src/Leetcode/L1202_SmallestStringWithSwaps.java):并查集
  - [面试题 08.01. 三步问题](./src/Leetcode/I0801_WaysToStep.java)
  
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
  
  - [55.跳跃游戏I](./src/Leetcode/L55_CanJump.java)
  - [拆分数组I](./src/Leetcode/L139_WordsBreak.java)
  - [140.拆分数组II](./src/Leetcode/L140_WordsBreak.java)
  - [198.打家劫舍](./src/Leetcode/L198_Rob.java)
  - [213.打家劫舍II](./src/Leetcode/L213_Rob2.java)
  - [746.使用最小花费爬楼梯](./src/Leetcode/L746_MinCostClimbingStairs.java)
  - [剑指offer.42 连续子数组的最大和](./src/剑指offer/Interview42.java)
## 贪心算法
    总是做出局部最优的选择，寄希望这样的选择能选出全局最优解
    首先考虑用动态规划方法解决这个问题，然后证明一直做出贪心选择就可以得到最优解，从而得到一个贪心算法。
    贪心算法求的不一定是最优解，但肯定是一个比较接近最优解的一个解。
  
  - [背包问题（可以拆分）](./src/GreedyAlgorithm/KnapsnackPart.java)
  - [背包问题（不可以拆分）](./src/GreedyAlgorithm/Knapsnack.java)
  - [产品生产使成本最小](./src/GreedyAlgorithm/MinCost.java)
  - [建造最小基站](./src/GreedyAlgorithm/BaseStation.java)
  
  - [55.跳跃游戏I](./src/Leetcode/L55_CanJump.java)
  - [122.买卖股票问题](./src/Leetcode/L122_MaxProfit.java)


## 数组
  - [消失的数组范围](./src/Array/MissingRanges.java)
  - [荷兰国旗问题](./src/Array/NetherLandFlags.java)
  - [二位数值“之”型打印](./src/Array/PrintMatric_ZHI.java)
  - [55. 跳跃游戏I](./src/Leetcode/L55_CanJump.java)
  
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

## 单调栈
- [316. 去除重复字母]()
- [321. 拼接最大数]()
- [402. 移掉 K 位数字]()
- [1081. 不同字符的最小子序列]()

## 滑动窗口
滑动窗口是一种解决问题的思路和方法，通常用来解决一些连续问题。
滑动窗口主要用来处理连续问题。比如题目求解“连续子串 xxxx”，“连续子数组 xxxx”，就应该可以想到滑动窗口。
从类型上说主要有：
- 固定窗口大小
- 窗口大小不固定，求解最大的满足条件的窗口
- 窗口大小不固定，求解最小的满足条件的窗口(Leetcode 209)

后面两种我们统称为可变窗口。当然不管是哪种类型基本的思路都是一样的，不一样的仅仅是代码细节。
#### 固定窗口大小
对于固定窗口，我们只需要固定初始化左右指针 l 和 r，分别表示的窗口的左右顶点，并且保证：
1. l 初始化为 0
2. 初始化 r，使得 r - l + 1 等于窗口大小
3. 同时移动 l 和 r
4. 判断窗口内的连续元素是否满足题目限定的条件
- 4.1 如果满足，再判断是否需要更新最优解，如果需要则更新最优解
- 4.2 如果不满足，则继续。

#### 可变窗口大小
对于可变窗口，我们同样固定初始化左右指针 l 和 r，分别表示的窗口的左右顶点。后面有所不同，我们需要保证：

  1. l 和 r 都初始化为 0
  2. r 指针移动一步
  3. 判断窗口内的连续元素是否满足题目限定的条件
  - 3.1 如果满足，再判断是否需要更新最优解，如果需要则更新最优解。并尝试通过移动 l 指针缩小窗口大小。循环执行 3.1
  - 3.2 如果不满足，则继续。
  
  形象地来看的话，就是 r 指针不停向右移动，l 指针仅仅在窗口满足条件之后才会移动，起到窗口收缩的效果。
 #### 模板代码
 ```java
初始化慢指针 = 0
初始化 ans

for 快指针 in 可迭代集合
   更新窗口内信息
   while 窗口内不符合题意
      扩展或者收缩窗口
      慢指针移动
   更新答案
返回 ans

```

#### 题目列表
 - [3.无重复字符的最长子串](./src/Leetcode/L3_LengthOfLongestSubstring.java)
 - [30. 串联所有单词的子串](./src/Leetcode/L30_FindSubstring.java)
 - [76. 最小覆盖子串](./src/Leetcode/L76_MinWindow.java)
159:会员题目
- [209. 长度最小的子数组](./src/Leetcode/L209_MinSubArrayLen.java):滑动窗口
239
395
424
438
480
567
632
727
904
930
992
995
978
1004

1234
1248
1658



## HASH
 - [1. 两数之和](./src/Leetcode/L1_TwoSum.java)
 
 
## 双指针
- [26. 删除排序数组中的重复项](./src/Leetcode/L26_RemoveDuplicates.java)


## 并查集
### 简介
- [参考leetcode](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/shi-yong-bing-cha-ji-chu-li-bu-xiang-jiao-ji-he-we/)
- [leetcode视屏](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/deng-shi-fang-cheng-de-ke-man-zu-xing-by-leetcode-/)
- [资料参考](https://zhuanlan.zhihu.com/p/93647900)
并查集被很多OIer认为是最简洁而优雅的数据结构之一，主要用于解决一些元素分组的问题。它管理一系列不相交的集合，并支持两种操作：
- 合并（Union）：把两个不相交的集合合并为一个集合。
- 查询（Find）：查询两个元素是否在同一个集合中。

### 用途
- 并查集用于判断一对元素是否相连，它们的关系是动态添加的，这类问题叫做动态连通性问题；
- 底层数据结果是数组或者哈希表，用于表示节点指向的父节点，初始化时指向自己；
- 合并就是把一个集合的根节点指向另一个集合的根结点，只要根节点一样，就表示在同一个集合里
- 这种表示不相交集合的方法称之为代表元法，以每个节点的根节点作为一个集合的代表元

### 并查集的应用
- 最小生成树：Kruskal算法

### 并查集优化：路径压缩和按秩合并
- 路径压缩：是指在查询过程中，更改节点的指向，使得树的高度更低
- 一般而言， 有隔代压缩和完全压缩两种策略
- 隔代压缩只需要在源代码的基础上加上一行代码：`parent[x] = parent[parent[x]];
- 完全压缩：需要借助递归完成代码编写
- 按秩压缩：是指在合并的过程中，使得高度更低的树的根节点指向高度更高的根节点，以避免合并以后的树高度增加。

### 并查集题目参考
- 第一部分：基础且常见的问题
547
990
200
684
1319
128
- [1202. 交换字符串中的元素](./src/Leetcode/L1202_SmallestStringWithSwaps.java):并查集
- 第二部分：带权值得并查集问题
399
685
721
765
952


## 题目考频：
列举一些最常见的题目，喝前摇一摇，考前看一看
- 简单：1，20，21，26，53，66，88，101，108，121，122，136，155，160，167，169，172，190，191，198，203，206，219，226，232，263，283，342，349，371，437，455，575，821，874，1260，1332
- 中等：2，3，5，11，15，17，19，22，24，29，31，33，39，40，46，47，48，49，50，55，56，60，62，73，75，78，79，80，90，91，92，94，95，96，98，102，103，113，131，139，144，150，152，199，200，201，208，209，211，215，221，229，230，236，238，240，279，309，322，328，334，337，343，365，378.380，394，416，445，454，494，513，516，518，547，560，609，611，718，754，786，816，820，875，877，886，900，912，935，978，987，1011，1014，1019，1020，1023，1104，1131，1186，1218，1227，1261，1262，1297，1310，1334，1371，1631
- 困难：4，23，25，30，32，42，52，57，84，85，124，128，140，145，212，239，295，297，301，312，335，460，472，488，493.887.895，1032，1168，1255，1449