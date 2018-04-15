package toutiao;

import java.util.*;

/**
 * Created by jinchuyang on 2018/4/15.
 */
public class main6 {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int m = in.nextInt();

        int a[] = new int[n1];
        int b[] = new int[n2];



        for (int i = 0; i < n1; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            b[i] = in.nextInt();
        }

        combination(b);
        map.remove(0);
        //Map<Integer, Set<Integer>> map = new HashMap<>();


        int[][] dp = new int[n1][m + 1]; //
        for(int i=0;i < n1;i++){
            dp[i][0]=1;//第一列为1
        }
        for (int i = 1; i < m + 1; i ++){

            dp[0][i] = i % a[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int temp = 0;
                for (int k = 0; k <= j / a[i]; k++) {
                    temp += dp[i - 1][j - a[i] * k];
                }
                dp[i][j] = temp;
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans += dp[n1 - 1][m - entry.getKey()] * dp[n1 - 1][entry.getValue()];
        }
        System.out.println(ans + dp[n1 - 1][m]);


    }

    public static  void combination(int[] b) {

        //String[] str = {"a" , "b" ,"c"};
        int n = b.length;

        int nbit = 1<<n;
        //System.out.println("全组合结果个数为："+nbit);

        for(int i = 0 ;i < nbit ; i++) {
            //System.out.print("组合数值  "+i + " 对应编码为： ");
            int sum = 0;
            for(int j = 0; j < n ; j++) {
                int tmp = 1<<j ;
                if((tmp & i)!=0) {
                    sum += b[j];
                }
            }
            if (map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }else {
                map.put(sum, 1);
            }
        }
    }

}
