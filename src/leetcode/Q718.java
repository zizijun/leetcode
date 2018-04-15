package leetcode;

/**
 * Created by jinchuyang on 2018/1/15.
 */
public class Q718 {
    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0){return 0;}
        int max = 0;
        int matrix[][] = new int[A.length][B.length];
        for(int i = 0; i < A.length; i++){
            if(B[0] == A[i])
                matrix[i][0] = 1;
        }
        for(int i = 0; i < B.length; i++){
            if(A[0] == B[i])
                matrix[0][i] = 1;
        }
        for(int i = 1; i < A.length; i++){
            for(int j = 1; j < B.length; j++){
                matrix[i][j] = A[i] == B[j] ? matrix[i - 1][j - 1] + 1 : 0;
            }
        }
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                max = Math.max(matrix[i][j], max);
            }
        }
        return max;
    }
}
