-- 코드를 입력하세요
-- suv 인 자동차의 평균 일일 대여 요금
-- 소수 첫번째 자리에서 반올림
-- 컬럼명 AVERAGE_FEE
SELECT round(avg(DAILY_FEE), 0)as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where 1 = 1
and CAR_TYPE = 'SUV'