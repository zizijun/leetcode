package TX;

import java.util.Scanner;

/**
 * Created by jinchuyang on 2018/4/5.
 */
public class Main1 {
    private static M m= new M();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        System.out.println(a * b / 2);
        m.m();
    }
    static class  M{
        static void m(){}
    }
}
