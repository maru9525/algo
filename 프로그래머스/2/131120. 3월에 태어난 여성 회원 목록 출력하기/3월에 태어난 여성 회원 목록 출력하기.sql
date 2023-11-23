-- 코드를 입력하세요
-- 회원 id, 이름, 성별, 생년월일
-- 생일이 3월
-- 전화번호 null 제외
-- id 기준으로 오름차순
SELECT MEMBER_ID, MEMBER_NAME
    , GENDER
    , to_char(DATE_OF_BIRTH,'yyyy-mm-dd') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
where 1 = 1
and TLNO is not null
and GENDER = 'W'
and to_char(DATE_OF_BIRTH, 'MM') = '03'
order by MEMBER_ID asc