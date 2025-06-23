-- 코드를 입력하세요
SELECT outs.animal_id, outs.name
FROM animal_outs as outs
LEFT JOIN animal_ins as ins ON ins.animal_id = outs.animal_id
WHERE ins.animal_id IS NULL
ORDER BY outs.animal_id