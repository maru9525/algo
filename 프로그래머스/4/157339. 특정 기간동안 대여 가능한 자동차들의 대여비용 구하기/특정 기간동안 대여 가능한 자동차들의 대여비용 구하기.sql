-- 코드를 입력하세요
-- 자동차 종류 = 세단 또는 Suv
-- 2022 11월 1일부터 2022년 11월 30일까지 대여 가능하고
-- 30일간 대여 금액이 50만원이상 200만원 미만인 자동차
-- 자동차 id, 종류, 금액 출력
-- 대여금액 내림차순, 자동차 종류 오름, 자동차 id 내림
SELECT a.CAR_ID, a.CAR_TYPE, (a.DAILY_FEE * (1 - (c.DISCOUNT_RATE / 100)) * 30) as FEE
from CAR_RENTAL_COMPANY_CAR a,
CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
where 1 = 1
and a.CAR_ID not in (select CAR_ID
                      from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    where (CAR_ID, END_DATE) in (select CAR_ID, max(END_DATE)
                                                 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                 group by CAR_ID
                                                
                                                )
                     and to_char(start_date, 'yyyymmdd') <= '20221130'
                     and to_char(end_date, 'yyyymmdd') >= '20221101'
                    
                    )



and a.CAR_TYPE = c.CAR_TYPE
and a.CAR_TYPE in ('세단', 'SUV')
and c.DURATION_TYPE = '30일 이상'
and (a.DAILY_FEE * (1 - (c.DISCOUNT_RATE / 100)) * 30) between 500000 and 1999999
order by 3 desc, 2 , 1 desc