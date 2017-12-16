package Q741;

/**
 * Created by jinchuyang on 2017/12/12.
 */

/**
 * 好难
 */
public class main {
    public static void main(String[] args) {
        int grid[][] = {{0, 1, -1},{1, 0, -1},{1, 1,  1}};
        int i = cherryPickup(grid);
        System.out.println(i);
    }
    //需要明白几点
    //1.这个题目希望求解的是，从0，0到N-1, N-1，然后再走回来，所以第一次走到N-1,N-1之后
    //grid的内容会发生变化，所以第二次是在grid变化之后的基础上走的.

    //2.对于N*N的矩阵，从0-0到N-1-N-1, 如果只走一次，那么朝着右下走和朝着左上走，是一样的.
    //这个问题的第二次走，我们可以理解成，是在grid变化之后，朝着右下角，又走了一次.

    //3.题目希望得到两次走法的最大和.

    //4.从左上角，走到左下角，走一次，有很多种走法，但是这些走法的总长度一定是 2 * (n - 1)
    //所以我们要求的值是， 所有路径中(第一次走到左下角 + 第一次走完后，在grid变化后，再走一次到左小角) 和最大的.

    //5.两次长度和为 2 * （n - 1）的走法，其每次终点是N-1, N-1（根据第2点，我们把第二次也理解成朝右下走））
    //我们用dp[2*(n-1)][n-1][n-1] 表示 这个解.
    //2*(n - 1) 表示单条路径长度.
    //第一个n - 1表示, 第一条路径终点的横坐标
    //第二个n - 1表示，在第一条路径走完后，从头再走一边，第二条路径终点的横坐标

    //6.为什么只要横坐标，因为一条路径，如果路径长度固定，在已知横坐标的情况下，纵坐标是固定的.
    //例如: 路径长度为10， 如果横坐标为3(假设横坐标以0开头)，表示在垂直方向，路径长度为4，所以水平方向走6步就到了, 至于这6步怎么走没关系，只要
    //是水平走6步即可， 最终纵坐标(假设纵坐标以0开头)一定是5

    //7.总结
    //dp[k][xa][xb] 表示，有两条路径，长度均为K，第一条路径终点横坐标为xa，由第6点, 我们可求得其纵坐标. 同理，第二条路径终点横坐标为xb
    //这里要再强调一点，xb这条路径，是在xa这条路径才走完后，才走的, 是依赖第一条路径的.

    //这两条长度为k的路径, 所能得到的做多cherry数, 即为dp[k][xa][xb]
    //而本题, 因为两条路径长度均为 2 * (n - 1), 且两条路径终点均为n - 1,故 ans=dp[2(n - 1)][n - 1][n - 1]

        //8.关键的的递推公式
    //说了这么多，如何推导出递推公式?
    //这里用到一张图，帮助很大.
    //要计算dp[2n - 2][n - 1][n - 1], 需要先求出路径长度为 2n - 3的, 在长度为2n - 3的可能走法里，取两条路径和最大的.
    //grid只有两个点, 可以满足路径长度为2n - 3, 我们需要先求出，这两个点的最大
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int maxK = 2 * n - 1;
        int dp[][][] = new int[maxK][n][n];
        for(int x = 0; x < maxK; x++){
            for (int y = 0; y < n; y++){
                for (int z = 0; z < n; z++)
                    dp[x][y][z] = -1;
            }
        }
        for(int k = 0; k < maxK; k++) {
            for(int xa = 0; xa < n && xa <= k; xa++) {
                for(int xb = xa; xb < n && xb <= k; xb++) {
                    //System.out.println("xa:"+xa+";k - xa:"+(k - xa)+";xb:"+xb+";k - xb:"+(k - xb));
                    if(k - xa >= n || k - xb >= n || grid[xa][k - xa] == -1 || grid[xb][k - xb] == -1) continue;
                    int tmp = 0;
                    if(k > 0) {
                        tmp = dp[k - 1][xa][xb];
                        if(xb > 0) tmp = Math.max(tmp, dp[k - 1][xa][xb - 1]);
                        if(xa > 0) tmp = Math.max(tmp, dp[k - 1][xa - 1][xb]);
                        if(xa > 0 && xb > 0) tmp = Math.max(tmp, dp[k - 1][xa - 1][xb - 1]);
                    }

                    if(tmp < 0) continue;
                    tmp += (xa == xb) ? grid[xa][k - xa] : grid[xa][k - xa] + grid[xb][k - xb];
                    dp[k][xa][xb] = tmp;
                }
            }
        }

        return dp[maxK - 1][n - 1][n - 1] > 0 ? dp[maxK - 1][n - 1][n - 1] : 0;
    }
}
