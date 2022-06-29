class Solution28{
    public boolean solution(int x){
        boolean answer = false;
        String X = String.valueOf(x);
        String[] split = X.split("",X.length());
        int sum = 0;
        for(int i = 0; i < X.length(); i++){
            sum += Integer.parseInt(split[i]);
        }
        if(x % sum == 0) answer = true;
        return answer;
    }
}

public class Test28 {
    public static void main(String[] args) {
        Solution28 sol = new Solution28();
        boolean result = sol.solution(13);
        System.out.println(result);
    }
}
