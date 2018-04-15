package Serializable;

import java.io.Serializable;

/**
 * Created by jinchuyang on 2018/4/3.
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password;   //被transient修饰的变量
    private static int age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        User.age = age;
    }
}
