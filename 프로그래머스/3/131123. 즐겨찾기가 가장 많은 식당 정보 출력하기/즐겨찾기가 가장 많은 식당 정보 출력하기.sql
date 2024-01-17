-- 음식종류별로 즐겨찾기수가 가장 많은 식당
-- 음식종류, ID , 식당이름, 즐겨찾기 수
-- 음식 종류 내림
SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME , B.FAV AS FAVORITES
FROM REST_INFO A, (SELECT FOOD_TYPE, MAX(FAVORITES) AS FAV
                   FROM REST_INFO
                  WHERE 1 = 1
                  GROUP BY  FOOD_TYPE) B
WHERE 1 = 1 
AND A.FAVORITES = B.FAV
AND A.FOOD_TYPE = B.FOOD_TYPE
ORDER BY A.FOOD_TYPE DESC


-- SELECT  FOOD_TYPE, MAX(FAVORITES) AS FAV
--                    FROM REST_INFO
--                   WHERE 1 = 1
--                   GROUP BY  FOOD_TYPE