import java.util.*;

class Solution {
    static Set<String> result = new HashSet<>();

    public String[] solution(String[] orders, int[] course) {
        for (int size : course) {
            Map<String, Integer> candidateMap = new HashMap<>();    // 각 size 별 후보 코스

            // orders를 돌면서 생성 가능한 size 길이의 코스의 주문 수 카운트 => candidateMap
            for (String order : orders) {
                if (order.length() >= size) {
                    String[] orderArr = order.split("");
                    Arrays.sort(orderArr);

                    Set<String> courseSet = new HashSet<>();
                    courseByOrder(orderArr, new boolean[order.length()], "", size, 0, courseSet);

                    // 하나의 각 order에서 생성된 조합을 candidateMap에서 찾아 주문 수 1 증가
                    for (String s : courseSet) {
                        candidateMap.put(s, candidateMap.getOrDefault(s, 0) + 1);
                    }
                }
            }

            // candidateMap에 저장된 코스 중 조건을 만족하는 것만 result에 저장 
            finalChoice(candidateMap);
        }

        return result.stream().sorted().toArray(String[]::new);
    }

    private static void finalChoice(Map<String, Integer> courseMap) {
        // 주문 수가 2 이상인 최대 값을 찾기
        Optional<Integer> maxOptional = courseMap.values().stream()
                .filter(value -> value >= 2)
                .max(Integer::compare);

        // 최대 값이 존재하면 해당 값을 가지는 키만 result에 추가
        maxOptional.ifPresent(maxValue -> {
            courseMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxValue)
                    .forEach(entry -> result.add(entry.getKey()));
        });
    }

    // 순서에 상관없이 중복되지 않는 조합 생성
    private void courseByOrder(String[] order, boolean[] visited, String comb, int size, int index, Set<String> courseSet) {
        if (comb.length() == size) {
            courseSet.add(comb);
        }

        for (int i = index; i < order.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                courseByOrder(order, visited, comb + order[i], size, i, courseSet);
                visited[i] = false;
            }
        }
    }
}