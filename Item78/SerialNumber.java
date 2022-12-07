package Item78;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumber {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10);

    private static volatile int nextSerialNumber = 0;

    private static int generateNextSerialNumber() throws InterruptedException {
        Thread.sleep(1);
        return nextSerialNumber++;
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