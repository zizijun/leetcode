package Synchronized;

/**
 * Created by jinchuyang on 2018/4/10.
 */

/**
 * join方法的作用是父线程等待子线程执行完成后再执行，换句话说就是将异步执行的线程合并为同步的线程
 */
public class JoinTest implements Runnable{
    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " start-----");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++) {
            Thread test = new Thread(new JoinTest());
            test.start();
            //在没有使用join方法之间，线程是并发执行的，而使用join方法后，所有线程是顺序执行的。
            try {
                test.join(); //调用join方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished~~~");
    }
}
