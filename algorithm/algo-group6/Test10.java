import java.util.Arrays;

class Solution10{
    public int[][] solution(int[][] arr1, int[][] arr2){
        int groupIndex = arr1.length;
        int elemIndex = arr1[0].length;
        int[][] answer = new int[groupIndex][elemIndex];
        for (int i = 0; i < groupIndex; i++){
            for (int j = 0; j < elemIndex; j++){ //i가 0일때 j는 0~elemIndex까지 ++
                answer[i][j] = arr1[i][j] + arr2[i][j];
                //arr1 = {2,3,4}{1,2,4} -> arr1[0][0] = 2, arr1[0][1] = 3 ...
            }
        }
        return answer;
    }
}

public class Test10 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        int[][] result = sol.solution(new int[][]{{1,2},{2,3}}, new int[][]{{3,4},{5,6}});
        System.out.println(Arrays.deepToString(result));
    }
}