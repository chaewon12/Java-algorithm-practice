import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> tuple = new ArrayList<>();
        
        String removedSide = s.substring(2,s.length()-2);
        List<String> elementList = Arrays.asList(removedSide.split("\\},\\{"));
        
        // 원소가 적은 순으로 정렬
        Collections.sort(elementList, Comparator.comparingInt(String::length));
        
        // 이전에 발견된 적 없는 원소 저장
        for(String element : elementList){
            for(String e : element.split(",")){
                if(!tuple.contains(e)){
                    tuple.add(e);
                }
            }
        }
        
        int[] answer = new int[tuple.size()];
        for(int i=0;i<tuple.size();i++){
            answer[i]=Integer.parseInt(tuple.get(i));
        }

        return answer;
    }
}