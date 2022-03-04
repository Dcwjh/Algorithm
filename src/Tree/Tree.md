# 一个中心：树的遍历
- 不管是什么题目，核心就是树的遍历，这是一切的基础，不会树的遍历后面讲的都是白搭。
而树的遍历又可以分为两个基本类型，分别是深度优先遍历和广度优先遍历。这两种遍历方式并不是树特有的，但却伴随树的所有题目。

### 树的遍历迭代写法
垃圾回收算法中，有一种算法叫三色标记法。 即：
-  用白色表示尚未访问
- 灰色表示尚未完全访问子节点
- 黑色表示子节点全部访问

使用双色标记法来统一三种遍历:
- 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
- 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈(中序遍历)。
- 如果遇到的节点为灰色，则将节点的值输出。

递归：
```java
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
```
非递归
```java
class Node {
    int color;
    TreeNode node;

    Node(int color, TreeNode node) {
        this.color = color;
        this.node = node;
    }
}


    public List<Integer> inorderTraversal2(TreeNode root) {
        int WHITE = 0;
        int GRAY = 1;
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(WHITE, root));
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.node == null)
                continue;
            if (temp.color == WHITE) {
                stack.push(new Node(WHITE, temp.node.right));
                stack.push(new Node(GRAY, temp.node));
                stack.push(new Node(WHITE, temp.node.left));

            } else {
                res.add(temp.node.val);
            }
        }
        return res;
    }
```

# 不使用栈和递归，使用常熟个辅助空间遍历
1. [参考西法](https://github.com/azl397985856/leetcode/blob/master/thinkings/binary-tree-traversal.md)

2. [Morris (InOrder) traversal](https://www.educative.io/edpresso/what-is-morris-traversal)

# 两个基本点
上面提到了树的遍历有两种基本方式，分别是深度优先遍历（以下简称 DFS）和广度优先遍历（以下简称 BFS），这就是两个基本点。这两种遍历方式下面又会细分几种方式。比如 **DFS 细分为前中后序遍历， BFS 细分为带层的和不带层的。**

### 广度优先遍历
- [116. 填充每个节点的下一个右侧节点指针](../Tree/L116.java)
- [117. 填充每个节点的下一个右侧节点指针 II](../Tree/L117.java)
- [129. 求根节点到叶节点数字之和](../Tree/L129.java)
- [199. 二叉树的右视图](../Tree/L199.java)
- [222. 完全二叉树的节点个数](../Tree/L222.java): [解法](https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/)
- [230. 二叉搜索树中第K小的元素](../Tree/L230.java)
# 题型
### 搜索类
1. BFS
2. DFS

### 构建类
1. 普通二叉树的构建
2. 搜索二叉树的构建
- [ 剑指 Offer 37. 序列化二叉树]()
- [654. 最大二叉树]()
- [894. 所有可能的满二叉树]()
- [1008. 前序遍历构造二叉搜索树]()

### 修改类
- [ 116. 填充每个节点的下一个右侧节点指针]()
- [450. 删除二叉搜索树中的节点]()
- [669. 修剪二叉搜索树]()
- [863. 二叉树中所有距离为 K 的结点 ]()