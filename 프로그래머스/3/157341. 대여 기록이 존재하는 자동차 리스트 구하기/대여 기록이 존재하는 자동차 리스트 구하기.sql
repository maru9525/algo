-- 자동차 종류 세단, 10월에 대여를 시작한 기록이 있는 자동차 id
-- 중복 x, 자동차id 내림차순
SELECT distinct(c.car_id)
from CAR_RENTAL_COMPANY_CAR c
, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where 1 = 1
  and c.CAR_ID = h.CAR_ID
  and c.car_type = '세단'
  and to_char(h.start_date ,'mm') = '10'
order by c.car_id desc