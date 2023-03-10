SELECT MONTH(START_DATE) MONTH, CAR_ID, COUNT(*) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY  C1
NATURAL JOIN (
    SELECT CAR_ID, COUNT(*) CAR_RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE MONTH(START_DATE) IN (8, 9, 10)
    GROUP BY CAR_ID
    ORDER BY CAR_ID DESC) C2
WHERE C2.CAR_RECORDS >= 5 AND MONTH(START_DATE) IN (8, 9, 10)
GROUP BY CAR_ID, MONTH(START_DATE)
ORDER BY MONTH ASC, CAR_ID DESC;