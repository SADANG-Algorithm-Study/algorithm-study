## 1. [키로거(실버2)](https://www.acmicpc.net/problem/5397)
    
**문제 분석**
- 강산이의 비밀번호를 알아내는 프로그램 작성  
***input*** : 길이가 L인 문자열(1 <= L <= 1,000,000)  
***output*** : 강산이의 비밀번호  

**문제 풀이**
- left stack, right stack
1.  '-' 이면 left stack pop
2. '<' 이면 left stack pop -> right stack push (left stack isEmpty 넘어감)
3.  '>'이면 right stack pop -> left stack push (right stack isEmpty 넘어감)
4. 그 외, left stack push

<br>

## 2. [자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기](https://school.programmers.co.kr/learn/courses/30/lessons/157340) - SQL

<br>

## 3. [평균 일일 대여 요금 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/151136) - SQL