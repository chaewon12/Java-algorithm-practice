/*
1. CTE (Common Table Expression)
WITH 절을 사용하여 쿼리의 중간 결과를 임시적으로 저장하고 참조하는 방식
재귀 CTE를 지원하여 자기 자신을 참조하는 쿼리를 만들 수 있음

파생 테이블 (Derived Table)과의 차이점은?
파생 테이블은 FROM 절 안에 서브쿼리를 사용하여 일시적인 테이블을 생성하는 방식이며,
일반적으로 단 한번만 참조가 가능. 같은 서브쿼리를 다시 사용하려면 또 작성해야 함.

2. 재귀 CTE
WITH RECURSIVE + (기저 조건 SELECT + UNION ALL + 재귀 SELECT)로 이루어지며, 
INNER JOIN을 통해 이전 결과를 기반으로 반복적으로 데이터를 확장해 나간다

재귀 CTE는 이전 단계에서 찾은 결과를 기반으로 새로운 데이터를 가져오는 방식이다.
즉, 한 번 CTE에 추가된 노드는 재귀적으로 탐색할 때 다시 부모 노드로 사용되지 않음.
*/

WITH RECURSIVE hierarchy (id, parent_id, generation) AS (
    -- 기저 조건 (재귀의 시작점)
    -- 부모가 없는 최상위 데이터의 세대를 1로 지정하여 hierarchy CTE에 저장
    SELECT id, parent_id, 1 AS generation
    FROM ecoli_data
    WHERE parent_id IS NULL
    
    UNION ALL
    
     -- 재귀적으로 자식 노드 탐색하여 세대 구함
    SELECT ec.id, ec.parent_id, (hierarchy.generation + 1) AS generation
    FROM ecoli_data AS ec
    INNER JOIN hierarchy ON ec.parent_id = hierarchy.id
)

-- 원하는 generation만 필터링
SELECT id FROM hierarchy 
WHERE generation = 3
ORDER BY id ASC;