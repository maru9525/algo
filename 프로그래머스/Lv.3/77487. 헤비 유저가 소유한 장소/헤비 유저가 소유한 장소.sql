-- 공간 둘 이상 등록한 사람 = '헤비유저' host_id 2개 이상
-- 공간의 정보를 아이디 순으로 오름
 SELECT a.ID, a.NAME, b.HOST_ID
 From PLACES a, (select count(*), HOST_ID
               from PLACES
              where 1 = 1
              group by HOST_ID
              having count(*) >= 2) b
 where 1 = 1
  and a.HOST_ID = b.HOST_ID
 order by a.ID 



