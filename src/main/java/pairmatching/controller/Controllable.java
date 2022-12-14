package pairmatching.controller;

import pairmatching.dto.ContentsRequestDto;
import pairmatching.view.InputView;

public interface Controllable {

    void run();

    default ContentsRequestDto readContents() {
        return ContentsRequestDto.from(InputView.readLevelCourseMission());
    }
}
