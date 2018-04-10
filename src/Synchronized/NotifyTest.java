package Synchronized;

/**
 * Created by jinchuyang on 2018/4/10.
 */

/**
 * wait方法的使用必须在同步的范围内，(synchronized)
 * 否则就会抛出IllegalMonitorStateException异常，wait方法的作用就是阻塞当前线程等待notify/notifyAll方法的唤醒，或等待超时后自动唤醒
 */
public class NotifyTest {
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName() +" Start-----");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" End-------");
    }

    /**
     *  （1）调用wait方法后，线程是会释放对monitor对象的所有权的。

     　　（2）一个通过wait方法阻塞的线程，必须同时满足以下两个条件才能被真正执行：

     　　　　线程需要被唤醒（超时唤醒或调用notify/notifyll）。
     　　　　线程唤醒后需要竞争到锁（monitor）。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();
        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.testWait();
                }
            }).start();
        }

        synchronized (test) {
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("-----------分割线-------------");
        //test.notifyAll();
        synchronized (test) {
            test.notifyAll();
        }
    }
}
