package TX;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/5.
 */
public class Main2 {
    static long C[][] = new long [1001][1001];
    public static void main(String[] args) {
        build();

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int a = in.nextInt();
        int x = in.nextInt();
        int b = in.nextInt();
        int y = in.nextInt();
        int m = 1000000007;
        Long ans = 0l;
        for (int i = 0; i < x; i++) {
            for(int j = 0; j <= y; j++){
                if(a*i+b*j == k) {
                    ans += combine(x,i)*combine(y, j);
                    ans = ans %1000000007;
                }
            }

        }
        System.out.println((int)(ans % m));

    }

    static void build(){
        int i,j;
        for(i=0; i<= 1000; ++i){
            C[0][i] = 0;
            C[i][0] = 1;
        }
        for(i=1; i<= 1000; ++i){
            for(j=1; j<= 1000; ++j)
                C[i][j] = (C[i-1][j] % 1000000007 + C[i-1][j-1]) % 1000000007;
        }
    }

    static long combine(int n, int m){
        return C[n][m];
    }


}
