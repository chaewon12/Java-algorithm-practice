class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int minLevel = 1;
        int maxLevel = diffs[0];
        // diffs 배열을 순회하면서 가장 큰 값을 찾음
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > maxLevel) {
                maxLevel = diffs[i];
            }
        }
        
        // level 이진 탐색
        while (minLevel <= maxLevel) {
            int level = (minLevel + maxLevel)/2;
            long totalTime = calcTotalTime(diffs, times, level);

            if (totalTime <= limit) {
                answer = level;
                maxLevel = level - 1;
            } else {
                minLevel = level + 1;
            }
        }
        
        return answer;
    }
    
    private long calcTotalTime(int[] diffs, int[] times, int level){
        long totalTime = times[0];
            
        for(int i = 1; i < diffs.length; i++){
            totalTime += solve(diffs[i], times[i], times[i-1], level);
        }
        
        return totalTime;
    }
    
    private long solve(int diff, int time_cur, int time_prev, int level){
        if(diff <= level){
            return (long) time_cur;
        }
        
        return (long) (time_cur + time_prev) * (diff - level) + time_cur;  
    }
}