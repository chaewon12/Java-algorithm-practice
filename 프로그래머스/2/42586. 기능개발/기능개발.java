import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        int days = 0;
        int count = 0;

        for (int i = 0; i < progresses.length; i++) {
            int required = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]); // ceil = 올림 함수

            if (required > days) {
                days = required;
                if (count > 0) {
                    answerList.add(count);
                    count = 0;
                }
            }

            count++;
        }
        
        // 마지막 배포
         if (count > 0) {
            answerList.add(count);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}