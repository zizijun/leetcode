package Serializable;

import java.io.*;

/**
 * Created by jinchuyang on 2018/4/3.
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        User user = new User();
//        user.setAge("22");
//        user.setName("aa");
//        user.setPassword("admin");
//        System.out.println(user.getAge()+"\t"+user.getName()+"\t"+user.getPassword());
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializable/user.txt"));
//        oos.writeObject(user);
//        user.setAge("23");
//        oos.flush();
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializable/user.txt"));
        User users = (User) ois.readObject();
        System.out.println(users.getAge()+"\t"+users.getName()+"\t"+users.getPassword());
    }
}
