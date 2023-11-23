-- 코드를 입력하세요
-- 상품코드 별 매출액(판매가 * 판매량) 합계 출력
-- 매출액 기준 내림차순, 상품코드 오름
SELECT p.PRODUCT_CODE, sum(p.price * o.SALES_AMOUNT) as SALES
from PRODUCT p, OFFLINE_SALE o
where 1 = 1
and p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by  sum(p.price * o.SALES_AMOUNT) desc, p.PRODUCT_CODE

