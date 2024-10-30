-- 음식종류별로 즐겨찾기 수가 가장 많은 식당  음식 종류, ID, 식당 이름, 즐겨찾기수
-- 음식종류 내림차순
SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
  FROM REST_INFO A ,(SELECT FOOD_TYPE,MAX(FAVORITES) AS FAVORITES
                    FROM REST_INFO
                   WHERE 1 = 1
                   GROUP BY FOOD_TYPE
                  ) B
WHERE A.FOOD_TYPE = B.FOOD_TYPE
  AND A.FAVORITES = B.FAVORITES
ORDER BY FOOD_TYPE DESC
 



-- SELECT FOOD_TYPE,REST_ID,MAX(FAVORITES) AS FAVORITES
--                     FROM REST_INFO
--                    WHERE 1 = 1
--                    GROUP BY FOOD_TYPE, REST_ID



                  