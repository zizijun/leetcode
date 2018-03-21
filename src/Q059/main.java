package Q059;

/**
 * Created by jinchuyang on 2018/3/21.
 */
public class main {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;//定下上下左右的边界
        int i = 0, j = 0;
        while(count <= n * n){
            for(;i <= right; i++){
                res[j][i] = count++;
            }
            i--;
            j++;
            top++;
            for(;j <= bottom; j++){
                res[j][i] = count++;
            }
            j--;
            i--;
            right--;
            for(;i >= left; i--){
                res[j][i] = count++;
            }
            i++;
            j--;
            bottom--;
            for(;j >= top; j--){
                res[j][i] = count++;
            }
            j++;
            i++;
            left++;
        }
        return res;
    }
}
