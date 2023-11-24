-- 코드를 입력하세요
-- 생산일자가 2022-05인 식품
-- 식품 id, 이름, 총매출 
-- 총매출 내림차순, 식품id 오름차순 
SELECT p.PRODUCT_ID, p.PRODUCT_NAME
 , sum(o.AMOUNT * p.PRICE) as TOTAL_SALES
  from FOOD_PRODUCT p
     , FOOD_ORDER o
 where 1 = 1
   and p.PRODUCT_ID = o.PRODUCT_ID
   and to_char(PRODUCE_DATE, 'yyyy-mm') = '2022-05'
 group by p.PRODUCT_ID, p.PRODUCT_NAME
  order by TOTAL_SALES desc, 1
    