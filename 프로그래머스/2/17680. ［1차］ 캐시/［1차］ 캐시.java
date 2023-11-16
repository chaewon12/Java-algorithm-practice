import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int hit = 1;
        int miss = 5;
        Queue<String> cache = new LinkedList<>();
        
        if(cacheSize==0){
            return cities.length * miss;
        }
        
        for(String city : cities){
            String target = city.toUpperCase();
            
            if(cache.contains(target)){
                answer+=hit;
                cache.remove(target);
                cache.add(target);
                continue;
            }
            
            answer+=miss;
            if(cacheSize <= cache.size()){
                cache.poll();
            }
            cache.add(target);
        }
        return answer;
    }
}