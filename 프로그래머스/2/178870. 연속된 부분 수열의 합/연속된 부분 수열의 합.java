class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = {0,n-1};
        
        int left = 0;
        int right = 1;
        int sum = sequence[0];
        
        while(left < right){
            if(sum==k){
                if(right-left-1 < answer[1]-answer[0]){
                    answer[0]=left;
                    answer[1]=right-1;
                }
                sum -= sequence[left++];
            }else if(sum>k){
                sum -= sequence[left++];
            }else if(right < sequence.length){
               sum += sequence[right++];           
            } else {                
                break;            
            }
        }
        return answer;
    }
}