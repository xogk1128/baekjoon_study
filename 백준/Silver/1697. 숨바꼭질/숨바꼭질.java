import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[200001];
    static StringBuilder sb = new StringBuilder();
    static int L = 0;
    static int bfs(int startNode, int endNode){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(startNode);
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int node = Q.poll();
                if(node == endNode)
                    return L;
                if(node-1 >=0 && !visited[node-1]){
                    Q.offer(node-1);
                    visited[node-1] = true;
                }
                if(node+1 <= 200000 && !visited[node+1]){
                    Q.offer(node+1);
                    visited[node+1] = true;
                }
                if(node*2 <= 200000 && !visited[node*2]){
                    Q.offer(node*2);
                    visited[node*2] = true;
                }
            }

            L++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(bfs(start, end));
    }
}
