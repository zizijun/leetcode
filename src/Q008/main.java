package Q008;

/**
 * Created by jinchuyang on 2018/4/11.
 */
public class main {
    public static void main(String[] args) {
        System.out.println(-2147483648 / -1);
    }
    public static int myAtoi(String str) {

        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){

            i++;
        }
        str = str.substring(i, str.length());
        if (str.length() == 0){
            return 0;
        }


        int flag = 1;

        if (str.charAt(0) == '+'){
            flag = 1;
            str = str.substring(1, str.length());
        }else if(str.charAt(0) == '-'){
            flag = -1;
            str = str.substring(1, str.length());
        }
        i = 0;
        if(str.length() == 0 || !(str.charAt(i) <= '9' && str.charAt(i) >= '0')){
            return 0;
        }

        int ans = 0;
        while (ans <= 214748364 && i < str.length() && (str.charAt(i) <= '9' && str.charAt(i) >= '0')){
            if (ans == 214748364 && str.charAt(i) >= '7'){
                if(flag == - 1){
                    if (str.charAt(i) <= '8') {
                        ans = -1 * ans * 10 - (str.charAt(i) - '0');
                        return ans;
                    }else {
                        return -2147483648;
                    }
                }else if (flag == 1 ){
                    if(str.charAt(i) == '7'){
                        ans = ans * 10 + str.charAt(i) - '0';
                        return ans;
                    }else {
                        return 2147483647;
                    }

                }else {
                    break;
                }
            }else {
                ans = ans * 10 + str.charAt(i) - '0';
            }
            i++;
        }
        return ans * flag;
    }
}
