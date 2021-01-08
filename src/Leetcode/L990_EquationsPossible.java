package Leetcode;

/**
 * @Description TODO
 * @Author Jianhai Wang
 * @ClassName L990_EquationsPossible
 * @Date 1/6/2021 4:09 PM
 * @Version 1.0
 */

/**
 *
 * 使用数据结果：并查集
 *     思路：由于相等关系具有传递性，所有相等得变量属于同一个集合
 *     只关心连通性，不关系距离，因此很容易想到并查集
 *
 *     算法流程：
 *     - 扫描所有等式，将等式两边的顶点进行合并；
 *     - 再扫描所有不等式，检查每一个不等式的两个顶点是不是在一个连通分量里：
 *          如果在，返回false,表示方程式有矛盾
 *          如果所有检查都没有矛盾，返回true
 *
 *
 *
 */


public class L990_EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for(String equation: equations){
            char[] str = equation.toCharArray();
            if (str[1] == '=') {
                int index1 = str[0] - 'a';
                int index2 = str[3]- 'a';
                unionFind.union(index1,index2);
            }
        }

        for(String equation: equations){
            char[] str = equation.toCharArray();
            if (str[1] != '=') {
                int index1 = str[0] - 'a';
                int index2 = str[3]- 'a';
                if(unionFind.isConnected(index1,index2))
                    return false;
            }
        }
        return true;



    }


    private class UnionFind{
        private int[] parent;

        //初始化数组，自己的父亲就是自己
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        //隔代路径压缩,效率高一些,压缩不完全
        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
         return x;
        }
        //彻底路径压缩
        public int find2(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        //两个元素相同，划分在同一个集合中
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y){
            return find(x)== find(y);
        }

    }
}
