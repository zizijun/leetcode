package toutiao;

/**
 * Created by jinchuyang on 2018/3/24.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class main5 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int h=in.nextInt();
        int b[][]=new int[100300][102];
        for(int i=0;i<100300;i++){
            for(int j=0;j<102;j++){
                b[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            int temp=in.nextInt();
            for(int j=1;j<=h&&temp-j>=0;j++){
                b[temp-j][j]=1;
            }
        }
        int ans[]=new int[100300];
        for(int i=0;i<100300;i++){
            ans[i]=-1;
        }
        int head=0;
        int tail=1;
        int dui[]=new int[100000];
        int hash[]=new int[100300];
        ans[0]=0;
        dui[0]=0;
        hash[0]=1;
        while(tail!=head){
            int now=dui[head];
            hash[now]=0;
            head++;
            head%=100000;
            if(ans[now]==k) continue;
            for(int i=1;i<=h;i++){
                if(b[now][i]==1){
                    if(ans[now+2*i]>ans[now]+1||ans[now+2*i]==-1){
                        ans[now+2*i]=ans[now]+1;
                        if(hash[now+2*i]==0){
                            hash[now+2*i]=1;
                            dui[tail]=now+2*i;
                            tail++;
                            tail%=100000;
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<100300;i++){
            if(ans[i]!=-1&&i>max){
                max=i;
            }
        }
        System.out.println(max);
    }
}
