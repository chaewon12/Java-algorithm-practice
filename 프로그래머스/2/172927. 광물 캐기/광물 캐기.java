import java.util.*;

class Solution {
    class MineralGroup {
        int[] fatigue;

        public MineralGroup(int dia, int iron, int stone) {
            fatigue = new int[]{dia, iron, stone};
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int digable = (picks[0] + picks[1] + picks[2]) * 5;
        List<MineralGroup> mineralGroups = getMineralGroups(minerals, digable);

        // 돌 곡괭이 기준 내림차순 정렬
        mineralGroups.sort((o1, o2) -> o2.fatigue[2] - o1.fatigue[2]);

        // 다이아 - 철 - 돌 순으로 곡괭이 사용
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (mineralGroups.isEmpty()) {
                    return answer;
                }

                MineralGroup remove = mineralGroups.remove(0);
                answer += remove.fatigue[i];
            }
        }
        return answer;
    }

    // 5개씩 묶고 각 곡괭이 사용 시 피로도 계산
    private List<MineralGroup> getMineralGroups(String[] minerals, int digable) {
        List<MineralGroup> mineralGroups = new ArrayList<>();
        int chunkSize = 5;
        int arrayLength = Math.min(minerals.length, digable);

        for (int i = 0; i < arrayLength; i += chunkSize) {
            int dia = 0, iron = 0, stone = 0;
            int endIdx = Math.min(i + chunkSize, arrayLength);

            for (int j = i; j < endIdx; j++) {
                switch (minerals[j]) {
                    case "diamond":
                        dia += 1;
                        iron += 5;
                        stone += 25;
                        break;
                    case "iron":
                        dia += 1;
                        iron += 1;
                        stone += 5;
                        break;
                    case "stone":
                        dia += 1;
                        iron += 1;
                        stone += 1;
                        break;
                }
            }
            
            mineralGroups.add(new MineralGroup(dia, iron, stone));
        }

        return mineralGroups;
    }
}