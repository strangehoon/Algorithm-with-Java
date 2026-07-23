class Solution {
    // 1) 먼저 앞에 0 더미값 채우기
    // 2) 이분탐색? 분할정복 같은 느낌으로 절반씩 쪼개 가면서 해당 노드가 0인지 확인
    // 3) 만약 0이고 자식 중에 1인게 있으면 false
    // 4) 기본은 true
    
    public boolean fuc(String str){
        
        int len = str.length();
        String leftStr = str.substring(0, len/2);
        String rightStr = str.substring(len/2, len);
        
        if(str.charAt(len/2)=='0'){
            if(leftStr.charAt(leftStr.length()/2)=='1'){
                return false;
            }
            if(rightStr.charAt(rightStr.length()/2)=='1'){
                return false;
            }
        }
        if(leftStr.length()>2 && (!fuc(leftStr) || !fuc(rightStr))){
            return false;
        }
        return true;
    }
    
    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            String str = Long.toString(numbers[i], 2);
        
            int init = 1;
            while(true){
                if(str.length()<=init){
                    while(init-str.length()>0){
                        str = "0" + str;
                    }
                    break;
                }   
                else{
                    init=2*init+1;
                }
            }
            boolean flag = fuc(str);
            answer[i] = flag==true ? 1 : 0;
        }
        return answer;
    }
}