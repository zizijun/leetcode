package TX;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/5.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[][] strs = new String[m][n];
        int[][] nums1 = new int[m][n];

        int[][] nums2 = new int[m][n];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[0].length; j++) {
                strs[i][j] = in.next();

            }
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[0].length; j++) {

                if(strs[i][j].equals("Y")){
                    nums1[i][j] = 1;
                }
                if(strs[i][j].equals("B")){
                    nums2[i][j] = 1;
                }
                if(strs[i][j].equals("G")){
                    nums1[i][j] = 1;
                    nums2[i][j] = 1;
                }
            }
        }
        int num = 0;
        for(int i = 0; i < nums1[0].length; i++){
            num += nums1[0][i];
        }
        for (int i = 1; i < nums1.length; i++) {
            num += nums1[i][0];
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums1[0].length; j++) {
                if (nums1[i][j] != 0){
                    if(nums1[i - 1][j - 1] != 1){
                        num++;
                    }
                }
            }

        }
        for(int i = 0; i < n; i++){
            num += nums2[m - 1][i];
        }
        for (int i = 0; i < m; i++) {
            num += nums2[i][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = m - 2; j >= 0; j--){
                if(nums2[i][j] != 0){
                    if(nums2[i - 1][j + 1] != 1){
                        num++;
                    }
                }
            }
        }
        System.out.println(num );
    }

}
