package TX;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/5.
 */


public class Main3{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String []lines = line.split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);
        int [][]M = new int[n][2];
        int [][]T = new int[m][2];
        for(int i = 0; i < n; i++){
            String val = in.nextLine();
            String []vals = val.split(" ");
            M[i][0] = Integer.parseInt(vals[0]);
            M[i][1] = Integer.parseInt(vals[1]);
        }
        for(int i = 0; i < m; i++){
            String val = in.nextLine();
            String []vals = val.split(" ");
            T[i][0] = Integer.parseInt(vals[0]);
            T[i][1] = Integer.parseInt(vals[1]);
        }
        boolean[] used = new boolean[m];
        int ans = 0;
        int num = 0;
        for(int i = 0; i < n; i++){
            int max = 0;
            int pos = -1;
            for(int j = 0; j < m; j++){
                if(!used[j]){
                    if(M[i][0] >= T[j][0] && M[i][1] >= T[j][1]){
                        if(max < 200 * T[j][0] + 3 * T[j][1]){
                            max = 200 * T[j][0] + 3 * T[j][1];
                            pos = j;
                        }
                    }
                }
            }
            if(max != 0){
                used[pos] = true;
                num ++;
                ans += max;
            }
        }
        System.out.println(num + " " + ans);
    }
}
