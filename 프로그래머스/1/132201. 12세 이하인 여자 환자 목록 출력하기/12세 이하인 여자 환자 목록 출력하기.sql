-- 코드를 입력하세요
-- patient 
-- 12세 이하 여자 
-- 이름, 번호, 성별코드, 나이, 전화번호
-- 전화번호 없으면 none 출력
-- 나이 내림, 환자이름 오른
SELECT PT_NAME, PT_NO, GEND_CD, AGE, nvl(TLNO, 'NONE') as TLNO
from PATIENT
where AGE <= 12
and GEND_CD = 'W'
order by AGE desc, PT_NAME
