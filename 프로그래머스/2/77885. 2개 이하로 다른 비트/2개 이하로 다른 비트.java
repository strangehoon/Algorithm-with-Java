class Solution {
    // 문제 유형 : 그리디, 시간복잡도 :O(n)
    public long[] solution(long[] numbers) {
        long[] answers = new long[numbers.length];
        
        for(int i=0, len=numbers.length; i<len; i++){
            String str = '0'+Long.toString(numbers[i], 2);
            StringBuilder sb = new StringBuilder();
            // 2진수 1의 자릿수부터 시작하여 '0'을 발견할때까지 탐색, '0'을 발견하면 '1'로 변환
            for(int j=str.length()-1; j>=0; j--){
                if(str.charAt(j)=='0'){
                    sb.append(str.substring(0, j)).append('1');
                    // '1'로 변환한 자릿수 바로 오른편에 있는 '1'을 '0'로 변환
                    if(j!=str.length()-1){
                        sb.append('0').append(str.substring(j+2, str.length()));
                    }
                    break;
                }
            } 
            answers[i] = Long.parseLong(sb.toString(), 2);
        }
        
        return answers;
    }
}