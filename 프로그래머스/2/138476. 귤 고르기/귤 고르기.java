import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {  
       // 크기별 귤의 개수 
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // 귤 개수들을 내림차순으로 저장 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer key : map.keySet()) {
            pq.add(map.get(key));
        }
        
        // 총 귤의 개수가 k 이상일 때까지 귤 꺼냄. 귤을 꺼낸 횟수 = 귤의 종류 
        int sum = 0;
        int count = 0;
        while(sum<k){
            sum += pq.poll();
            count++;
        }
            
        return count;
    }
}