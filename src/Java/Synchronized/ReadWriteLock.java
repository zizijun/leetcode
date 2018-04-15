package Synchronized;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinchuyang on 2018/4/13.
 */
public class ReadWriteLock {

    private Map<Thread, Integer> readingThread = new HashMap<>();
    private int writer = 0;
    private int prewriter = 0;
    private Thread writingThread = null;

    public synchronized void lockReader() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while (! canGrantReadAccess(currentThread)){//读的时候不能有写线程或者准备写的线程
            wait();
        }
        readingThread.put(currentThread, getReadAccessCount(currentThread) + 1);
    }
    public  synchronized void unlockReader(){
        Thread currentThread = Thread.currentThread();
        int accessCount = getReadAccessCount(currentThread);
        if (accessCount == 1){
            readingThread.remove(currentThread);
        }else {
            readingThread.put(currentThread, accessCount - 1);
        }
        notifyAll();
    }

    public synchronized void lockWriter() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        prewriter++;
        while (! canGrantWriteAccess(currentThread)){//写的时候不能有线程在读或者写
            wait();
        }
        writer++;
        prewriter--;
        writingThread = currentThread;
    }

    public synchronized void unlockWriter(){
        writer--;
        if (writer == 0){
            writingThread = null;
        }
        notifyAll();
    }

    /**
     * 获取当前读线程，能否读的权限
     * @param currentThread
     * @return
     */
    private boolean canGrantReadAccess(Thread currentThread){
        if (isOnlyWriter(currentThread)){return true;}
        if (writer > 0) return false;
        if (readingThread.get(currentThread) != null) return true;
        if (prewriter > 0) return false;
        return true;
    }

    private boolean isOnlyWriter(Thread currentThread) {
        return currentThread == writingThread;
    }

    /**
     * 获取当前写线程，能否读的权限
     * @param currentThread
     * @return
     */
    private boolean canGrantWriteAccess(Thread currentThread) {
        if(isOnlyReader(currentThread)){return true;}
        if(readingThread.size() != 0){return false;}
        if (writingThread == null){return true;}
        if (currentThread != writingThread){return false;}
        return true;
    }

    private boolean isOnlyReader(Thread currentThread) {
        return readingThread.size() == 1 && readingThread.get(currentThread) != null;
    }


    /**
     * 获得当前线程的重入次数
     * @param callingThread
     * @return
     */
    private int getReadAccessCount(Thread callingThread){
        return readingThread.get(callingThread) == null ? 0 : readingThread.get(callingThread);
    }


}
