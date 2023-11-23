-- 코드를 입력하세요
-- 판매날짜, 상품id, 유저id,판매량
-- 2022년 3월 온오프 데이터
-- off userid = null 로 표기
-- 판매일 기준 오름차순, 상품id 오름, 유저id 오름
select * from (
SELECT to_char(SALES_DATE,'yyyy-mm-dd') as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE 
where to_char(SALES_DATE,'yyyy-mm') = '2022-03' 
union all
SELECT to_char(SALES_DATE,'yyyy-mm-dd') as SALES_DATE, PRODUCT_ID, null as user_id, SALES_AMOUNT
from OFFLINE_SALE 
where to_char(SALES_DATE,'yyyy-mm') = '2022-03' 
    )
order by 1, 2, 3
