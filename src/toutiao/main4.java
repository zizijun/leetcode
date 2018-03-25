package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class main4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        double m=in.nextInt();
        double n=in.nextInt();
        double a[]=new double[100002];
        double b[]=new double[100002];
        double suma=0;
        double sumb=0;
        for(int i=0;i<100002;i++){
            a[i]=999999999;
            b[i]=999999999;
        }
        for(int i=0;i<m;i++){
            int temp=in.nextInt();
            a[i]=temp;
            suma+=temp;
        }
        for(int i=0;i<n;i++){
            int temp=in.nextInt();
            b[i]=temp;
            sumb+=temp;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int ans=0;
        if(suma/m>sumb/n){
            int posa=0;
            int posb=0;
            for(int i=0;i<m;i++){
                if(a[i]>sumb/n){
                    posa=i;
                    break;
                }
            }
            for(int i=0;i<n;i++){
                if(b[i]>sumb/n){
                    posb=i;
                    break;
                }
            }
            while(a[posa]<suma/m&&a[posa]>sumb/n&&posa<m){
                while(a[posa]>b[posb]){
                    posb++;
                }
                if(a[posa]==b[posb]){
                    posa++;
                }
                else{
                    ans++;
                    suma-=a[posa];
                    m--;
                    sumb+=a[posa];
                    n++;
                    posa++;
                }

            }
        }
        else{
            int posa=0;
            int posb=0;
            for(int i=0;i<m;i++){
                if(a[i]>suma/m){
                    posa=i;
                    break;
                }
            }
            for(int i=0;i<n;i++){
                if(b[i]>suma/m){
                    posb=i;
                    break;
                }
            }
            while(b[posb]<sumb/n&&b[posb]>suma/m&&posb<n){
                while(a[posa]<b[posb]){
                    posa++;
                }
                if(a[posa]==b[posb]){
                    posb++;
                }
                else{
                    ans++;
                    suma+=b[posb];
                    m++;
                    sumb-=b[posb];
                    n--;
                    posb++;
                }

            }
        }
        System.out.println(ans);

    }
}