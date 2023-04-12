import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> BlockMap = new HashMap<String,Integer>();   // 유저-차단당한 횟수
        Map<String, ArrayList<String>> ReportMap = new HashMap<>();     // 유저-차단한 유저리스트

        // 차단 중복 제거 
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        // Map 초기화
        for(String u:id_list){
            BlockMap.put(u,0);
            ReportMap.put(u,new ArrayList<>());
        }

        for(String r:report){
            String user=r.split(" ")[0];
            String block= r.split(" ")[1];

            // 유저-차단한 유저리스트 갱신
            ArrayList<String> list =ReportMap.get(user);
            list.add(block);
            ReportMap.put(user,list);

            // 차단 횟수 갱신
            BlockMap.put(block , BlockMap.get(block) + 1);
        }

        for(int i=0;i<id_list.length;i++){
            // 각 유저의 차단 리스트
            List<String> repList=ReportMap.get(id_list[i]);
            
            for(String user:repList){
                // 차단한 유저가 이용 정지면 메일 개수 추가
                if(BlockMap.get(user)>=k) answer[i]++;
            }
        }

        return answer;
    }
}