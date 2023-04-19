import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int first = 0;
    //last는 back이 입력 되었을때 마지막 인덱스에 저장된 값을 출력하기위한 변수이지만 스택문제의 size처럼 해도 된다.
    static int last = 0;
    static int[] que;

    public static void push(int X) {
        que[last] = X;
        last++;
    }

    public static int pop() {
        if(last - first == 0) {
            return -1;
        }else {
            int P = que[first];
            first++;
            return P;
        }
    }

    public static int size() {
        return last - first;
    }

    public static int empty() {
        if(last - first == 0) {
            return 1;
        }else {
            return 0;
        }
    }

    public static int front() {
        if(last - first == 0) {
            return -1;
        }else {
            int F = que[first];
            return F;
        }
    }

    public static int back() {
        if(last - first == 0) {
            return -1;
        }else {
            int B = que[last - 1];
            return B;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        que = new int[N];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                push(Integer.parseInt(st.nextToken()));
            }
            else if(str.equals("pop")){
                sb.append(pop()).append("\n");
            }
            else if(str.equals("size")){
                sb.append(size()).append("\n");
            }
            else if(str.equals("empty")){
                sb.append(empty()).append("\n");
            }
            else if(str.equals("front")) {
                sb.append(front()).append("\n");
            }
            else if(str.equals("back")) {
                sb.append(back()).append("\n");
            }
        }

        System.out.println(sb);

    }
}
