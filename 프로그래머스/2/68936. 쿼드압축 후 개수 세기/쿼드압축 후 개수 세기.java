class Solution {
    
    public void calculate(int x1, int y1, int size, int[][] arr, int[] answer){
        
        // s내부에 있는 모든 수가 같은 값인지 검사
        int std = arr[x1][y1];
        boolean flag = true;
        for(int i=x1; i<x1+size; i++){
            for(int j=y1; j<y1+size; j++){
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
            calculate(x1, y1, size/2, arr, answer);
            calculate(x1, y1+size/2, size/2, arr, answer);
            calculate(x1+size/2, y1, size/2, arr, answer);
            calculate(x1+size/2, y1+size/2, size/2, arr, answer);
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];        
        calculate(0, 0, arr.length, arr, answer);


        return answer;
    }
}
