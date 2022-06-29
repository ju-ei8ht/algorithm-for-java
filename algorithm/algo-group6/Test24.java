import java.util.Arrays;
import java.util.Collections;

class Solution24 {
    public long solution(long n) {
        long answer = 0;
        String N = String.valueOf(n);
        String[] split = N.split("",N.length());
        Arrays.sort(split, Collections.reverseOrder());
        String arr = "";
        for(int i = 0; i < N.length(); i++){
            arr += split[i];
        }
        return answer = Long.parseLong(arr);
    }
}
public class Test24 {
    public static void main(String[] args) {
        Solution24 sol = new Solution24();
        long result = sol.solution(118372);
        System.out.println(result);
    }
}
