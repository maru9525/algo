-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f, ICECREAM_INFO i
where 1 = 1
  and f.FLAVOR = i.FLAVOR
  and f.TOTAL_ORDER > 3000
  and i.INGREDIENT_TYPE like '%fruit%'
order by f.TOTAL_ORDER desc