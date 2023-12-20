import java.util.*;
class Solution {
    class Task {
        int start;  // 시:분 -> 분으로 합산하여 저장
        int playTime;
        String name;

        public Task(String name, String start, String playTime) {
            this.name = name;
            this.start = ConvertToInt(start);
            this.playTime = Integer.parseInt(playTime);
        }

        private int ConvertToInt(String time) {
            String[] split = time.split(":");
            int hour = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);

            return hour * 60 + min;
        }
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Task> todoTasks = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        Stack<Task> stoppedTasks = new Stack<>();

        for (String[] plan : plans) {
            todoTasks.add(new Task(plan[0], plan[1], plan[2]));
        }

        int currTime = 0;
        int idx = 0;
        while (!todoTasks.isEmpty()) {
            Task currTask = todoTasks.poll();

            if (todoTasks.isEmpty()) {
                answer[idx++] = currTask.name;
                continue;
            }

            Task nextTask = todoTasks.peek();

            // 다음 과제와 겹쳐 중단해야하는 경우
            if (currTask.start + currTask.playTime > nextTask.start) {
                // 다음 과제 시작 전까지의 수행시간 빼서 저장
                currTask.playTime -= nextTask.start - currTime;
                stoppedTasks.push(currTask);
            } else if (currTask.start + currTask.playTime == nextTask.start) { // 다음 과제 시작에 맞춰 끝나는 경우
                answer[idx++] = currTask.name;
            } else { // 다음 과제 시작 전에 끝나지만 시간이 남는 경우
                answer[idx++] = currTask.name;
                currTime = currTask.start + currTask.playTime;

                // 멈춘 과제가 없다면 바로 다음 과제로 넘어감
                if (stoppedTasks.isEmpty()) {
                    currTime = nextTask.start;
                    continue;
                }

                // 남는 시간 동안 멈춘 과제 수행
                while (!stoppedTasks.isEmpty()) {
                    Task replayTask = stoppedTasks.pop();

                    // 다음 과제와 겹쳐 중단해야하는 경우
                    if (currTime + replayTask.playTime > nextTask.start) {
                        // 다음 과제 시작 전까지의 수행시간 빼서 저장
                        replayTask.playTime -= nextTask.start - currTime;
                        stoppedTasks.push(replayTask);

                        break; // 다음 과제 시작을 위해 main while문으로 빠져나감
                    } else if (currTime + replayTask.playTime == nextTask.start) { // 다음 과제 시작에 맞춰 끝나는 경우
                        answer[idx++] = replayTask.name;

                        break; // 다음 과제 시작을 위해 main while문으로 빠져나감
                    } else {
                        answer[idx++] = replayTask.name;
                        currTime += replayTask.playTime;
                    }
                }
            }
            currTime = nextTask.start;
        }

        // 멈춰둔 과제
        while (!stoppedTasks.isEmpty()) {
            answer[idx++] = stoppedTasks.pop().name;
        }

        return answer;
    }
}