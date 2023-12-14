import java.util.*;

class Solution {
    static Set<String> usedWord = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        
        //시작 단어 저장
        usedWord.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
            
            // 탈락 
            if (!isValidWord(i, words)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            
            // 통과
            usedWord.add(words[i]);
        }
        
        return answer;
    }
    
    private boolean isValidWord(int i, String[] words){
        if(words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
            return false;
        }
        
        if(usedWord.contains(words[i])){
            return false;
        }
        
        return true;
    }
}