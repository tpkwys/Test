import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tianpanke
 * @title: LockTest
 * @projectName Test
 * @description: TODO
 * @date 2019/7/18 11:23
 */
//ReentrantLock 既是公平锁又是非公平锁。调用无参构造方法时是非公平锁
//ReentrantLock 还提供了另外一种构造方法,当传入 true 的时候为公平锁，false 的时候为非公平锁。
//公平锁可以保证请求资源在时间上的绝对顺序，而非公平锁有可能导致其他线程永远无法获取到锁，造成“饥饿”的现象。
// 公平锁为了保证时间上的绝对顺序，需要频繁的上下文切换，而非公平锁会减少一些上下文切换，性能开销相对较小，可以保证系统更大的吞吐量。
public class LockTest {
    private final static Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        try{
            lock.tryLock();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
