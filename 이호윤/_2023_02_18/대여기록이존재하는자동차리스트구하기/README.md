## [대여 기록이 존재하는 자동차 리스트 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157341)

### 조건 확인
- 자동차 종류 = 세단
- 10월에 대여 시작 기록 존재
- 중복 X
- 자동차 ID 기준 내림차순

### 함수 및 구문
- `DISTINCT CAR_ID` 로 중복 제거
- `MONTH(START_DATE)`로 시작 날짜가 10월인지 확인