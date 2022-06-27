import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution14 {
    public List<Integer> solution(int[] arr, int divisor) {
        Arrays.sort(arr,0,arr.length);
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) if (i % divisor == 0) answer.add(i);
        if(answer.size() == 0)answer.add(-1);

        return answer;
    }
}
public class Test14 {
    public static void main(String[] args) {
        Solution14 sol = new Solution14();
        List<Integer> result = sol.solution(new int[]{3,2,6},10);
        System.out.println(result);

    }
}
