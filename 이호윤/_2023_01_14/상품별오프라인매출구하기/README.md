## [상품 별 오프라인 매출 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131533)

### 조건 확인
- [x] 상품 코드 별로 그룹화
- [x] 매출액 (판매가 * 판매량) **합계**를 출력
- [x] 매출액 기준 내림차순 + 상품코드 기준 오름차순

### 함수 및 구문
- SELECT 절
  - `SUM(PRICE * SALES_AMOUNT)`로 매출액 합계를 출력
- GROUP BY 절
  - `GROUP BY PRODUCT_CODE`로 상품 코드 별 그룹화
- ORDER BY 절
  - `ORDER BY 매출액 DESC, PRODUCT_CODE`로 결과 정렬