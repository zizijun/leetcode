package Q003;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinchuyang on 2018/3/17.
 */
public class main {
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){return 0;}
        Map<Character, Integer> map = new HashMap();//map存储字符的位置
        int max = Integer.MIN_VALUE;

        for(int i = 0, j = 0; i < s.length(); i++){// 用两个指针指向当前无重复字串的头与尾，i是尾，j是头
            if(map.containsKey(s.charAt(i))){//如果该字符已存在于map，
                j = Math.max(j, map.get(s.charAt(i)) + 1);//需要比较上一个j的位置与当前j的位置拿一个靠后，来判断j是否需要移动
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
