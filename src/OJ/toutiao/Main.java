package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class Main {
    public static void main(String[] args) {
        String str = "123";
        int h = str.hashCode();
        System.out.println(((h >>> 16)));

    }
}