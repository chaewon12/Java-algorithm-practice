import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> dayQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int requiredDay = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); // ceil = 올림 함수
            dayQueue.add(requiredDay);
        }

        while (!dayQueue.isEmpty()) {
            int day = dayQueue.remove();
            int cnt = 1;

            // 배포일 이전 날짜(=동시 배포되는 작업) 카운트 
            while (!dayQueue.isEmpty() && dayQueue.peek() <= day) {
                dayQueue.remove();
                cnt++;
            }

            answer.add(cnt);
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}