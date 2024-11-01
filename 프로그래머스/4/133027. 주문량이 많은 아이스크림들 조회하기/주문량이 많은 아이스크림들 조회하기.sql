-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값
-- 상위 3개 맛 rownum
-- FIRST_HALF, JULY / SHIPMENT_ID, TOTAL_ORDER
SELECT * 
  FROM (
  
    SELECT A.FLAVOR
      FROM FIRST_HALF A , JULY B
     WHERE 1 = 1
       AND A.FLAVOR = B.FLAVOR
     GROUP BY A.FLAVOR
     ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
 )
 WHERE ROWNUM <= 3

-- WHERE ROWNUM <= 3
    
    
    
    
    
    

  
  
-- SELECT FLAVOR, TOTAL_ORDER
--   FROM FIRST_HALF
  
  -- SELECT FLAVOR, TOTAL_ORDER
  -- FROM JULY 


