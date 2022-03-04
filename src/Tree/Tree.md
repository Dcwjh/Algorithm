- 不管是什么题目，核心就是树的遍历，这是一切的基础，不会树的遍历后面讲的都是白搭。
而树的遍历又可以分为两个基本类型，分别是深度优先遍历和广度优先遍历。这两种遍历方式并不是树特有的，但却伴随树的所有题目。

# 树的遍历迭代写法
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
- DFS 细分为前中后序遍历
- BFS 细分为带层的和不带层的

**BFS 不是 层次遍历**

BFS 适合求最短距离，这个和层次遍历是不一样的，很多人搞混。这里强调一下，层次遍历和 BFS 是完全不一样的东西。
层次遍历就是一层层遍历树，按照树的层次顺序进行访问。

BFS 的核心在于求最短问题时候可以提前终止，这才是它的核心价值，层次遍历是一种不需要提前终止的 BFS 的副产物。这个提前终止不同于 DFS 的剪枝的提前终止，而是找到最近目标的提前终止。比如我要找距离最近的目标节点，BFS 找到目标节点就可以直接返回。而 DFS 要穷举所有可能才能找到最近的，这才是 BFS 的核心价值。实际上，我们也可以使用 DFS 实现层次遍历的效果，借助于递归，代码甚至会更简单。

# 深度优先遍历
深度优先搜索算法（英语：Depth-First-Search，DFS）是一种用于遍历树或图的算法。沿着树的深度遍历树的节点，尽可能深的搜索树的分支。当节点 v 的所在边都己被探寻过，搜索将回溯到发现节点 v 的那条边的起始节点。这一过程一直进行到已发现从源节点可达的所有节点为止。如果还存在未被发现的节点，则选择其中一个作为源节点并重复以上过程，整个进程反复进行直到所有节点都被访问为止，属于盲目搜索。

由于 DFS 可以基于递归去做，因此算法会更简洁。 在对性能有很高要求的场合，我建议你使用迭代，否则尽量使用递归，不仅写起来简单快速，还不容易出错。

这里的 stack 可以理解为自己实现的栈，也可以理解为调用栈。如果是调用栈的时候就是递归，如果是自己实现的栈的话就是迭代。

```
const visited = {}
function dfs(i) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }

    visited[i] = true // 将当前状态标为已搜索
    for (根据i能到达的下个状态j) {
        if (!visited[j]) { // 如果状态j没有被搜索过
            dfs(j)
        }
    }
}
```

上面的 visited 是为了防止由于环的存在造成的死循环的。 而我们知道树是不存在环的，因此树的题目大多数不需要 visited，除非你对树的结构做了修改，比如就左子树的 left 指针指向自身，此时会有环。

DFS树：
```
function dfs(root) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }
    for (const child of root.children) {
        dfs(child)
    }
}
```

几乎所有的题目几乎都是二叉树，因此下面这个模板更常见:
```
function dfs(root) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }
    dfs(root.left)
    dfs(root.right)
}
```

# 两种常见分类
前序遍历
```
function dfs(root) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }
    // 主要逻辑
    dfs(root.left)
    dfs(root.right)
}
```

后序遍历
```
function dfs(root) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }
    dfs(root.left)
    dfs(root.right)
    // 主要逻辑
}
```


```
function dfs(root) {
    if (满足特定条件）{
        // 返回结果 or 退出搜索空间
    }
    // 做一些事
    dfs(root.left)
    dfs(root.right)
    // 做另外的事
}
```


为什么递归写的没问题，用栈写迭代就有问题呢? 本质上其实还是对递归的理解不够:画图 + 手动代入


# 广度优先遍历
BFS 比较适合找最短距离/路径和某一个距离的目标。比如给定一个二叉树，在树的最后一行找到最左边的值。力扣 513 

```js
const visited = {}
function bfs() {
    let q = new Queue()
    q.push(初始状态)
    while(q.length) {
        let i = q.pop()
        if (visited[i]) continue
        if (i 是我们要找的目标) return 结果
        for (i的可抵达状态j) {
            if (j 合法) {
                q.push(j)
            }
        }
    }
    return 没找到
}
```