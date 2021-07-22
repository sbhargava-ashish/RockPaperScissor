package logger;

public class Logger {

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";

    public static void debug(final String log) {
        System.out.println(TEXT_BLUE + log + TEXT_RESET);
    }

    public static void error(final String log) {
        System.out.println("\n" + TEXT_RED + log + TEXT_RESET);
    }

    public static void info(final String log) {
        System.out.println(TEXT_GREEN + log + TEXT_RESET);
    }

    public static void spacer() {
        System.out.println("==============================================================");
    }

}
