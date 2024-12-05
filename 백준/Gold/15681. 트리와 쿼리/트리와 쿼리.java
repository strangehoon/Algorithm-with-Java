import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static List<List<Integer>> graph;
    public static List<List<Integer>> tree;
    public static int[] size;
    
    public static void makeTree(int currentNode, int parent){
        for(int node : graph.get(currentNode)){
            if(node != parent){
                tree.get(currentNode).add(node);
                makeTree(node, currentNode);
            }
        }
    }

    public static void countSubtreeNodes(int currentNode){
        size[currentNode] = 1;
        for(int node : tree.get(currentNode)){
            countSubtreeNodes(node);
            size[currentNode] += size[node];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int R = Integer.valueOf(st.nextToken());
        int Q = Integer.valueOf(st.nextToken());

        graph = new ArrayList<>();
        tree = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }
        size = new int[N+1];

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        for(int i=0; i<Q; i++){
            int U = Integer.valueOf(br.readLine());
            bw.write(String.valueOf(size[U])+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}