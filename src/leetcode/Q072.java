package leetcode.Q72;

/**
 * Created by jinchuyang on 2017/12/17.
 * 自然语言处理（NLP）中，有一个基本问题就是求两个字符串的minimal Edit Distance, 也称Levenshtein distance。受到一篇Edit Distance介绍文章的启发，本文用动态规划求取了两个字符串之间的minimal Edit Distance. 动态规划方程将在下文进行讲解。

     1. what is minimal edit distance?
     简单地说，就是仅通过插入(insert)、删除(delete)和替换(substitute)个操作将一个字符串s1变换到另一个字符串s2的最少步骤数。
     其实一个替换操作可以相当于一个delete+一个insert，所以我们将权值定义如下：
     I  (insert)：1
     D (delete)：1
     S (substitute)：2

     2. example:
     intention->execution
     Minimal edit distance：
     delete i ; n->e ; t->x ; insert c ; n->u 求和得cost=8

     3.calculate minimal edit distance dynamically
     思路见注释，这里D[i,j]就是取s1前i个character和s2前j个character所得minimal edit distance
     三个操作动态进行更新：
     D(i,j)=min { D(i-1, j) +1, D(i, j-1) +1 , D(i-1, j-1) + s1[i]==s2[j] ? 0 : 2}；中的三项分别对应D，I，S。
    这里因为有替换操作，所以S的权值为1
 */
public class Q072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //边界条件
        if(m == 0)
            return n;
        if(n == 0)
            return m;

        int d[][] = new int[m][n];//存储word1与word2各个字母之间的编辑距离
        boolean isEqual = false;//判断是否已有相同字母出现
        for(int i = 0; i < m; i ++){
            //如果相等，则距离不增加
            if(word1.charAt(i) == word2.charAt(0) && !isEqual){
                d[i][0] = i > 0 ? d[i - 1][0] : 0;//不能从0开始
                isEqual = true;
            }else {
                d[i][0] = d[i - 1][0] + 1;
            }
        }
        isEqual = false;
        for(int i = 0; i < n; i ++){
            if(word2.charAt(i) == word1.charAt(0) && !isEqual){
                d[0][i] = i > 0 ? d[0][i - 1] : 0;
                isEqual = true;
            }else {
                d[0][i] = d[0][i - 1] + 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    d[i][j] = d[i - 1][j - 1];//相等的话直接相等
                }else {
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                //然后与从f[i-1][j]+1，f[i][j-1]+1比较，取最小值
                d[i][j] = Math.min(d[i][j],(Math.min(d[i - 1][j], d[i][j - 1]))+ 1);
            }
        }
        return d[m - 1][n - 1];
    }
}
