-- 2022.05에 예약한 환자 수, 진료과코드 별로
-- 진료과별 예약한 환자수 오름, 진료과 코드 오름
SELECT MCDP_CD AS 진료과코드, count(*) AS "5월예약건수"
from APPOINTMENT 
where 1 = 1
 and to_char(APNT_YMD, 'yyyymm') = '202205'
--and APNT_CNCL_YN = 'N'
group by MCDP_CD
order by 2,1