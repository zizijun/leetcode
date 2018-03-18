package Q005;

/**
 * Created by jinchuyang on 2018/3/18.
 */
public class main {
    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(longestPalindrome(s));
    }
    static int max = 0;
    static int start = 0;
    public static String longestPalindrome(String s) {
        if(s == null){return null;}
        if(s.length() < 2){return s;}
        //int max = Integer.MIN_VALUE;

        for(int i = 0; i < s.length() - 1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + max);
    }

    static void extendPalindrome(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(j) == s.charAt(i)){
            i--;
            j++;
        }
        if(max < j - i - 1){ //已经错误加过一次 要减回来
            max = j - i - 1;
            start = i + 1;
        }
    }
}
