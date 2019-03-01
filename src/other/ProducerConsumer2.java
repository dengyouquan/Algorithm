package other;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dengyouquan
 * @createTime 2019-02-02
 **/
public class ProducerConsumer2 {
    private Queue<Integer> queue = new PriorityQueue<>();
    private ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        ProducerConsumer2 producerConsumer2 = new ProducerConsumer2();
        Consumer consumer = producerConsumer2.new Consumer();
        Producer producer = producerConsumer2.new Producer();
        consumer.start();
        producer.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("queue is empty!");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    notFull.signal();
                    System.out.println("consume one, remain " + queue.size());
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 10) {
                        try {
                            System.out.println("queue is full!");
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    notEmpty.signal();
                    System.out.println("produce one, remain " + queue.size());
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
