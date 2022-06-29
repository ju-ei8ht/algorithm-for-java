import java.util.*;
class Solution22 {
    public int solution(int n) {
        int answer = 0;
        String N = String.valueOf(n);
        String[] split = N.split("",N.length());
        for(int i = 0; i < N.length(); i++) {
            answer += Integer.parseInt(split[i]);
        }
        return answer;
    }
}
public class Test22 {
    public static void main(String[] args) {
        Solution22 sol = new Solution22();
        int result = sol.solution(987);
        System.out.println(result);
    }
}
