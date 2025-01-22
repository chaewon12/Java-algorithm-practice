/*
부모의 형질과 비트 연산 수행
& (AND): 두 비트가 모두 1일 때 1, 그렇지 않으면 0

자신의 형질들 중 부모의 형질을 반드시 가지고 있어야 한다. 
따라서 (자신 & 부모 = 부모) 이어야 한다.

ex) 
0001
0011
--> 0001

0001
0010
-> 0000
*/ 

SELECT 
    curr.ID, 
    curr.GENOTYPE, 
    parent.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA curr
JOIN ECOLI_DATA parent
    ON parent.ID = curr.PARENT_ID
       AND (curr.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE
ORDER BY curr.ID;

/*
[고민] Filtering in JOIN or WHERE ?
불필요한 데이터는 조인하지 않기 때문에 Filtering in JOIN 이 더 효율적이라고 생각한다
하지만, 지금은 필터링 조건이 하나이기 때문애 가능하다고 생각이 된다.
확장성을 고려한다면 WHERE절로 빼야할 것 같다

1. Filtering in JOIN
조인 단계에서 조건 평가 -> 불필요한 데이터 매칭 방지

JOIN ECOLI_DATA parent
    ON parent.ID = curr.PARENT_ID
       AND (curr.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE

2. Filtering in WHERE
모든 데이터 조인 후 WHERE에서 조건 평가 -> 불필요한 데이터까지 조인, 이후 필터링 필요

JOIN ECOLI_DATA parent
    ON parent.ID = curr.PARENT_ID
WHERE (curr.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE
*/
