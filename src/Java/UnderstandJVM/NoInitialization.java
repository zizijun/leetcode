package UnderstandJVM;

/**
 * Created by jinchuyang on 2018/4/2.
 */
public class NoInitialization {
    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        SuperClass[] c = new SubClass[10];
    }
}
