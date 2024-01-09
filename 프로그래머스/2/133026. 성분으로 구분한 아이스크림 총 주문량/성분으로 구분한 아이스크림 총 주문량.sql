--  아이스크림 성분타입, 타입에 대한 총 주문량
-- 주문량이 작은 순서
SELECT i.INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF f, ICECREAM_INFO  i
where 1 = 1
and f.FLAVOR = i.FLAVOR
group by i.INGREDIENT_TYPE
order by sum(f.TOTAL_ORDER) 