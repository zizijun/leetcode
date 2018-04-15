package sort;

/**
 * Created by jinchuyang on 2018/3/5.
 */

/**
 *  1.先取一个正整数 d1(d1 < n)，把全部记录分成 d1 个组，所有距离为 d1 的倍数的记录看成一组，然后在各组内进行插入排序
    2.然后取 d2(d2 < d1)
    3.重复上述分组和排序操作；直到取 di = 1(i >= 1) 位置，即所有记录成为一个组，最后对这个组进行插入排序。一般选 d1 约为 n/2，d2 为 d1 /2， d3 为 d2/2 ，…， di = 1。
 */
public class ShellSort extends Sort{
    @Override
    void sort(int[] array) {
        super.sort(array);
        int gap = array.length >> 1;
        while(gap >0){
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j - gap >= 0 ; j -= gap) {
                    if(array[j - gap] > array[j]){
                        int temp = array[j - gap];
                        array[j - gap] = array[j];
                        array[j] = temp;
                    }else {
                        break;
                    }
                }
            }
            gap = gap >> 1;

        }
    }

}
