-- 코드를 입력하세요
with table1 as (
    SELECT car_id,'대여중' as 'AVAILABILITY' from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date <= '2022-10-16' and '2022-10-16' <= end_date
)

SELECT CRCRH.car_id, IFNULL(AVAILABILITY, "대여 가능") as 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CRCRH
         LEFT OUTER JOIN table1 AS t1
                         ON CRCRH.car_id = t1.car_id group by CRCRH.car_id order by CRCRH.car_id desc;