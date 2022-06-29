import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//class Solution26 {
//    public Integer[] solution(Integer[] arr) {
//        Arrays.sort(arr, Collections.reverseOrder());
//        Integer[] answer = {};
//        if(arr.length > 2){
//            answer = new Integer[arr.length-1];
//            System.arraycopy(arr, 0, answer, 0, arr.length-1);
//        }else if(arr.length > 0) answer = new Integer[]{-1};
//        return answer;
//    }
//}
//public class Test26 {
//    public static void main(String[] args) {
//        Solution26 sol = new Solution26();
//        Integer[] result = sol.solution(new Integer[]{1,2,3,4});
//        System.out.println(Arrays.toString(result));
//    }
//}
class Solution26 {
        public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if(arr.length == 1) answer = new int[]{-1};
        int i = 0;
        int min = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[i] > arr[j]) i = j;
        }
        min = arr[i];
        for(i = 0; i < arr.length; i++){
            if(arr[i] == min) continue;
            answer[i] = arr[i];
        }
        return answer;
    }
}

public class Test26 {
    public static void main(String[] args) {
        Solution26 sol = new Solution26();
        int[] result = sol.solution(new int[]{5, 2, 3, 4, 1});
        System.out.println(Arrays.toString(result));
    }
}
