class Solution25 {
    public long solution(long n) {
        long answer = 0;
        long x = (long) Math.sqrt(n);
        if((x*x) == n) answer = (x + 1) * (x + 1);
        else return -1;
        return answer;
    }
}
public class Test25 {
    public static void main(String[] args) {
        Solution25 sol = new Solution25();
        long result = sol.solution(3);
        System.out.println(result);
    }
}
