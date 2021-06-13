package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 이 문제의 가장 핵심포인트는 비행기의 종류를 구하는것이다.
 * 1. 비행기의 종류를 구하는것이 결국 간선의 개수가 몇개인것인지에 대한 문제이다. 즉, n-1이다
 * 2. 다른방식으로는 bfs로 체크되지 않은정점과 값이 있는 정점을 방문할 수 있을때마다 answer를 카운팅시켜주면서 가능한 모든 비행기 종류를 체크합니다.
 */
public class boj_9372 {
    static int INF = (int)1e9;
    static int[][] map;
    static boolean[] isChecked;
    static int n,m;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            isChecked = new boolean[n+1];
            answer = 0;
            map = new int[n+1][n+1];
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    map[i][j] = INF;
                    if(i == j) map[i][j] = 0;
                }
            }
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                map[y][x] = 1;
            }
            bfs();
            System.out.println(answer-1);
        }
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isChecked[1] = true;
        while(!queue.isEmpty()) {
            answer++;
            int x = queue.poll();
            for(int i=1; i<=n; i++) {
                if(map[x][i]!=0 && !isChecked[i]) {
                    isChecked[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
