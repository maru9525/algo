-- -- 2022년 10월 16일 = 대여중 / 대여가능
-- -- 반납 날짜가 2022년 10월 16일이여도 대여중
-- select a.car_id
-- from (select car_id,
--             '대여중' as t1
--         from CAR_RENTAL_COMPANY_RENTAL_HISTORY
--        where '20221016' between to_char(start_date,'yyyymmdd') and to_char(end_date, 'yyyymmdd')
--       or to_char(end_date, 'yyyymmdd') = '20221016'
--      ) a
    
-- where 1 = 1

-- select car_id,
--             '대여중' as t1
--         from CAR_RENTAL_COMPANY_RENTAL_HISTORY
--        where '20221016' between to_char(start_date,'yyyymmdd') and to_char(end_date, 'yyyymmdd')
--       or to_char(end_date, 'yyyymmdd') = '20221016'

select  car_id
    ,   case when sum(a1)>=1 then '대여중' else '대여 가능' end AVAILABILITY
from    (
    select  car_id
        ,   case
                when 
    '20221016' between to_char(start_date,'yyyymmdd') and to_char(end_date, 'yyyymmdd') then 1 else 0 end a1
    from    CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where   1=1
    )
group by car_id
order by car_id desc