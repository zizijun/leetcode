package leetcode.Q63;

/**
 * Created by jinchuyang on 2017/12/16.
 */
public class Q063 {
    public static void main(String[] args) {
        int grid[][] = {{0, 0},{0,0}};
        uniquePathsWithObstacles(grid);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        System.out.println();
        int path[][] = new int[m][n];
        boolean isBlock = false;
        for(int i = 0; i < n; i ++){
            if(isBlock){
                path[0][i] = 0;
            }else{
                if(obstacleGrid[0][i] == 1){
                    isBlock = true;
                    path[0][i] = 0;
                }else{
                    path[0][i] = 1;
                }
            }
        }
        isBlock = false;
        for(int i = 0; i < m; i ++){
            if(isBlock){
                path[i][0] = 0;
            }else{
                if(obstacleGrid[i][0] == 1){
                    isBlock = true;
                    path[i][0] = 0;
                }else{
                    path[i][0] = 1;
                }
            }
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                //System.out.println("i:"+i+"; j:"+j);
                if(obstacleGrid[i][j] == 1){
                    path[m][n] = 0;
                }else{
                    path[m][n] = path[m - 1][n] + path[m][n - 1];
                }
            }
        }
        return path[m - 1][n - 1];
    }
}
