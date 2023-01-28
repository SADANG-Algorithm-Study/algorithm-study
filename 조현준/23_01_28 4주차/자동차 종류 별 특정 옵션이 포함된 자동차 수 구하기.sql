-- 코드를 입력하세요
SELECT car_type, count(car_type) cars
from CAR_RENTAL_COMPANY_CAR
where (options LIKE '%통풍시트%' or
       options LIKE '%가죽시트%' or
       options LIKE '%열선시트%')
group by car_type
order by car_type asc;