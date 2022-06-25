class Solution7{
    public int solution(int[] absolutes, boolean[] signs){
        int answer = 123456789;
        int sl = signs.length;
        int al = absolutes.length;
        int sum = 0;
        if(sl == al){
            for(int i = 0; i < al; i++){
                if(signs[i] == true){
                    sum += absolutes[i];
                }else{
                    sum -= absolutes[i];
                }
            }
        }
        return sum;
    }
}
public class Test7 {
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        int result = sol.solution(new int[]{1,2,3},new boolean[]{false,false,true});
        System.out.println(result);
    }
}
