package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/22.
 */
public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        int num[]=new int[10];
        for(int i=0;i<nums.length();i++){
            int temp=nums.charAt(i)-'0';
            num[temp]++;
        }
        int min=2000;
        int ans=-1;
        for(int i=1;i<10;i++){
            if(num[i]<min){
                min=num[i];
                ans=i;
            }
        }
        if(num[0]<min){
            min=num[0];
            ans=0;
        }
        if(ans==0)  System.out.print(1);
        for(int i=0;i<=min;i++)
            System.out.print(ans);
    }


}
