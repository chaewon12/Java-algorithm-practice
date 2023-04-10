import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length;i++) {
            int requiredDay =(int)Math.ceil((double)(100-progresses[i])/speeds[i]); // ceil 올림
            queue.add(requiredDay);
        }

        while(!queue.isEmpty()){
            int cnt=0;
            int work=queue.remove();
            cnt++;

            while (!queue.isEmpty() && queue.peek()<=work){
                queue.remove();
                cnt++;
            }
            answer.add(cnt);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}