package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 양방향그래프가 아닌 단방향그래프인것을 파악하여 연결된 해킹의 컴퓨터개수를 구하는 문제였습니다.
 * 2. 처음에 양방향 그래프로 생각을 하여서 a->b, b->a에 대한 양방향 설정을 진행하였는데, 올바른 결과가 나오지 않았습니다.
 * 문제를 다시 잘 읽어보니 B의 컴퓨터를 통해 A의 컴퓨터를 해킹을 할 수 있습니다. 즉, B->A로의 해킹이 가능해집니다.
 * 따라서, 양방향 그래프가 아닌 단방향 그래프로 DFS를 통하여 문제를 해결하였습니다.
 * 3. 최근에 효율적인 해킹문제가 재채점되면서 동작되던 코드가 시간초과가 발생하는 문제가 생겼습니다.
 * 아마도 큐의 비용적인 측면에서 문제가 생기고 있지 않나 라는 생각을 합니다. 혹시라도 Java에서 시간초과를 해결하신분이 있다면 답글부탁드리겠습니다^^
 */
public class boj_1325 {
    static List<List<Integer>> graphList;
    static boolean[] isCheck;
    static int answer = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graphList = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(y).add(x);
        }
        isCheck = new boolean[n+1];
        List<Integer> hackingList = new ArrayList<>();
        for(int i=1; i<=n; i++){
            Arrays.fill(isCheck, false);
            bfs(i);

            if(answer == cnt){
                hackingList.add(i);
            }else if(answer < cnt){
                answer = cnt;
                hackingList.clear();
                hackingList.add(i);
            }
            cnt = 0;

        }
        Collections.sort(hackingList);

        for (Integer hack : hackingList) {
            System.out.print(hack + " ");
        }
    }

    private static void dfs(int x) {
        isCheck[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isCheck[y]){
                cnt++;
                dfs(y);
            }
        }
    }
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isCheck[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(!isCheck[y]){
                    cnt++;
                    isCheck[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
