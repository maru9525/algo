-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우
-- 식품 가격을 기준으로 내림차순 정렬
SELECT A.CATEGORY, B.MAX_PRICE, A.PRODUCT_NAME
  FROM FOOD_PRODUCT A , (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
                           FROM FOOD_PRODUCT
                          GROUP BY CATEGORY
                        ) B
 WHERE A.CATEGORY = B.CATEGORY
   AND A.PRICE = B.MAX_PRICE
   AND A.CATEGORY IN ('과자', '국', '김치', '식용유')
 ORDER BY B.MAX_PRICE DESC



-- SELECT CATEGORY, PRODUCT_NAME
-- FROM FOOD_PRODUCT
-- WHERE CATEGORY IN ('과자', '국', '김치', '식용유')