-- 중고거래 게시물을 3건 이상 등록한 사용자의 사용자 id, 닉네임, 전체주소, 전화번호 조회
-- 전체 주소 시, 도로명 주소, 상세 주소, 전화번호 xxx-xxxx-xxxx 하이폰 삽입하여 출력
-- 회원 id 내림.
SELECT u.USER_ID, u.NICKNAME, concat(u.CITY, concat(' ' , concat(u.STREET_ADDRESS1, concat(' ', u.STREET_ADDRESS2)))) as 전체주소
, REGEXP_REPLACE(u.tlno, '(.{3})(.+)(.{4})', '\1-\2-\3') as 전화번호 
  from (select writer_id, count(*) as cnt
          from USED_GOODS_BOARD
         group by writer_id) b, USED_GOODS_USER u
 where 1 = 1
   and b.WRITER_ID = u.USER_ID
   and b.cnt >= 3
 order by u.USER_ID desc
         
         
         
         
    -- select writer_id, count(*)
    --       from USED_GOODS_BOARD
    --      group by writer_id
         
         
         