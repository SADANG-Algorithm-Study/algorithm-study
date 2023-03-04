-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE),0) as 'AVERAGE_FEE' From CAR_RENTAL_COMPANY_CAR where car_type = 'SUV' group by car_type;