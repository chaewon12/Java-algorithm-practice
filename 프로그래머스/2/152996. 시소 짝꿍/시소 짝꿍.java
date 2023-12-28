import java.util.*;
/*
* 1. 이분 탐색으로 카운팅(조건에 맞는지 확인) 탐색 인덱스 상한을 구한다.
*   상한을 구하는 원리: a * 2 < b 이면 b 의 오른쪽에 위치한 것들도 다 a * 2 보다 크므로 b 오른쪽은 탐색할 가치가 없음 
* 2. 2중 for문으로 카운팅 (i 범위: weigts 길이, j 범위:i+1 ~ 1에서 구한 상한)
* 3. w[i] == w[i-1](무게가 같은 경우) 경우 중복 제거 해줘야함. count(w[i]) = count(w[i-1]) - 1
*/
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        int count = 0;
        for(int i = 0; i < weights.length - 1; i++){
            if(i > 0 && weights[i] == weights[i-1]){
                answer += --count; // weights[i-1] 의 값 - 1
                continue;
            }
            
            count = 0; // 이전 카운트 값(weights[i-1]) 초기화 
            int j = findUpper(weights, weights[i], i+1);
            for(; j > i; j--){
                if(weights[i] == weights[j] ||weights[i] * 2== weights[j] 
                   || weights[i] * 3 == weights[j] * 2 || weights[i] * 4 == weights[j] * 3){
                    count++;
                }
            }
            answer += count;
        }
        
        return answer;
    }
    
    public int findUpper(int[] w, int target, int start){
        int left = start;
        int right = w.length - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(w[mid] > target*2){
                return mid;
            }
            
            left = mid+1;
        }
        
        return left;
    }
}