import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex03 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService es01 = Executors.newSingleThreadScheduledExecutor(); // one thread

        try {
            es01.scheduleAtFixedRate(
                    () -> System.out.println( System.currentTimeMillis() + " : " + Thread.currentThread().getName()),
                    1,
                    2, // tasks starts every 2 seconds.
                    // If the task executed within more than 2 seconds,
                    // then there are 2 parallel tasks at the same time
                    TimeUnit.SECONDS
            );

            Thread.sleep(10_000);
            System.out.println(Thread.currentThread().getName());

        } finally {
            es01.shutdown();
        }
    }

}
