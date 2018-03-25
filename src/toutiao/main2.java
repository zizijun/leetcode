package toutiao;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class main2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a =in.nextInt();
        int ans=0;
        while(a%2==0){
            ans++;
            a=a/2;
        }
        ans+=a-1;
        System.out.println(ans);
        
    }
}