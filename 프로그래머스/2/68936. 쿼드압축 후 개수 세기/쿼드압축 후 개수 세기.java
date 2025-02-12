class Solution {
    
    public void calculate(int x1, int y1, int x2, int y2, int[][] arr, int[] answer){
        
        int side = x2-x1+1;
        
        // s내부에 있는 모든 수가 같은 값인지 검사
        int std = arr[x1][y1];
        boolean flag = true;
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(arr[i][j]!=std){
                    flag = false;
                }
            }
        }
        // 압축
        if(flag){
            if(std==0)
                answer[0] +=1;
            else
                answer[1] +=1;
        }
        // 분할
        else{
            calculate(x1, y1, x1+side/2-1, y1+side/2-1, arr, answer);
            calculate(x1, y1+side/2, x1+side/2-1, y2, arr, answer);
            calculate(x1+side/2, y1, x2, y1+side/2-1, arr, answer);
            calculate(x1+side/2, y1+side/2, x2, y2, arr, answer);
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];        
        calculate(0, 0, arr.length-1, arr[0].length-1, arr, answer);


        return answer;
    }
}