class Solution {
    // 1) 먼저 앞에 0 더미값 채우기
    // 2) 이분탐색? 분할정복 같은 느낌으로 절반씩 쪼개 가면서 해당 노드가 0인지 확인
    // 3) 만약 0이고 자식 중에 1인게 있으면 false
    // 4) 기본은 true
    
    public boolean fuc(int left, int right, String str){
        int mid = (left+right)/2;
        boolean flag = true;
        if(str.charAt(mid)=='0'){
            if(str.charAt(mid-(mid-left)/2)=='1'){
                return false;
            }
            else if(str.charAt(mid+(mid+right)/2)=='1'){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            if(!fuc(left, mid, str)){
                return false;
            }
            if(!fuc(mid, right, str)){
                return false;
            }
            else{
                return true;
            }
        }
    }
    public int[] solution(long[] numbers) {
        // 1 3 7 15 31
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            String str = Long.toString(numbers[i], 2);
        
            int init = 1;
            while(true){
                if(str.length()<=init){
                    while(init-str.length()>0){
                        str += "0";
                    }
                    break;
                }   
                else{
                    init=2*init+1;
                }
            }
            
            boolean flag = fuc(0, str.length(), str);
            answer[i] = flag==true ? 1 : 0;
        }
        return answer;
    }
}

// # 7
// 111
// # 42
// 0101010
// # 5(x)
// 101
// # 63
// 0111111
// # 111
// 1101111
// # 95(x)
// 1011111

// 11011

//01010

// 0000101

// 0001000

    
// 1000000000000000

// 1111111111111