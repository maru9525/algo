-- 202201 카테고리별 도서 판매량, 카테고리, 총 판매량 
-- 카테고리명 오름
SELECT b.CATEGORY, SUM((s.SALES)) as TOTAL_SALES
from BOOK b, BOOK_SALES s
where 1 = 1
and b.BOOK_ID = s.BOOK_ID
and to_char(s.SALES_DATE,'yyyymm') = '202201'
group by b.CATEGORY
order by b.CATEGORY