package Alg.CombinationAndPermutation;

/**
 * Created by jinchuyang on 2018/4/15.
 * 全组合
 */
public class Combination {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        combination(strings);
    }

    /*
    * ** 基本思路：求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是：
    * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
    * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
    * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
    * 000,001,010,011,100,101,110,111 。对应输出组合结果为：
    空,a, b ,ab,c,ac,bc,abc.
    这个输出顺序刚好跟数字0~2^n结果递增顺序一样
    取法的二进制数其实就是从0到2^n-1的十进制数
       * ******************************************************************
       * *
       * */
    private static void combination(String[] strs) {
        int strs_length = strs.length;
        int num = 1 << strs_length;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < strs_length; j++) {
                int temp = 1 << j;
                if ((temp & i) != 0){
                    System.out.print(strs[j]);
                }
            }
            System.out.println("---------");
        }
    }


}
