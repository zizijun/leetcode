package OJ.meituan;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/22.
 */
public class main1 {

    public static void main(String[] args) {
        String a , b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        b = scanner.nextLine();
        int ans = 0;
        for(int i = 0; i < a.length() - b.length() + 1; i++){
            ans += compare(a.substring(i, i + b.length()), b);
        }
        System.out.println(ans);
    }

    private static int compare(String a, String b) {
        int ans = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                ans++;
            }
        }
        return ans;
    }
}
