public class ResultPrinter {
    public static void ReadResultPrint() {
        System.out.println(
                "Среднее время чтения  в concurrentResultWrite " + Main.concurrentResult / Main.numberOfTestRepeats + " мс."
                        + " Значений: " + Main.maximumValues + " Потоков: " + Main.maximumThreads + "\n"
                        + "Среднее время чтения syncResultWrite " + Main.syncResult / Main.numberOfTestRepeats + " мс."
                        + " Значений: " + Main.maximumValues + " Потоков: " + Main.maximumThreads + "\n");
        Main.resetResult();
    }
    public static void resultWritePrint() {
        System.out.println(
                "Среднее время записи  в concurrentResultWrite " + Main.concurrentResult / Main.numberOfTestRepeats + " мс."
                        + " Значений: " + Main.maximumValues + " Потоков: " + Main.maximumThreads + "\n"
                        + "Среднее время записи syncResultWrite " + Main.syncResult / Main.numberOfTestRepeats + " мс."
                        + " Значений: " + Main.maximumValues + " Потоков: " + Main.maximumThreads + "\n");
        Main.resetResult();
    }
}
