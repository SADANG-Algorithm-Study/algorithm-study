## 1. [압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684)

**문제 풀이**
1. Map<String, Integer>을 사용하여 사전 초기화 -> `<글자, 색인 번호>`
2. message 의 한 글자씩 탐색 - loop
    1. 사전에 포함되지 않은 긴 문자열 찾음
    2. 문자열 사전 등록
    3. 찾은 문자열의 마지막 문자를 지운 문자열 *(사전에 등록되어 있는 문자열)* 의 색인 번호 출력

<br>

## 2. [수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257)

**문제 풀이**
1. 주어진 문자열(수식) 분할
    - 숫자 추출 (순서대로 배열에 저장)
    - 연산자 인덱스 추출 (연산자별 index 순서 저장, `Map<String, List<Integer>>` → `<연산자, index 순서 리스트>`
2. 연산자 우선순위 정하기 
    - +, -, * 연산자으로만 이루어져 경우의 수가 6가지이므로 하드코딩으로 해결
3. 우선순위에 따라 연산하기
    1. 계산에 사용된 숫자가 저장된 배열 위치에 결과값 저장
    2. 두번째 숫자의 parent를 첫번째 숫자로 변경 (union find 알고리즘 사용)
    - ex) A * B 연산일 때, 결과값을 A가 있었던 숫자 배열에 저장하고 B의 parent를 A로 바꿔준다.

<br>

## 3. [상품 별 오프라인 매출 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131533) - SQL