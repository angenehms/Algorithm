-- 코드를 입력하세요
SELECT count(user_id) as users
from USER_INFO 
where age between 20 and 29 and joined like '2021%';

# SELECT COUNT(*) AS USERS
# FROM USER_INFO
# WHERE JOINED LIKE '2021%' AND
#     AGE >= 20 AND AGE <= 29;
