import java.text.DecimalFormat;

class Solution8{
    public double solution(int[] arr){
        double answer = 0;
        int len = arr.length;
        double sum = 0;
        for(int i = 0; i < len; i++){
            sum += arr[i];
        }
        answer = sum/len;
        return answer;
    }
}

public class Test8 {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        DecimalFormat df = new DecimalFormat("#.#");
        double result = sol.solution(new int[]{1,2,3,4});
        System.out.println(df.format(result));
    }
}
