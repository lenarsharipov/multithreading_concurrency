import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex04 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService es01 = Executors.newSingleThreadScheduledExecutor(); // one thread

        try {
            Runnable command =
                    () -> System.out.println( System.currentTimeMillis() + " : " + Thread.currentThread().getName());

            es01.scheduleWithFixedDelay(
                    command,
                    1,
                    2, // New task starts after 2 seconds after the previous task finished.
                    // Thus, to complete one task it takes x seconds + 2 seconds
                    TimeUnit.SECONDS
            );

            Thread.sleep(10_000);
            System.out.println(Thread.currentThread().getName());

        } finally {
            es01.shutdown();
        }
    }
}
