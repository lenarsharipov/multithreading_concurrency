import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex02 {

    public static void main(String[] args) {
        ScheduledExecutorService es01 = Executors.newSingleThreadScheduledExecutor(); // one thread
        ScheduledExecutorService es02 = Executors.newScheduledThreadPool(4);
        try {
            Runnable task = () -> System.out.println(":)");
            es01.schedule(task, 5, TimeUnit.SECONDS);

        } finally {
            es01.shutdown();
        }
    }

}
