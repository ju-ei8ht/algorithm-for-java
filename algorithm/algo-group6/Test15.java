class Solution15 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) answer += a[i] * b[i];
        return answer;
    }
}
public class Test15 {
    public static void main(String[] args) {
        Solution15 sol = new Solution15();
        int result = sol.solution(new int[]{1,2,3,4},new int[]{-3,-1,0,2});
        System.out.println(result);

    }
}
