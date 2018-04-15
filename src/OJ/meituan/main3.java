package OJ.meituan;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/22.
 */
public class main3 {
    public static void main(String[] args) {
        String a , b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        b = scanner.nextLine();
        int sa = a.length();
        int sb = b.length();
        int ans = 0;
        int bnum = 0;
        int anum = 0;
        for(int i = 0; i < sb; i++){
            if(b.charAt(i) == 'a'){
                anum++;
            }else {
                bnum++;
            }
        }
        int i;
        for(i = 0; i < sb; i++){
            for(int j = i; j > sb - sa + 1 && j >= 0; j--){
                if(a.charAt(i) != b.charAt(j)){
                    ans++;
                }
            }
        }
        for (;i < sa - sb;i++){
            if(a.charAt(i) == 'b'){
                ans += anum;
            }else {
                ans += bnum;
            }
        }
        for (;i < sa; i++){
            for(int j = sb - sa + i;j < sb; j++){
                if(a.charAt(i) != b.charAt(j)){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
