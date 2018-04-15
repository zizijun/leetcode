package toutiao;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            deal(str);
        }


    }

    private static void deal(String str) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> fuhao = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '6'){
                nums.push(6);
            }else if (c == '+' || c == '-'){
                fuhao.push(c);
            }else {
                nums.pop();
                nums.push(36);
                i++;
            }
        }
        int ans = 0;
        while(!fuhao.empty()){
            int num2 = nums.pop();
            int num1 = nums.pop();
            char c = fuhao.pop();
            if(c == '+'){
                nums.push(num1 + num2);
            }else {
                nums.push(num1 - num2);
            }
        }
        System.out.println(nums.pop());
    }
}