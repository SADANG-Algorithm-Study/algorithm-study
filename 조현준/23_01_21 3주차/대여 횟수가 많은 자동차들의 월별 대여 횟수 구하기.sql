select  EXTRACT(month FROM start_date) month,car_id,count(*) records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in
      (SELECT car_id
       from CAR_RENTAL_COMPANY_RENTAL_HISTORY
       where TO_CHAR(START_DATE, 'YYYY-MM-DD') BETWEEN '2022-08-01' AND '2022-10-31'
       group by car_id having count(*) >= 5) and TO_CHAR(START_DATE, 'YYYY-MM-DD') BETWEEN '2022-08-01' AND '2022-10-31'
group by EXTRACT(month FROM start_date),car_id
order by EXTRACT(month FROM start_date) asc, car_id desc;