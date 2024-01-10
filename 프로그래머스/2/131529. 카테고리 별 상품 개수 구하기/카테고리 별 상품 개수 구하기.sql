-- 상품 카테고리 코드 앞 2자리 별 상품 개수
-- 삼품 카테고리 코드 오름
SELECT substr(PRODUCT_CODE,1,2) as CATEGORY, count(*) as PRODUCTS
from PRODUCT 
where 1 = 1
group by substr(PRODUCT_CODE,1,2)
order by substr(PRODUCT_CODE,1,2)
