package Alg.CombinationAndPermutation;

/**
 * Created by jinchuyang on 2018/4/15.
 * 全排列
 */
public class Permutation {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        permutation(strings, 0, strings.length - 1);
    }

    private static void permutation(String[] strings, int first, int end) {
        if(first == end){
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i]);
            }
            System.out.println();
        }
        for (int i = first; i <= end; i++) {
            swap(i, first, strings);
            permutation(strings, first + 1, end);
            swap(first, i, strings);
        }
    }

    private static void swap(int i, int first, String[] strings) {
        String temp = strings[i];
        strings[i] = strings[first];
        strings[first] = temp;
    }
}
