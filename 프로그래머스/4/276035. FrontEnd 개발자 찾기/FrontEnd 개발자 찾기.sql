-- 코드를 작성해주세요
select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS D
join SKILLCODES S
on S.CATEGORY = 'Front End' and (D.SKILL_CODE & S.CODE) != 0
order by ID