package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */

/**
 *  1.在数据集之中，选择一个元素作为”基准”（pivot）。
    2.所有小于”基准”的元素，都移到”基准”的左边；所有大于”基准”的元素，都移到”基准”的右边。这个操作称为分区 (partition) 操作，分区操作结束后，基准元素所处的位置就是最终排序后它的位置。
    3.对”基准”左边和右边的两个子集，不断重复第一步和第二步，直到所有子集只剩下一个元素为止。
 */
public class QuickSort extends Sort {
    @Override
    void sort(int[] array) {
        super.sort(array);
        quickSort(0, array.length - 1, array);

    }
    void quickSort(int left, int right, int[] array){
        if (left >= right)return;

        int i = left, j = right;
        while (i < j){
            int temp = array[i];
            while(i < j && array[j] > temp){
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] < temp) {
                i++;
            }
            array[j] = array[i];

            array[i] = temp;
        }

        quickSort(left, i - 1, array);
        quickSort(i + 1, right, array);
    }
}
