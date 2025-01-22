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

