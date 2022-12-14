package pairmatching.controller;

import pairmatching.command.MainCommand;
import pairmatching.exception.ExceptionHandler;
import pairmatching.view.InputView;

public class MainController {

    public void run() {
        MainCommand mainCommand;
        do {
            mainCommand = ExceptionHandler.checkError(InputView::readMainCommand);
            ExceptionHandler.checkError(mainCommand::run);
        } while (mainCommand.isRunnable());
    }
}
