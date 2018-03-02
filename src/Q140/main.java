package Q140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jinchuyang on 2018/1/25.
 */
public class main {
    public static void main(String[] args) {
        String[] strs = {"cat","cats","and","sand","dog"};
        List<String> list = Arrays.asList(strs);
        List<String> a = wordBreak("catsanddog", list);
        System.out.println(a.size());
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String> lists[] = new List[n + 1];
        for(int i = 0; i < n + 1; i++){
            List<String> list = new ArrayList<>();
            if(wordDict.contains(s.substring(0, i))){
                list.add(s.substring(0, i));
            }
            lists[i] = list;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                if(lists[j].size() > 0 && wordDict.contains(s.substring(j, i))){
                    for(String str : lists[j]){
                        String newStr = new String(str);
                        newStr = newStr + " " + s.substring(j, i);
                        lists[i].add(newStr);
                    }
                }
            }
        }
        return lists[n];
    }
}
