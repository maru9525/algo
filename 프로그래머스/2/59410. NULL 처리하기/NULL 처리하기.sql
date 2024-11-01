-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회
--  null -> No name
SELECT ANIMAL_TYPE, NVL(NAME, 'No name') AS NAME, SEX_UPON_INTAKE
  FROM ANIMAL_INS
 ORDER BY ANIMAL_ID