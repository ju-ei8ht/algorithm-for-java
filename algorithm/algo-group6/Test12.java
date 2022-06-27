class Solution12 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long expenses = 0;
        for(long i = 0; i < count+1; i++){
            expenses += (price*i);
        }
        if(expenses > money){
            answer = expenses - money;
        }
        return answer;
    }
}
public class Test12 {
    public static void main(String[] args) {
        Solution12 sol = new Solution12();
        long result = sol.solution(3,20,4);
        System.out.println(result);

    }
}
