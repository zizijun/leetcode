package KMP;

/**
 * Created by jinchuyang on 2018/4/2.
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(kmpSearch("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
    }
    static int kmpSearch(String str1, String str2){
        int[] next = getNext(str2.toCharArray());
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0, j = 0;
        while(i < len1 && j < len2){
            if(j == -1 || str1.charAt(i) == str2.charAt(j)){
                //①如果当前字符匹配成功（即str1.charAt(i) == str2.charAt(j)），则i++，j++
                i++;
                j++;
            }else {
                //②如果j != -1，且当前字符匹配失败（即str1.charAt(i) ！= str2.charAt(j)]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if(j == len2){
            return i - j;
        }else {
            return -1;
        }
    }
    static int[] getNext(char[] chars){
        int len = chars.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < len - 1){
            //chars[k]表示前缀，chars[j]表示后缀
            if(k == -1 || chars[k] == chars[j]){
                k++;
                j++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }
}
