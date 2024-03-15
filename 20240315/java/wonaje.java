import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14570 {

    static Node[] tree;
    static int n;
    static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new Node[n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            tree[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        k = Long.parseLong(br.readLine());

        int curr = 1;
        while(true){
            if(tree[curr].left!=-1 && tree[curr].right!=-1){
                if(k%2==0) {
                    k/=2;
                    curr = tree[curr].right;
                }
                else {
                    k/=2;
                    k+=1;
                    curr = tree[curr].left;
                }
            }
            else if(tree[curr].left!=-1){
                curr = tree[curr].left;
            }
            else if(tree[curr].right!=-1){
                curr = tree[curr].right;
            }
            else{
                break;
            }
        }

        System.out.println(curr);

    }
    public static class Node{
        int left;
        int right;

        Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
