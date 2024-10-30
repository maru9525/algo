-- 리뷰를 가장 많이 작성한 회원의 리뷰 / 회원 이름, 리뷰 텍스트, 리뷰 작성일
-- 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순
-- MEMBER_PROFILE 와 REST_REVIEW 

SELECT A.MEMBER_NAME, C.REVIEW_TEXT, TO_CHAR(C.REVIEW_DATE,'YYYY-MM-DD') AS REVIEW_DATE
  FROM MEMBER_PROFILE A, (SELECT * 
                            FROM (
                                    SELECT MEMBER_ID, COUNT(*)
                                    FROM REST_REVIEW
                                    WHERE 1 = 1
                                    GROUP BY MEMBER_ID
                                    ORDER BY COUNT(*) DESC
                                  )
                            WHERE ROWNUM = 1) B
    , REST_REVIEW C
 WHERE A.MEMBER_ID = B.MEMBER_ID
   AND A.MEMBER_ID = C.MEMBER_ID
 ORDER BY C.REVIEW_DATE, C.REVIEW_TEXT



-- SELECT * FROM (
-- SELECT MEMBER_ID, COUNT(*)
-- FROM REST_REVIEW
-- WHERE 1 = 1
-- GROUP BY MEMBER_ID
-- ORDER BY COUNT(*) DESC
-- )
-- WHERE ROWNUM = 1


-- SELECT * FROM REST_REVIEW
-- WHERE member_id = 'soso94@naver.com'
-- SELECT * FROM MEMBER_PROFILE