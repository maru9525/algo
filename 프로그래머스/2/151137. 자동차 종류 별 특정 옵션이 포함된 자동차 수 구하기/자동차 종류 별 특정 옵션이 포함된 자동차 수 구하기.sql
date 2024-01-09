-- 통풍, 열선, 가죽 중 하나 이상의 옵션
-- 종류별로 몇대인지, 자동차 종류 오름
SELECT CAR_TYPE, count(*) as cars
from CAR_RENTAL_COMPANY_CAR 
where 1 = 1
and options like '%가죽시트%'
or options like '%열선시트%'
or options like '%통풍시트%'
group by  CAR_TYPE
order by car_type
