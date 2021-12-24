# 페어매칭관리 애플리케이션

## 기능
- 선택할 수 있는 기능을 출력하는 기능
- 사용자로부터 사용할 기능을 입력받는 기능
  - [예외] 공백을 입력하는 경우
  - [예외] 제시된 선택지에서 벗어난 값을 입력한 경우
- 페어 매칭 선택 시 과정, 미션, 레벨 정보를 출력하는 기능
- 과정, 레벨, 미션을 선택하라는 안내 문구를 출력하는 기능
- 사용자로부터 과정, 레벨, 미션을 입력받는 기능
  - [예외] 공백을 입력하는 경우
  - [예외] 하나의 정보라도 누락된 경우
  - [예외] 존재하지 않는 과정, 레벨, 미션을 입력받는 경우
- 크루들의 이름을 파일에서 읽어오는 기능
- 크루들의 이름을 섞는 기능
- 페어를 두명씩 매칭하는 기능
- 페어 매칭 대상이 홀수인 경우 마지막 페어는 3인으로 구성하는 기능
- 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없는 기능
- 페어 매칭 결과를 출력하는 기능
- 매칭 정보가 존재할 경우 재매칭 여부를 묻는 기능
  - '예'를 선택 시 다시 매칭한다.
  - '아니오'를 선택 시 코스, 레벨, 미션을 다시 입력받는다.
  - [예외] 공백을 입력하는 경우
  - [예외] '예', '아니오'가 아닌 값을 입력하는 경우
- 매칭이 3번 이상 이루어지지 않는 경우 예외 처리
- 더 이상 매칭이 될 수 없는 경우 예외 처리
- 페어를 조회하는 기능
  - 매칭 이력이 없으면 매칭 이력이 없다고 안내한다.
- 페어를 초기화하는 기능
- 프로그램을 종료하는 기능

## 프로그래밍 실행 예시
```
기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
1

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

페어 매칭 결과입니다.
다비 : 신디
쉐리 : 덴버
제키 : 로드
라라 : 윌터
니콜 : 이브
린다 : 시저
보노 : 제시 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
1

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

매칭 정보가 있습니다. 다시 매칭하시겠습니까?
네 | 아니오
아니오

과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주
매칭 정보가 있습니다. 다시 매칭하시겠습니까?
네 | 아니오
네

페어 매칭 결과입니다.
이브 : 윌터
보노 : 제키
신디 : 로드
제시 : 린다
시저 : 라라
니콜 : 다비
리사 : 덴버 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
2

#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3: 
  - 레벨4: 성능개선 | 배포
  - 레벨5: 
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
프론트엔드, 레벨1, 자동차경주

페어 매칭 결과입니다.
이브 : 윌터
보노 : 제키
신디 : 로드
제시 : 린다
시저 : 라라
니콜 : 다비
리사 : 덴버 : 제키

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
3

초기화 되었습니다. 

기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
Q
```
