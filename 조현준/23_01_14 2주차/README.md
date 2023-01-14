### 문제 링크

1. 압축
   https://school.programmers.co.kr/learn/courses/30/lessons/17684
2. 상품 별 오프라인 매출 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131533
3. 수식 최대화
   https://school.programmers.co.kr/learn/courses/30/lessons/67257

### 상세 정보
소요 시간 :  60분
문제 해결 : ( 0 / 3 )    
해결 방법 :
-------

1. 압축
   딕셔너리를 사용하여 생성되는 긴 문자열을 저장한다.  
   긴 문자열이 딕셔너리에 존재하지 않을 때까지 만든다.
   저장되지 않은 긴 문자열을 딕셔너리에 저장하고 이전 긴 문자열에 해당되는 딕셔너리 값을 answer에 저장한다.
   
   고려해야 될 사항 2가지
   1. 마지막 긴 문자열 길이가 1인 경우
   2. 마지막 긴 문자열이 딕셔너리에 존재하는 경우
-------

2. 상품 별 오프라인 매출 구하기

   inner join 을 통해 두 테이블을 합치고 group by 를 통해 상품 코드 별 매출액을 구한다.
-------

3. 수식 최대화
브루트 포스 + 스택을 활용하여 해결하면 된다.   
연산자는 *,-,+ 총 3가지 이므로 총 나올 수 있는 연산자 우선 순위 경우에 수는 최대 6가지이다.   
그러므로 브루트포스로 접근해도 1초안에 해결 가능하다. 


-------
이번주 스터디 내용:
1. 파이썬 언어에 대한 이해 부족  
1-1. for 문 안에 인덱스 수정 불가능 그 이유는 for 문 돌때마다 변수에 덮어씌우기 때문에 자세한 내용은 아래 링크 참조
   https://dojang.io/mod/page/view.php?id=2242  
1-2. 문자열 슬라이스 이해 부족 str[firstIndex : lastIndex] 이면 firstIndex ~ (lastIndex-1) 인덱스에 해당되는 문자열만 표시 된다. 
--------
2. left outer join vs inner join 차이점

성능적인 부분에서 차이가 있다.
inner join은 쿼리를 작성하면 옵티마이저가 성능 좋은 알고리즘을 알아서 선택해서 결과를 도출한다.  
outer join은 nested loop 알고리즘을 사용하기 때문에 시간복잡도가 O(n^2)이다.   

하지만, 무조건 inner join이 빠른것은 아니다. 이 부분도 주의해야됨.   
데이터 개수가 너무 적거나 HashTable이 미리 생성되지 않은 상태라면 outer join이 경우에 따라서 더 빠를 수 있다.

하지만, 보통 inner join이 빠르므로 inner join을 사용해야 된다.
outer join은 결합시 데이터가 없으면 null값으로 채우기 때문에 null 값이 필요한 경우 outer join을 사용한다. (상황에 맞게 사용해라.)  
