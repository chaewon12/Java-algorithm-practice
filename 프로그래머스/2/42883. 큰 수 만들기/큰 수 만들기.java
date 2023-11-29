import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        int remain = len - k; // 남겨야 하는 숫자의 개수

        // 스택(그리디)을 이용하여 가장 큰 수를 만들기
        char[] result = new char[remain];
        int top = -1; // 스택의 top을 나타내는 인덱스

        for (int i = 0; i < len; i++) {
            char curr = number.charAt(i);

            // 스택이 비어있지 않고, 스택의 top이 현재 숫자보다 작으면 pop
            while (top >= 0 && result[top] < curr && k > 0) {
                top--;
                k--;
            }

            // 스택에 현재 숫자 push
            if (top < remain - 1) {
                result[++top] = curr;
            }
        }

        return new String(result);
    }
}