import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Ex01 {
    public static void main(String[] args) {
        int cpus = Runtime.getRuntime().availableProcessors();
        Executor ex01 = Executors.newFixedThreadPool(cpus);

        Executor ex02 = Executors.newSingleThreadExecutor();

        Executor ex03 = Executors.newCachedThreadPool();

        Executor ex04 = Executors.newWorkStealingPool();
    }
}
