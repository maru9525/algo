-- 2021, 인문
-- 도서id, 출판일 출력
-- 출판일 기준 오름
SELECT BOOK_ID, to_char(PUBLISHED_DATE, 'yyyy-mm-dd') as PUBLISHED_DATE
  from BOOK
 where 1 = 1
   and to_char(PUBLISHED_DATE, 'yyyy') = '2021'
   and CATEGORY = '인문'
 order by PUBLISHED_DATE 