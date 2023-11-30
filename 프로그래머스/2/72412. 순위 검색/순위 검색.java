import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static Map<String, List<Integer>> queryMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 모든 경우에 대한 점수 리스트 생성
        for (String data : info) {
            String[] parts = data.split(" ");

            // 조합할 수 있는 모든 경우의 key 구하기
            Set<String> combinationSet = new HashSet<>();
            combinationSet.add(""); // 조건이 없는 경우 ("- and - and - and -")
            generateCombinations(Arrays.copyOfRange(parts, 0, parts.length - 1), new boolean[parts.length - 1], "", combinationSet);

            // key에 점수 추가
            int score = Integer.parseInt(parts[parts.length - 1]);
            for (String key : combinationSet) {
                List<Integer> scoreList = queryMap.getOrDefault(key, new ArrayList<>());
                scoreList.add(score);
                queryMap.put(key, scoreList);
            }
        }
        
        // 각 map의 점수 리스트 정렬(아래의 점수 이분 탐색을 위함)
        queryMap.entrySet().stream().forEach(entry -> entry.getValue().sort(Integer::compareTo));

        // 쿼리 스트링에서 조건만 필터링
        for (int i = 0; i < query.length; i++) {
            // "and", "-"를 모두 제거하고 단어와 숫자만 남기기
            String[] querySplit = query[i].replaceAll("and|-", "").split("\\s+");

            String key = String.join("", Arrays.copyOfRange(querySplit, 0, querySplit.length - 1));
            int score = Integer.parseInt(querySplit[querySplit.length - 1]);

            answer[i] = getSelectedSize(key, score);
        }

        return answer;
    }

    private void generateCombinations(String[] words, boolean[] visited, String temp, Set<String> combinationSet) {
        if (!temp.isEmpty()) {
            combinationSet.add(temp);
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateCombinations(words, visited, temp + words[i], combinationSet);
                visited[i] = false;
            }
        }
    }

    private int getSelectedSize(String key, int score) {
        List<Integer> scoreList = queryMap.get(key);

        if (scoreList == null) {
            return 0;
        }

        int start = 0;
        int end = scoreList.size();
        while (start < end) {
            int mid = (start + end) / 2;

            if (scoreList.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return scoreList.size() - end;
    }
}