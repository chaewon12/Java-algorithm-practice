import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> bridge = new LinkedList<>();

        // 초기의 빈 다리
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int idx = 0;
        int currWeight = 0;
        while (idx < truck_weights.length) {
            currWeight -= bridge.poll();  // 트럭 내려감

            int newTruck = truck_weights[idx];
            if (currWeight + newTruck <= weight) { // 트럭 이동 & 새 트럭 올라감
                bridge.offer(newTruck);
                currWeight += newTruck;
                idx++;
            } else { // 트럭 이동
                bridge.offer(0);
            }
            time++; // 시간 증가
        }

        // 마지막 트럭이 내려오는 시간 = 다리의 길이
        return time + bridge_length;
    }
}