import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] graph = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                graph[i][j] = str.charAt(j);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int firstCnt = 0;
                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){
                        if((k+l)%2==0){
                            if(graph[k][l]=='B')
                                firstCnt++;
                        }
                        else{
                            if(graph[k][l]=='W')
                                firstCnt++;
                        }
                    }
                }
                answer = Math.min(answer, firstCnt);
                int secondCnt = 0;
                for(int k=i; k<i+8; k++){
                    for(int l=j; l<j+8; l++){
                        if((k+l)%2==0){
                            if(graph[k][l]=='W')
                                secondCnt++;
                        }
                        else{
                            if(graph[k][l]=='B')
                                secondCnt++;
                        }
                    }
                }
                answer = Math.min(answer, secondCnt);
            }
        }
        System.out.println(answer);
    }
}