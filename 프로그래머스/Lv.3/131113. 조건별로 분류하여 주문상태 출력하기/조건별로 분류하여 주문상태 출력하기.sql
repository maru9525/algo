-- 5월 1일을 기준 주문, 제품, 출고일자, 출고여부
-- 5.1까지 출고완료, 이후는 출고 대기로 미정(null)이면 출고미정 출력
-- 주문 오름
SELECT ORDER_ID, PRODUCT_ID, to_char(OUT_DATE, 'yyyy-mm-dd'),
case when to_number(to_char(OUT_DATE, 'mmdd')) <= 0501 then '출고완료'
     when to_number(to_char(OUT_DATE, 'mmdd')) > 0501 then '출고대기'
     when OUT_DATE is null then '출고미정'
     -- else ''
end as 출고여부
From FOOD_ORDER
order by ORDER_ID