class Solution6{
    public Object solution(int[] numbers){
       int len = numbers.length;
       String answer = "";
       int total = 45;
       int sum = 0;
        if(len >= 1 && len <= 9){
            for(int i = 0; i < len; i++){
                int num1 = numbers[i];
                if(numbers[i] >= 0 && numbers[i] <= 9){
                    total -= numbers[i];
                }else{
                    return answer = "0~9까지만 입력할 수 있습니다.";
                }
            }
        }else{
            return answer="9개까지만 입력할 수 있습니다.";
        }
        return total;
    }
}

public class Test6 {
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        int[] numbers = new int[] {5,8,4,0,6,7,9};
        Object result = sol.solution(numbers);
        int length = numbers.length;
        boolean isReduplicate = false;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < i; j++){
                if(numbers[i] == numbers[j]) {
                    isReduplicate = true;
                    //중복 체크
                }
            }
        }
        if(isReduplicate == true){
            System.out.println("중복된 값이 있습니다.");
        }else{
            System.out.println(result);
        }
    }
}