-- 코드를 입력하세요
SELECT flavor
FROM first_half
GROUP BY FLAVOR
ORDER BY SUM(total_order) desc, shipment_id