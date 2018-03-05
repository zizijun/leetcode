package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */

/**
 * 1.从第一个元素开始，该元素可以认为已经被排序
 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
 5.将新元素插入到该位置后
 6.重复步骤 2~5
 */
public class InsertionSort extends Sort{
    @Override
    void sort(int[] array) {
        super.sort(array);
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while(j >= 0 && array[j] > array[i]){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j--;
            }
        }
    }
}
