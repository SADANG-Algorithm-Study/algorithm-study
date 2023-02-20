select distinct car_id
    from CAR_RENTAL_COMPANY_CAR
    where car_id in (
        SELECT car_id
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where start_date >= '2022-10-01' )
      and car_type='세단'
    order by car_id desc;