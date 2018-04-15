package leetcode.Q64;

/**
 * Created by jinchuyang on 2017/12/17.
 */
public class Q64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int path[][] = new int[m][n];
        path[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }
        return path[m - 1][n - 1];
    }
}
