-- 경기도에 위치한 창고id, 이름, 주소, 냉동시설 여부 조회
-- 냉동시설 null 이면 n 출력, 창고 아이디 오름
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, nvl(FREEZER_YN, 'N') as FREEZER_YN
from FOOD_WAREHOUSE
where ADDRESS like '%경기도%'
order by WAREHOUSE_ID asc