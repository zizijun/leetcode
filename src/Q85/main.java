package Q85;

/**
 * Created by jinchuyang on 2017/12/17.
 */

/**
 * 思路是从第一行开始一行一行地处理，使[i, j]处最大子矩阵的面积是(right(i, j)-left(i, j))*height(i, j)。
 * 其中height统计当前位置及往上'1'的数量；left和right是高度是当前点的height值得左右边界，即是以当前点为中心，以height为高度向两边扩散的左右边界。
 */
public class main {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        int num = maximalRectangle(matrix);
        System.out.println(num);
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0)
            return 0;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        for (int i = 0; i < n; i++) {
            right[i] = n;
        }
        int res = 0;

        for (int i = 0; i < m; i++) {
            int curr_right = n, curr_left = 0;
            for (int j = 0; j < n; j++)
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0; //记录当前列，连续1的个数

            for (int j = 0; j < n; j++) {
                left[j] = matrix[i][j] == '1' ? Math.max(left[j], curr_left) : 0;
                curr_left = matrix[i][j] == '1' ? curr_left : j + 1;
            }

            for (int j = n - 1; j >= 0; j--) {
                right[j] = matrix[i][j] == '1' ? Math.min(right[j], curr_right) : n;
                curr_right = matrix[i][j] == '1' ? curr_right : j;
            }

            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }
        return res;
    }

    public static int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length, res = 0;
        int height[] = new int[n];
        int left[] = new int[n];
        int right[] = new int[n];
        for (int i = 0; i < n; i++)
            right[i] = n;

        for (int i = 0; i < m; ++i) {
            int cur_left = 0, cur_right = n;

            for (int j = 0; j < n; ++j)
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;

            for (int j = 0; j < n; ++j) {
                left[j] = matrix[i][j] == '1' ? Math.max(left[j], cur_left) : 0;
                cur_left = matrix[i][j] == '1' ? cur_left : j + 1;
            }

            for (int j = n - 1; j >= 0; --j) {
                right[j] = matrix[i][j] == '1' ? Math.min(right[j], cur_right) : n;
                cur_right = matrix[i][j] == '1' ? cur_right : j;
            }

            for (int j = 0; j < n; ++j)
                res = Math.max(res, (right[j] - left[j]) * height[j]);
        }

        return res;
    }
}
