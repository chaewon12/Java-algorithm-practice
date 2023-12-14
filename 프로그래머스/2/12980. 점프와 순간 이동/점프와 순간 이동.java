import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n != 0)
        {
            if (n % 2 != 0) {   // 점프
                n--;
                ans++;
            }
            else{    // 순간이동
                 n /= 2;
            }
               
        }

        return ans;
    }
}