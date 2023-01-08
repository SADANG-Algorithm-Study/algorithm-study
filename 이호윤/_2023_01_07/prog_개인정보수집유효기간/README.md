## [개인정보 수집 유효기간](https://school.programmers.co.kr/learn/courses/30/lessons/150370)

### 문제 분석
- 날짜를 비교해야하기 때문에 숫자로 변환 → 문제에서의 최소 단위인 일 단위로 변환 (※ 한 달을 28일로 계산)
- `terms`와 `privacies`를 매핑해야하므로 `terms`를 HashMap에 저장
- 해당되는 `privacy`의 번호(`인덱스 + 1`)를 반환해야하므로 `privacies`의 순서를 유지

### 코드 로직
1. `today`를 숫자로 변환
2. `terms` 루프
   1. 기간을 숫자로 변환
   2. HashMap에 `(약관 명, 일 단위 기간)`형태로 저장
3. `privacies`의 길이만큼 루프
   1. `privacy`의 수집일을 숫자로 변환
   2. `privacy`의 약관에 해당되는 기간을 HashMap에서 찾음
   3. `today`보다 `privacy + term`이 작으면 `answer`에 해당 `privacy`의 번호를 추가
4. `answer`을 배열로 변환하여 return