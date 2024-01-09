-- 평균 대여시간 7일 이상, 자동차id, 평균 대여기간
-- 소수점 2번째 자리 반올림, 평균 대여기간 내림차순, 자동차id 내림
SELECT CAR_ID, ROUND(avg(end_date - start_date +1),1) AS AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where 1 = 1
group by car_id
having ROUND(avg(end_date - start_date+1) ,1)  >= 7
order by AVERAGE_DURATION  desc, car_id desc



