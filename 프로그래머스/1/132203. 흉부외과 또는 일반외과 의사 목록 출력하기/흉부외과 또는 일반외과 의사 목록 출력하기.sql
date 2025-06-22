-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, DATE_FORMAT(hire_ymd, '%Y-%m-%d') 
FROM doctor
WHERE mcdp_cd in ('cs', 'gs')
ORDER BY hire_ymd desc, dr_name