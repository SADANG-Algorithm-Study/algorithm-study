## 1. [효율적인 해킹](https://www.acmicpc.net/problem/1325)
    
**문제 분석**
1. N개의 컴퓨터로 이루어진 회사
2. 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터 해킹
3. A가 B를 신뢰(A B) -> B를 해킹하면 A도 해킹 가능

- input : N번의 번호, M개의 신뢰 관계 <= 10,000
- output :한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 오름차순으로
    
**문제 풀이**
- list에 출력할 번호 저장 
- result = list 오름차순 sort
1. A B관계일 때 B 리스트에 A 저장
2. 컴퓨터 1번 부터 깊이 우선 탐색(stack사용)
    1. 해킹 가능한 컴퓨터의 수는 count변수에 저장
    2. n번 컴퓨터의 해킹 가능한 컴퓨터 수가 count보다 크면 count에 저장 및 list reset 후 번호 저장
    3. count 변수와 같으면 list에 추가

<br>

## 2.  [자동차 평균 대여 기간 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157342) - SQL