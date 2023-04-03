import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int f=0;
        int l=people.length-1;  
        
        Arrays.sort(people);
        
        while(f<=l){
            if(f==l){   // 한 명만 남은 경우
                ++answer;  
                break;
            }
            else{
                int total=people[f]+people[l];
                if(total<=limit){
                    ++f;
                    --l;
                    ++answer;              
                }
                else{
                    --l;
                    ++answer;
                }
            } 
        };
        return answer;
    }
}