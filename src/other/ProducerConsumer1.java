package other;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author dengyouquan
 * @createTime 2019-02-02
 **/
public class ProducerConsumer1 {
    private Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1();
        Consumer consumer = producerConsumer1.new Consumer();
        Producer producer = producerConsumer1.new Producer();
        consumer.start();
        producer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("queue is empty!");
                            //不能用new Object().wait();
                            // 因为虽然wait用于暂停当前线程，但是还有一个功能就是需要释放queue的锁
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("consume one, remain " + queue.size());
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 10) {
                        try {
                            System.out.println("queue is full!");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                    System.out.println("produce one, remain " + queue.size());
                }
            }
        }
    }
}
