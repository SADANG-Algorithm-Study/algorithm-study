## 1. [트럭(실버1)](https://www.acmicpc.net/problem/13335)
    
**문제 분석**
- 하나의 차선으로 된 다리
- n(<=1000)개의 트럭이 1만큼 순서대로 지나감
- 다리 길이는 w(<=100)이고, w대의 트럭만 동시에 다리 위에 있을 수 있음
- 다리 위 트럭의 무게의 합 <= L(<=1000)  
*output* : 모든 트럭들이 다리를 건너는 최단시간
    

**문제 풀이**
- time 현재시간, truckWeights 트럭 무게 리스트, index 트럭 번호
- Queue 다리 위에 있는 트럭(트럭 번호,들어간 시간)
1. List<Integer>에 트럭의 무게 저장
2.  while 돌면서 시간+1
    1. 내릴 트럭이 있는지 확인 후 큐에서 제거
    2. 다리 위에 있는 트럭 수가 w보다 크면 continue
    3. 다리 위에 올라갈 트럭이 있는지 확인 후 큐에 추가
    4. 마지막 트럭이 다리 위에 올라간 경우 다리를 건널 시간을 더해주고 종료

<br>

## 2. [특정 옵션이 포함된 자동차 리스트 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157343) - SQL
    
<br>

## 3. [대여 기록이 존재하는 자동차 리스트 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/157341) - SQL