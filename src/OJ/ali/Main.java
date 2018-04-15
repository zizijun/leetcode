package OJ.ali;
import java.util.*;
/**
 * Created by jinchuyang on 2018/3/21.
 */


/**
 * 已知有两个长度相等的正整数数组A、B，
 其元素分别记为{a(1)，a(2)，a(3)，a(4) ...... a(n) ......}和{b(1)，b(2)，b(3)，b(4) ...... b(n) ......}，
 两个数组中任一元素大小不超过10000，数组长度在1000以内，
 现在按照以下规则将A数组中的元素插入到B数组中进行合并：

 对于A数组中任一元素可以插入到B数组中任意位置。
 对于A数组中任一元素a(i)，在合并之后的数组中a(i)对应的下标小于a(i+1)对应的下标。（如果a(i+1)存在的话）
 问题：
 对合并之后的数组中相邻元素两两相乘，然后求其累加值，请给出所有合并可能形成的数组对应累加值的最小值。

 以长度为4的两个数组为例：
 A：{a1，a2，a3，a4}
 B：{b1，b2，b3，b4}
 插入完成后的数组可能为：
 {a1，a2，b1，b2，b3，b4，a3，a4}、
 {b1，a1，b2，b3，a2，a3，b4，a4}等。
 其对应的累加值分别对应为
 a1*a2 + b1*b2 + b3*b4 + a3*a4、
 b1*a1 + b2*b3 + a2*a3 + b4*a4等。
 */
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static long min(int[] from, int[] to) {
        int length = from.length;
        int k[][] = new int[length + 1][length + 1];

        for(int i = 0; i < length; i++){
            if(i % 2 == 0){
                if(i >= 2){
                    k[i][0] = k[i - 2][0] + from[i] * from[i - 1];
                }else {
                    k[i][0] = from[i] * from[i - 1];
                }
            }
        }
        for (int i = 0; i < length ; i++) {
            if(i % 2 == 0){
                if(i >= 2){
                    k[0][i] = k[0][i - 2] + to[i] * to[i - 1];
                }else {
                    k[0][i] = to[i] * to[i - 1];
                }
            }
        }

        for (int i = 0; i < length ; i++) {
            if(i + 1 % 2 == 0){
                if(i >= 2){
                    k[1][i] = Math.min(k[1][i - 2] + to[i] * to[i - 1], k[0][i - 1] + to[i] * from[0]);
                }else {
                    k[1][i] = from[1] * to[1];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if(i + 1 % 2 == 0){
                if(i >= 2){
                    k[i][1] = Math.min(k[i - 2][1] + from[i] * from[i - 1], k[i - 1][0] + to[0] * from[i]);
                }else {
                    k[i][1] = from[1] * to[1];
                }
            }
        }


        for (int i = 2; i < length + 1; i++) {
            for(int j = 2; j < length + 1; i++){
                if ((i + j) % 2 == 0){
                    int num1 = k[i][j - 2] + to[j - 1] * to[j];
                    int num2 = k[i - 1][j - 1] + to[j] * from[i];
                    int num3 = k[i - 2][j] + from[i - 1] * from[i];
                    k[i][j] = Math.min(Math.min(num1, num2), num3);
                }
            }
        }
        return k[length][length];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        int _from_size = 0;
        _from_size = Integer.parseInt(in.nextLine().trim());
        int[] _from = new int[_from_size];
        int _from_item;
        for(int _from_i = 0; _from_i < _from_size; _from_i++) {
            _from_item = Integer.parseInt(in.nextLine().trim());
            _from[_from_i] = _from_item;
        }

        int _to_size = 0;
        _to_size = Integer.parseInt(in.nextLine().trim());
        int[] _to = new int[_to_size];
        int _to_item;
        for(int _to_i = 0; _to_i < _to_size; _to_i++) {
            _to_item = Integer.parseInt(in.nextLine().trim());
            _to[_to_i] = _to_item;
        }

        res = min(_from, _to);
        System.out.println(String.valueOf(res));

    }
}