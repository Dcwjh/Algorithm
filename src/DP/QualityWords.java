package DP;

/**
 * @Description 在自然语言处理中一个重要的问题是分词，例如句子“他说的确实在理”中“的确”“确实”“实在”“在理”都是常见的词汇，
 * 但是计算机必须为给定的句子准确判断出正确分词方法。一个简化的分词问题如下：给定一个长字符串$y=y_1y_2…y_n$，
 * 分词是把y切分成若干连续部分，每部分都单独成为词汇。我们用函数quality(x)判断切分后的某词汇$x=x_1x_2…x_k$的质量，
 * 函数值越高表示该词汇的正确性越高。分词的好坏用所有词汇的质量的和来表示。
 * 例如对句子“确实在理”分词，quality(确实) + quality(在理) > quality(确)+quality(实在)+quality(理)。
 * 请设计一个动态规划算法对字符串y分词，要求最大化所有词汇的质量和。
 * （假定你可以调用quality(x)函数在一步内得到任何长度的词汇的质量）
 * @Author Jianhai Wang
 * @ClassName QualityWords
 * @Date 2019/11/9 11:13
 * @Version 1.0
 */

/*
算法思想：

采用动态规划自下而上的方式进行求解。

设问题的最优解为opt[n], 其物理含义为从第i个词到第n个词使所有划分的子词quality最大划分，最优解公式为：
$$opt(n) = max(opt(m) + quality(m+1,n))$$

其中quality(m+1,n)表示第n+1个词到第n个词所组成的词的quality值
 */

public class QualityWords {
    public static int Partition(String s){
        if(s==null)
            return 0;
        int n = s.length();
        int[] opt = new int[n + 1];
        opt[0] = 0;
        for(int i = 0; i <= n;i++) {
            opt[i] = opt[i - 1] + quality(i, i);
            for (int j = 2; j <= i; j++)
                opt[i] = Math.max(opt[i],opt[i - j] + quality(i-j+1,1));
        }
        return opt[n];
    }

    private static int quality(int i, int j){
        //TODO
        return 0;
    }
}
