class Solution27{
    public int solution(long num){
        int answer = 0;
        while (num != 1){
            if(num % 2 == 0) num /= 2;
            else num = (num * 3) + 1;
            answer++;
        }
        if(answer >= 500) return -1;
        return answer;
    }
}

public class Test27 {
    public static void main(String[] args) {
        Solution27 sol = new Solution27();
        int result = sol.solution(6);
        System.out.println(result);
    }
}
