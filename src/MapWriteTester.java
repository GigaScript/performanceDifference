import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapWriteTester {
    int maxValueLength;
    int averageTime;

    public MapWriteTester(int maxValueLength) {
        this.maxValueLength = maxValueLength;
    }

    public int test(Map<String, Integer> testMap, int maxThread) throws InterruptedException {
        long time = System.nanoTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(maxThread);
        for (int j = 0; j < maxThread; j++) {
            threadPool.execute(() -> {
                for (int i = 0; i < maxValueLength; i++) {
                    Integer num = (int) Math.ceil(
                            Math.random() * maxValueLength);
                    testMap.put(String.valueOf(num), num);
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        long leadTime = (System.nanoTime() - time) / 1000000L;
        averageTime += leadTime;
        return averageTime;
    }
    public static void runWriteTest(int maximumValues, int maximumThreads) throws InterruptedException {
        Main.maximumValues = maximumValues;
        Main.maximumThreads = maximumThreads;
        MapWriteTester concurrentSmall = new MapWriteTester(maximumValues);
        for (int i = 0; i < Main.numberOfTestRepeats + 1; i++) {
            Main.concurrentResult += concurrentSmall.test(Main.concurrentMap, maximumThreads);
            Main.syncResult += concurrentSmall.test(Main.syncMap, maximumThreads);
        }
        ResultPrinter.resultWritePrint();
    }
}
