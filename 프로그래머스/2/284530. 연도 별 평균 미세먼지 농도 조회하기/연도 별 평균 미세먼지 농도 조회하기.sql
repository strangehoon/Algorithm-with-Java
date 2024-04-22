-- 코드를 작성해주세요
SELECT YEAR(YM) AS "YEAR", ROUND(AVG(PM_VAL1),3) AS "PM_VAL1", ROUND(AVG(PM_VAL2), 3) AS "PM_VAL2" FROM AIR_POLLUTION GROUP BY YEAR(YM) HAVING LOCATION2 = "수원" ORDER BY YM;