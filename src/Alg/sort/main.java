package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */
public class main {
    public static void main(String[] args) {
        int[] array = {9, 2, 4, 7, 5, 11, 1};
        //Sort sort = new BubbleSort();
        //Sort sort = new SelectSort();
        //Sort sort = new InsertionSort();
        //ort sort = new ShellSort();
        //Sort sort = new MergeSort();
        Sort sort = new QuickSort();
        sort.sort(array);
        printArray(array);
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

    }
}
