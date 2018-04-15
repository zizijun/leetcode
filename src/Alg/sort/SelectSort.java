package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */
public class SelectSort extends Sort{
    @Override
    void sort(int[] array) {
        if (array.length <= 1) return;
        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j = 0; j < array.length - i; j++){
                if(array[j] > max){
                    max = array[j];
                    maxIndex = j;
                }
            }
            int temp = array[array.length - i -1];
            array[array.length - i -1] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
}
