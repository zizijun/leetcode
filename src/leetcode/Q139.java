package leetcode.Q139;

import java.util.List;

/**
 * Created by jinchuyang on 2018/1/25.
 */
public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;

        boolean flag[] = new boolean[s.length() + 1];
        flag[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i; j++){
                //判断当前word是否能被字典分割，即从当前位置往前找，找到一个子串在字典中，并且需要满足之前的子串是包含能够被字典分割的
                if(flag[j] && wordDict.contains(s.substring(j, i))){
                    flag[i]  = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}
