package Synchronized;

/**
 * Created by jinchuyang on 2018/4/9.
 */
public class Thread4 {
    class Inner {
        private void m4t1() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }

        private void m4t2() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    private void m4t1(Inner inner) {
        synchronized (inner) { //使用对象锁
            inner.m4t1();
        }
    }
    private synchronized void m4t2(Inner inner) {
        synchronized (Inner.class) {
            inner.m4t2();
        }
    }
    public static void main(String[] args) {
        final Thread4 myt4 = new Thread4();
        final Inner inner1 = myt4.new Inner();
        final Inner inner2 = myt4.new Inner();
        Thread t1 = new Thread(new Runnable() {public void run() { myt4.m4t1(inner1);} }, "t1");
        Thread t2 = new Thread( new Runnable() {public void run() { myt4.m4t2(inner1);} }, "t2");
        t1.start();
        t2.start();
    }
}
