-- 입양을 간 동물중, 보호 기간이 가장 길었던 동물 두마리
-- 아이디와 이름, 보호기간 긴 순서
SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a, (SELECT o.ANIMAL_ID
                     FROM ANIMAL_INS i, ANIMAL_OUTS  o
                    WHERE i.ANIMAL_ID = o.ANIMAL_ID
                    ORDER BY o.DATETIME - i.DATETIME desc
                   ) b
where 1 = 1
and a.ANIMAL_ID = b.ANIMAL_ID
AND ROWNUM <= 2

-- SELECT i.ANIMAL_ID, o.DATETIME - i.DATETIME
--                      FROM ANIMAL_INS i, ANIMAL_OUTS  o
--                     WHERE i.ANIMAL_ID = o.ANIMAL_ID
--                     ORDER BY o.DATETIME - i.DATETIME desc