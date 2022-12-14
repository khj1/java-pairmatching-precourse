package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.dto.ContentsRequestDto;
import pairmatching.exception.ExceptionHandler;
import pairmatching.view.OutputView;

import java.util.List;

public class MatchingController implements Controllable {


    @Override
    public void run() {
        ContentsRequestDto requestDto = ExceptionHandler.checkError(this::readContents);

        PairMatching pairMatching = initPairMatching(requestDto);
        List<Pair> pairs = pairMatching.match();

        OutputView.printPairs(pairs);
    }

    private static PairMatching initPairMatching(ContentsRequestDto requestDto) {
        Course course = requestDto.getCourse();
        Level level = requestDto.getLevel();
        Mission mission = requestDto.getMission();

        return PairMatching.create(course, level, mission);
    }
}
