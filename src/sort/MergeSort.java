package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */

/**
 *  1.把 n 个记录看成 n 个长度为 l 的有序子表
    2.进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表
    3.重复第 2 步直到所有记录归并成一个长度为 n 的有序表为止。
 */
public class MergeSort extends Sort{

    @Override
    void sort(int[] array) {
        super.sort(array);
        int mid = array.length / 2;
        mergeSort(0, array.length - 1, array);
    }
    private void mergeSort(int first, int last, int[] array){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSort(first, mid, array);
            mergeSort(mid + 1, last, array);
            merge(first, mid, last, array);
        }
    }

    private void merge(int first, int mid, int last, int[] array) {
        int[] temp = new int[last - first + 1];
        int indexA = first, indexB =  mid + 1, indexC = 0;
        while(indexA <= mid && indexB <= last){
            if(array[indexA] > array[indexB]){
                temp[indexC] = array[indexB];
                indexB++;
                indexC++;
            }else {
                temp[indexC] = array[indexA];
                indexA++;
                indexC++;
            }
        }
        while(indexA <= mid){
            temp[indexC] = array[indexA];
            indexA++;
            indexC++;
        }
        while(indexB <= last){
            temp[indexC] = array[indexB];
            indexB++;
            indexC++;
        }
        for (int i = first; i <= last; i++) {
            array[i] = temp[i - first];
        }
    }


}
