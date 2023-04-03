class Solution {
    public String solution(String s) {
        String answer = "";

        String[] splits=s.split(" ",-1);
        
        for(int i=0;i<splits.length;i++){  
            if(splits[i].length() == 0) answer+= " "; 
            else{               
                if(i>0) answer+=" "; // 단어 사이 공백
                
                answer+=splits[i].substring(0, 1).toUpperCase() 
                    +splits[i].substring(1).toLowerCase();
            }  
        }
        return answer;
    }
}