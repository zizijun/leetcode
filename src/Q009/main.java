package Q009;

/**
 * Created by jinchuyang on 2018/3/18.
 */
public class main {
    public boolean isPalindrome(int x) {
        if(x < 0){return false;}
        boolean flag = true;
        int weishu = 1;
        while(x / weishu >= 10){
            weishu *= 10;
        }
        while(weishu >= 1 ){
            if(x / weishu != x % 10){
                return false;
            }
            x = (x % weishu) / 10;
            weishu /= 100;
        }
        return true;
    }

}
