import java.util.Arrays;

class Solution23 {
    public int[] solution(long n) {
        String N = String.valueOf(n);
        int[] answer = new int[N.length()];
        String[] split = N.split("",N.length());
        for(int i = 0; i < N.length(); i++){
            answer[i] = Integer.parseInt(split[N.length()-(i+1)]);
        }
        return answer;
    }
}
public class Test23 {
    public static void main(String[] args) {
        Solution23 sol = new Solution23();
        int[] result = sol.solution(12345);
        System.out.println(Arrays.toString(result));
    }
}
