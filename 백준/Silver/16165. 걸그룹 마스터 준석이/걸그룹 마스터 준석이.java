import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String[]> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String team = br.readLine();
            int teamNum = Integer.parseInt(br.readLine());
            String[] teamMember = new String[teamNum];
            for(int j=0; j<teamNum; j++){
                teamMember[j] = br.readLine();
            }
            Arrays.sort(teamMember);
            map.put(team, teamMember);
        }


        boolean solved;
        for(int i=0; i<M; i++){
            String name = br.readLine();
            int opt = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            solved = false;
            if(opt == 0){
                String[] members = map.get(name);

                for (String member : members) {
                    sb.append(member + "\n");
                }
                System.out.print(sb);
            }
            else if(opt == 1){
                for (String s : map.keySet()) {
                    if(solved) break;

                    String[] members = map.get(s);

                    for (String member : members) {
                        if(member.equals(name)){
                            solved = true;
                            System.out.println(s);
                            break;
                        }

                    }
                }
            }
        }
    }

}
