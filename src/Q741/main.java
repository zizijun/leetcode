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
