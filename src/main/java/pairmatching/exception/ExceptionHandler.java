package pairmatching.exception;

import pairmatching.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T checkError(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return checkError(inputReader);
        }
    }

    public static void checkError(Runnable process) {
        try {
            process.run();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
