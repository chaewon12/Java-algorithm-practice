import java.util.HashSet;
import java.util.Set;

class Solution {
    static String[][] relationArr;
    static int rowSize;

    public int solution(String[][] relation) {
        relationArr = relation;
        rowSize = relation[0].length;

        // 속성을 인덱스로 저장
        String[] attributes = new String[rowSize];
        for (int i = 0; i < rowSize; i++) {
            attributes[i] = Integer.toString(i);
        }

        // 모든 조합 생성
        Set<String> combinations = new HashSet<>();
        generateCombinations(attributes, 0, new StringBuilder(), combinations);


        // 유일성 필터링
        Set<String> filteredCombinations = filterUniqueness(combinations);

        // 최소성 필터링
        filteredCombinations = filterMinimality(filteredCombinations);

        return filteredCombinations.size();
    }

    // 모든 조합 생성
    private static void generateCombinations(String[] attributes, int index, StringBuilder currentComb, Set<String> combinations) {
        // 현재 조합 추가
        if (currentComb.length() > 0) {
            combinations.add(currentComb.toString());
        }

        // 재귀적으로 다음 요소 선택
        for (int i = index; i < attributes.length; i++) {
            currentComb.append(attributes[i]);
            generateCombinations(attributes, i + 1, currentComb, combinations);
            currentComb.deleteCharAt(currentComb.length() - 1);
        }
    }


    // 유일성 필터링
    private static Set<String> filterUniqueness(Set<String> combinations) {
        Set<String> filteredCombinations = new HashSet<>();
        for (String indexStr : combinations) {
            if (isUnique(indexStr)) {
                filteredCombinations.add(indexStr);
            }
        }

        return filteredCombinations;
    }

    // 유일성 체크
    private static boolean isUnique(String indexStr) {
        Set<String> set = new HashSet<>();

        for (String[] row : relationArr) {
            StringBuilder builder = new StringBuilder();
            for (char c : indexStr.toCharArray()) {
                builder.append(row[Integer.parseInt(String.valueOf(c))]).append("?");
            }

            if (!set.add(builder.toString())) {
                return false;
            }

            set.add((builder.toString()));
        }

        return true;
    }

    // 최소성 필터링
    private static Set<String> filterMinimality(Set<String> combinations) {
        Set<String> filteredCombinations = new HashSet<>();

        for (String combination : combinations) {
            boolean isMinimal = true;

            // 현재 조합의 각 자리를 확인하여 최소성 검사
            for (int i = 0; i < combination.length(); i++) {
                // i번째 문자를 제외한 부분집합이 combinations에 존재하면 최소성 위배
                String subset = combination.substring(0, i) + combination.substring(i + 1);

                if (combinations.contains(subset)) {
                    isMinimal = false;
                    break;
                }
            }

            if (isMinimal) {
                filteredCombinations.add(combination);
            }
        }

        return filteredCombinations;
    }
}