// int 형 오버플로우 방지를 위해 피보나치수를 구할 때 1234567로 나눈 나머지를 저장한다
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fibo = new int[n+1];
        
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i < n+1; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        
        return fibo[n] ;
    }
}