-- 코드를 입력하세요
SELECT COUNT(USER_ID) 
FROM USER_INFO WHERE AGE BETWEEN 20 and 29 
AND SUBSTR(JOINED, 1,4)=2021
