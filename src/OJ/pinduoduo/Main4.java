package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/3.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        int sortNums[]  = new int[k];
        int[][] map = new int[n][2];
        for (int i = 0; i < k; i++) {
            sortNums[i] = nums[i];

        }





    }
    private static class BigHeap{
        int index;
        int[] num ;

        public BigHeap(int[] num) {
            this.num = num;
        }

        public void heapSort(){
            int n = num.length;
            for(int i = n/2;i>=0;i--){   //建堆，从n/2开始向上调整
                adjustHeap(i, n);
            }
            for(int j=n-1;j>=0;j--){
                swap(0, j);         //交换开始和最后位置上的数字
                adjustHeap(0, j);    //交换之后再调整堆
            }
        }
        public void adjustHeap(int s,int n){  //由于根节点编号是从0开始的，所以其左子树是2*i+1
            for(int i=s;i<n;){
                int max = i;
                if((2*i+1)<n&&num[2*i+1]>num[max]) max = 2*i+1;
                if((2*i+2)<n&&num[2*i+2]>num[max]) max = 2*i+2;
                if(max!=i){
                    swap(i,max);
                    i=max;
                }else break;

            }

        }
        public void swap(int i,int j){
            int tem = num[i];
            num[i] = num[j];
            num[j] = tem;
        }
    }
    private static class SmallHeap{
        int[] num ;

        public SmallHeap(int[] num) {
            this.num = num;
        }

        public void heapSort(){
            int n = num.length;
            for(int i = n/2;i>=0;i--){   //建堆，从n/2开始向上调整
                adjustHeap(i, n);
            }
            for(int j=n-1;j>=0;j--){
                swap(0, j);         //交换开始和最后位置上的数字
                adjustHeap(0, j);    //交换之后再调整堆
            }
        }
        public void adjustHeap(int s,int n){  //由于根节点编号是从i开始的，所以其左子树是2*i+1
            for(int i=s;i<n;){
                int min = i;
                if((2*i+1)<n&&num[2*i+1]<num[min]) min = 2*i+1;
                if((2*i+2)<n&&num[2*i+2]>num[min]) min = 2*i+2;
                if(min!=i){
                    swap(i,min);
                    i=min;
                }else break;

            }

        }
        public void swap(int i,int j){
            int tem = num[i];
            num[i] = num[j];
            num[j] = tem;
        }
    }
}
