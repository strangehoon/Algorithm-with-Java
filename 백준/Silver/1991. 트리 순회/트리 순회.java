import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        char data;
        Node leftChild;
        Node rightChild;
        public Node(char data){
            this.data = data;
        }
    }

    public static void preorder(Node node){
        if(node==null)
            return;
        System.out.print(node.data);
        preorder(node.leftChild);
        preorder(node.rightChild);
    }

    public static void inorder(Node node){
        if(node==null)
            return;
        inorder(node.leftChild);
        System.out.print(node.data);
        inorder(node.rightChild);
    }

    public static void postorder(Node node){
        if(node==null)
            return;
        postorder(node.leftChild);
        postorder(node.rightChild);
        System.out.print(node.data);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);
            if(nodes[parentValue-'A'+1]==null){
                nodes[parentValue-'A'+1]=new Node(parentValue);
            }
            if(leftValue!='.'){
                nodes[leftValue-'A'+1] = new Node(leftValue);
                nodes[parentValue-'A'+1].leftChild = nodes[leftValue-'A'+1];
            }
            if(rightValue!='.'){
                nodes[rightValue-'A'+1]= new Node(rightValue);
                nodes[parentValue-'A'+1].rightChild = nodes[rightValue-'A'+1];
            }
        }

        preorder(nodes[1]);
        System.out.println();
        inorder(nodes[1]);
        System.out.println();
        postorder(nodes[1]);
    }
}