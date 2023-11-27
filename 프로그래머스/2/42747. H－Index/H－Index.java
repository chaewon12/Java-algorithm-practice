import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 오름차순으로 정렬
        Arrays.sort(citations);
        
        int hIdx = citations.length; // 최대 논문 수
        
        // 인용 수(=citation)가 최대 논문 수보다 작다면 조건에 만족하지 않으므로 1 감소
        for(int citation : citations){
            if(citation>=hIdx){
                return hIdx;
            }
            hIdx--;
        }
        
        return hIdx;
    }
}