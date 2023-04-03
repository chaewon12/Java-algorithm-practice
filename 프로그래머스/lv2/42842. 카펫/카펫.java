class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total,r,c;
        
        total=brown+yellow;
        
        for(r=3;;r++){
            if(total%r==0){
                c=total/r;
                if(c>=3 && r>=c){
                    if(brown==2*(r+c-2)) break;
                    else continue;
                }
                else continue;
            }
            else continue;      
        }
        
        answer[0]=r;
        answer[1]=c;
        return answer;
    }
}