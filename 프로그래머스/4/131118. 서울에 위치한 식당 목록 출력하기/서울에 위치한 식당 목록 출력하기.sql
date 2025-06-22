-- 코드를 입력하세요
SELECT info.rest_id, info.rest_name, info.food_type, info.favorites, info.address, ROUND(AVG(review.review_score), 2) as 'avg_score'
FROM rest_info as info
INNER JOIN rest_review as review
    ON info.rest_id = review.rest_id
WHERE info.address like '서울%'
GROUP BY info.rest_id
ORDER BY avg_score desc, info.views desc