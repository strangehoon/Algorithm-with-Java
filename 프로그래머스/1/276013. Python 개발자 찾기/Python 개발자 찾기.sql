-- 코드를 작성해주세요
SELECT id, email, first_name, last_name
FROM developer_infos
WHERE skill_1 = 'Python' || skill_2 = 'Python' || skill_3 = 'Python'
ORDER bY id