import java.util.Arrays;

class Solution11 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(long i = 0; i < n; i++){
            answer[(int) i] = (i+1) * x;
        }
        return answer;
    }
}
public class Test11 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        long[] result = sol.solution(11,9);
        System.out.println(Arrays.toString(result));
    }
}
