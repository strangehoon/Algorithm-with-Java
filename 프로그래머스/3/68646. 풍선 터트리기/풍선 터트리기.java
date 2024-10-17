class Solution {
    public int solution(int[] a) {
        int cnt = 1;
        
        // 기준
        int totalMinValue = Integer.MAX_VALUE;
        int totalMinIdx = -1;
        for(int i=0; i<a.length; i++){
            if(totalMinValue>a[i]){
                totalMinValue = a[i];
                totalMinIdx = i;
            }
        }
        
        // 기준보다 왼쪽
        int minLeftValue = Integer.MAX_VALUE;
        for(int i=0; i<totalMinIdx; i++){
            if(a[i]<minLeftValue){
                cnt++;
                minLeftValue = a[i];
            }
        }
        
        // 기준보다 오른쪽
        int minRightValue = Integer.MAX_VALUE;
        for(int i=a.length-1; i>totalMinIdx; i--){
            if(a[i]<minRightValue){
                cnt++;
                minRightValue = a[i];
            }
        }

        return cnt;
    }
}