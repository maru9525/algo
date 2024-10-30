-- 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태
-- 2022년 10월 5일
-- 거래상태가 SALE 이면 판매중, RESERVED 이면 예약중, DONE 이면 거래완료
-- 게시글 ID를 기준으로 내림차순
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
        CASE WHEN STATUS = 'SALE' THEN '판매중'
             WHEN STATUS = 'RESERVED' THEN '예약중'
             WHEN STATUS = 'DONE' THEN '거래완료'
         END AS STATUS
 
  FROM USED_GOODS_BOARD
 WHERE TO_CHAR(CREATED_DATE,'yyyymmdd') = '20221005'
 ORDER BY BOARD_ID DESC;