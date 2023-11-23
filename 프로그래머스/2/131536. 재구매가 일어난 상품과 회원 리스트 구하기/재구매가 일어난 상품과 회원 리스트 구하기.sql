-- 코드를 입력하세요
-- 동일한 회원 동일한 상품 재구매
-- 재구매한 회원 id , 상품 id 
-- 회원 id 오름차순
-- 회원 id 같으면 상품 id 내림차순
SELECT USER_ID, PRODUCT_ID
from ONLINE_SALE
where 1 = 1
group by user_id, product_id
having count(*) >= 2
order by USER_ID, PRODUCT_ID desc
