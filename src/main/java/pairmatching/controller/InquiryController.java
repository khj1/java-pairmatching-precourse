package pairmatching.controller;

import pairmatching.domain.Pair;
import pairmatching.domain.PairRepository;
import pairmatching.dto.ContentsRequestDto;
import pairmatching.exception.ExceptionHandler;
import pairmatching.view.OutputView;

import java.util.List;

public class InquiryController implements Controllable {

    @Override
    public void run() {
        ContentsRequestDto requestDto = ExceptionHandler.checkError(this::readContents);

        List<Pair> pairs = PairRepository.findByCourseAndMission(requestDto.getCourse(), requestDto.getMission());
        OutputView.printPairs(pairs);
    }
}
