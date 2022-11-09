import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static Map<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>();
    public static Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<String, Integer>());
    public static final int numberOfTestRepeats = 5;
    public static int concurrentResult, syncResult, maximumThreads, maximumValues = 0;

    public static void main(String[] args) throws InterruptedException {
        smallWriteTest();
        smallReadTest();
//        middleWriteTest();
//        middleReadTest();
//        bigWriteTest();
//        bigReadTest();

    }

    public static void smallWriteTest() throws InterruptedException {
        MapWriteTester.runWriteTest(100_000, 1);
        MapWriteTester.runWriteTest(100_000, 3);
        MapWriteTester.runWriteTest(100_000, 10);
        MapWriteTester.runWriteTest(100_000, 15);
        MapWriteTester.runWriteTest(100_000, 30);
        MapWriteTester.runWriteTest(100_000, 50);
    }

    public static void middleWriteTest() throws InterruptedException {
        MapWriteTester.runWriteTest(1_000_000, 1);
        MapWriteTester.runWriteTest(1_000_000, 3);
        MapWriteTester.runWriteTest(1_000_000, 10);
        MapWriteTester.runWriteTest(1_000_000, 15);
        MapWriteTester.runWriteTest(1_000_000, 30);
        MapWriteTester.runWriteTest(1_000_000, 50);
    }

    public static void bigWriteTest() throws InterruptedException {
        MapWriteTester.runWriteTest(10_000_000, 1);
        MapWriteTester.runWriteTest(10_000_000, 3);
        MapWriteTester.runWriteTest(10_000_000, 10);
        MapWriteTester.runWriteTest(10_000_000, 15);
        MapWriteTester.runWriteTest(10_000_000, 30);
        MapWriteTester.runWriteTest(10_000_000, 50);
    }
    public static void smallReadTest() throws InterruptedException {
        MapReaderTester.runReadTest(100_000, 1);
        MapReaderTester.runReadTest(100_000, 3);
        MapReaderTester.runReadTest(100_000, 10);
        MapReaderTester.runReadTest(100_000, 15);
        MapReaderTester.runReadTest(100_000, 30);
        MapReaderTester.runReadTest(100_000, 50);
    }

    public static void middleReadTest() throws InterruptedException {
        MapReaderTester.runReadTest(1_000_000, 1);
        MapReaderTester.runReadTest(1_000_000, 3);
        MapReaderTester.runReadTest(1_000_000, 10);
        MapReaderTester.runReadTest(1_000_000, 15);
        MapReaderTester.runReadTest(1_000_000, 30);
        MapReaderTester.runReadTest(1_000_000, 50);
    }

    public static void bigReadTest() throws InterruptedException {
        MapReaderTester.runReadTest(10_000_000, 1);
        MapReaderTester.runReadTest(10_000_000, 3);
        MapReaderTester.runReadTest(10_000_000, 10);
        MapReaderTester.runReadTest(10_000_000, 15);
        MapReaderTester.runReadTest(10_000_000, 30);
        MapReaderTester.runReadTest(10_000_000, 50);
    }

    public static void resetResult() {
        concurrentResult = 0;
        syncResult = 0;
    }

}