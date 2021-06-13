package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 촌수계산 성공출처분류 Silver II
 */

/**
 * 1. 부모자식관계를 트리형태로 나타낸다.
 * 2. 시작점으로부터 각각의 depth + 1을 늘려나가면서 몇촌 (즉, 촌수는 depth를 나타낸다.)
 * 3. DFS, BFS로 해당되는 값을 전파하면서 늘려나간다.
 * 4. isCheck변수에 해당되는 depth를 저장시키고 저장된 값이 0일경우 -1, 그게 아니면 해당되는 depth를 출력한다.
 */
public class boj_2644 {
    static List<List<Integer>> graphList;
    static int[] isCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        isCheck = new int[n+1];
        graphList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graphList.get(a).add(b);
            graphList.get(b).add(a);
        }
        dfs(x,y);
        if(isCheck[y] != 0){
            System.out.println(isCheck[y]);
        }else {
            System.out.println(-1);
        }
    }
    private static void dfs(int x, int dest){
        if(x == dest){
            return;
        }
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(isCheck[y] == 0){
                isCheck[y] = isCheck[x] + 1;
                dfs(y,dest);
            }
        }
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isCheck[start] = 0;

        while(!q.isEmpty()){
            int x = q.poll();
            if(x == end){
                break;
            }
            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(isCheck[y] == 0){
                    isCheck[y] = isCheck[x] + 1;
                    q.add(y);
                }
            }
        }
    }
}
