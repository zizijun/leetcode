package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinchuyang on 2018/3/2.
 */
public class Q242 {

   //这个方法真的好蠢啊，才击败了0.24% 的人
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        List<Character> lists = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
            lists.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++){
            lists.remove((Character) t.charAt(i));
        }
        return lists.size() == 0;
    }

    public boolean isAnagram1(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length() ; i++) nums[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length() ; i++) nums[t.charAt(i) - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (nums[i] != 0) return false;
        }
        return true;
    }
}
