import java.text.DecimalFormat;

class Solution8{
    public double solution(int[] arr){
        double answer = 0;
        int len = arr.length;
        double sum = 0;
        for (int i : arr) sum += i;
        answer = sum/len;
        return answer;
    }
}

public class Algorithm8 {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        DecimalFormat df = new DecimalFormat("#.#"); //정수일 때 소수점 안 나오도록
        double result = sol.solution(new int[]{1,2,3,4});
        System.out.println(df.format(result));
    }
}
