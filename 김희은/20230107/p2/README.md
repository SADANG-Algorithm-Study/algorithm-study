### 문제 링크 
[프로그래머스][Lv.1] [조건에 맞는 회원수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131535)

### 문제 해석
- USER_INFO 테이블 주어짐
- 테이블 column id 구성 --> USER_ID, GENDER, AGE, JOINED
- 해야하는 일: 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하 회원 명수 출력

## 문제 풀이
- 조건에 해당하는 회원 (고유) ID 추출 필요 --> USER_ID
- 회원 명수 출력 --> COUNT(USER_ID)
- 조건 설정
	- (1) 나이 20~29 --> WHERE AGE BETWEEN 20 and 29
	- (2) 2021년 가입 --> SUBSTR(JOINED,1,4)=2021
		- 날짜 체크를 위한 다른 명령어(?)를 미리 숙지해놓는 것도 좋을 것 같음
	- (1),(2) 조건을 동시에 만족 --> AND
