package Item78;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SerialNumberAtomic {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    private static final AtomicInteger nextSerialNumber = new AtomicInteger();

    private static int generateNextSerialNumber() throws InterruptedException {
        Thread.sleep(1);
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        int N = 30;
        CountDownLatch latch = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            THREAD_POOL.execute(() -> {
                try {
                    generateNextSerialNumber();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();
            });
        }

        latch.await();
        System.out.println(nextSerialNumber);
    }
}
