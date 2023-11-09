import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer=0;
        int end=0;

        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]); //e 오름차순

        for (int i=0; i<targets.length; i++){
            int s = targets[i][0];
            int e = targets[i][1];

            if(s<end){
                continue;
            }
            
            end=e;
            answer++;
        }
        return answer;
    }
}
