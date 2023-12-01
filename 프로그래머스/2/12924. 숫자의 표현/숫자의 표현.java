class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n<3){
            return 1;
        }
        
        int left = 1;
        int right = 2;
        int sum = 3;
        while(left <= right){
            if(sum < n){
                sum += ++right;
            } else if(sum > n){
                sum -= left++;
            } else{
                answer++;
                sum -= left++;
            }
        }
        return answer;
    }
}