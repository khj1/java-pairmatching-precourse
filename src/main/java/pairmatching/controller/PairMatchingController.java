package pairmatching.controller;

import pairmatching.command.MainCommand;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.dto.ContentsRequestDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        MainCommand mainCommand = checkError(inputView::readMainCommand);
        ContentsRequestDto requestDto = checkError(this::readContents);

        PairMatching pairMatching = initPairMatching(requestDto);
        List<Pair> pairs = pairMatching.match();

        outputView.printPairs(pairs);
    }

    private static PairMatching initPairMatching(ContentsRequestDto requestDto) {
        Course course = requestDto.getCourse();
        Level level = requestDto.getLevel();
        Mission mission = requestDto.getMission();

        return PairMatching.create(course, level, mission);
    }

    private ContentsRequestDto readContents() {
        return ContentsRequestDto.from(inputView.readLevelCourseMission());
    }

    private <T> T checkError(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return checkError(inputReader);
        }
    }
}
