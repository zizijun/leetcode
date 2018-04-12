package reflect;

import java.lang.reflect.Field;

/**
 * Created by jinchuyang on 2018/4/9.
 */
public class GetPrivateField {
    public static void main(String[] args) throws Exception {


        // 得到私有的变量值
        PrivateField user = new PrivateField();
        //Object password = fieldPassword.get(user);
        //fieldPassword.set(PrivateField.class, "");
        // 输出私有变量的值
        //System.out.println(password.toString());//qqpassword
        PrivateField p = new PrivateField();
        // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
        Field fieldPassword = PrivateField.class.getDeclaredField("password");
        // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
        fieldPassword.setAccessible(true);
        fieldPassword.set(p, "sby");
        System.out.println(p.getPassword());
    }
}
