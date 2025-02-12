class Solution {
    // 16:50
    
    public boolean check(int[][] graph, int[][] lock, int keyLen, int lockLen){
        
        boolean flag = true;
        for(int i=0; i<lockLen; i++){
            for(int j=0; j<lockLen; j++){
                if(graph[i+keyLen-1][j+keyLen-1]+lock[i][j]!=1){
                    flag = false;
                }
            }
        }
        return flag;
    }
    public boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        boolean flag = false;
        
        for(int i=0; i<keyLen+lockLen-1; i++){
            for(int j=0; j<keyLen+lockLen-1; j++){
                for(int k=0; k<4; k++){
                    int[][] graph = new int[keyLen+keyLen+lockLen-2][keyLen+keyLen+lockLen-2];
                    if(k==1){
                        for(int l=0; l<keyLen; l++){
                            for(int m=0; m<keyLen; m++){
                                graph[i+l][j+m] = key[l][m];
                            }
                        }
                        if(check(graph, lock, keyLen, lockLen)){
                            flag = true;
                        }
                    }
                    else if(k==2){
                        for(int l=0; l<keyLen; l++){
                            for(int m=0; m<keyLen; m++){
                                graph[i+l][j+m] = key[keyLen-1-m][l];
                            }
                        }
                        if(check(graph, lock, keyLen, lockLen)){
                            flag = true;
                        }
                    }
                    else if(k==3){
                        for(int l=0; l<keyLen; l++){
                            for(int m=0; m<keyLen; m++){
                                graph[i+l][j+m] = key[keyLen-1-l][keyLen-1-m];
                            }
                        }
                        if(check(graph, lock, keyLen, lockLen)){
                            flag = true;
                        }
                    }
                    else{
                        for(int l=0; l<keyLen; l++){
                            for(int m=0; m<keyLen; m++){
                                graph[i+l][j+m] = key[m][keyLen-1-l];
                            }
                        }
                        if(check(graph, lock, keyLen, lockLen)){
                            flag = true;
                        }
                    }
                    
                }        
            }
        }
        
        return flag;
    }
}
