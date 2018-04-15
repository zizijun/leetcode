package Synchronized;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jinchuyang on 2018/4/12.
 */

/**
 * 在CyclicBarrier的内部定义了一个Lock对象，每当一个线程调用CyclicBarrier的await方法时，将剩余拦截的线程数减1，
 * 然后判断剩余拦截数是否为0，如果不是，进入Lock对象的条件队列等待。如果是，执行barrierAction对象的Runnable方法，
 * 然后将锁的条件队列中的所有线程放入锁等待队列中，这些线程会依次的获取锁、释放锁，接着先从await方法返回，
 * 再从CyclicBarrier的await方法中返回
 */
public class CyclicBarrierDemo {
    private CyclicBarrier cb = new CyclicBarrier(4);
    private Random rnd = new Random();

    class TaskDemo implements Runnable{
        private String id;
        TaskDemo(String id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                Thread.sleep(rnd.nextInt(1000));
                System.out.println("Thread " + id + " will wait");
                cb.await();
                System.out.println("-------Thread " + id + " is over");
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
        }
    }

    public static void main(String[] args){
        CyclicBarrierDemo cbd = new CyclicBarrierDemo();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(cbd.new TaskDemo("a"));
        es.submit(cbd.new TaskDemo("b"));
        es.submit(cbd.new TaskDemo("c"));
        es.submit(cbd.new TaskDemo("d"));
        es.shutdown();
    }
}
