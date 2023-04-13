class Solution {
    public long solution(int price, int money, int count) {
        long pay=money;
        for(int i=1;i<=count;i++){
            pay-=price*i;
        }
        return pay<0?-pay:0;
    }
}