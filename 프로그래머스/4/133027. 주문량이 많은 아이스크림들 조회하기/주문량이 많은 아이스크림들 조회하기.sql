-- 코드를 입력하세요
-- 7월 아이스크림 총 주문량 + 
-- 상반기의 아이스크림 총 주문량 
-- 큰 순서대로 상위 3개
select FLAVOR
from (
SELECT f.FLAVOR as FLAVOR, sum(f.TOTAL_ORDER) + sum(j.TOTAL_ORDER)
from FIRST_HALF f,  JULY j
where 1 = 1
and f.FLAVOR = j.FLAVOR
group by f.FLAVOR
order by sum(f.TOTAL_ORDER) + sum(j.TOTAL_ORDER) desc
)
where rownum <= 3

 -- limit 3