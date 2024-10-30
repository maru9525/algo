-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역
-- 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
-- 진료예약일시를 기준으로 오름차순
-- PATIENT, DOCTOR 그리고 APPOINTMENT
SELECT A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
  FROM PATIENT P, DOCTOR D, APPOINTMENT A
 WHERE 1 = 1
   AND P.PT_NO = A.PT_NO
   AND D.dr_id = A.MDDR_ID
   AND A.APNT_CNCL_YN = 'N'
   AND TO_CHAR(A.APNT_YMD,'YYYYMMDD') = '20220413'
   AND A.MCDP_CD = 'CS'
 ORDER BY APNT_YMD
  
  
  
--   SELECT * FROM APPOINTMENT
--   WHERE APNT_CNCL_YN = 'N'
--     AND TO_CHAR(APNT_YMD,'YYYYMMDD') = '20220413'
--     AND MCDP_CD = 'CS'
    
    
    -- SELECT * FROM DOCTOR