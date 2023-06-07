class Solution {
    public long solution(int n, int[] times) {
        long answer=0;
        long left=1;
        long right=(long)times[times.length-1] * n;

        while(left<=right){
            long mid = (left+right)/2;
            long sum=0;
            for(long time:times){
                sum+=mid/time;  // mid 시간 안에 심사할 수 있는 인원 수 
            }
            
            if(n<=sum){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return answer;
    }
}