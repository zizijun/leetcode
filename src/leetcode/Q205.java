package leetcode;

/**
 * Created by jinchuyang on 2018/3/18.
 */
public class Q205 {

    public static void main(String[] args) {
        isIsomorphic1("ab", "aa");
    }
    public static boolean isIsomorphic(String s, String t) {
        //Map<Character, Integer> map = new HashMap();
        if(s.equals(t)) return true;
        char[] map = new char[256];
        boolean[] used = new boolean[256];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for(int i = 0; i< cs.length;i++){
            if(map[cs[i]] == 0){ //If current character is null in string s
                if(used[ct[i]]) return false; // if this character in ct is used return false
                map[cs[i]] = ct[i]; //put ct[i] to the map
                used[ct[i]] = true; //set this index to true
            }else{
                if(map[cs[i]] != ct[i]) return false; //if current map index of cs[i] is not ct[i] return false;
            }
        }
        return true;

    }
    /**
     * 用数组应该会更快些
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic1(String s, String t) {
        int[] nums = new int[256];
        for(int i = 0; i < nums.length; i++){
            nums[i] = -1;
        }
        for(int i = 0; i < s.length(); i++){

            if(nums[s.charAt(i)] != -1){
                if(t.charAt(nums[s.charAt(i)]) != t.charAt(i)){
                    return false;
                }
            }
            nums[s.charAt(i)] = i;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = -1;
        }
        for(int i = 0; i < t.length(); i++){
            if(nums[t.charAt(i)] != -1){
                if(s.charAt(nums[t.charAt(i)]) != s.charAt(i)){
                    return false;
                }
            }
            nums[t.charAt(i)] = i;
        }
        return true;
    }
}
