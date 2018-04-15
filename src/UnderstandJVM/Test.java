package UnderstandJVM;

/**
 * Created by jinchuyang on 2018/4/13.
 */
public class Test {
    volatile static int i = 1;
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " + getValue());
    }

    public static int getValue() {

        try {
            return i;
        } finally {
            i++;
        }
    }
}
