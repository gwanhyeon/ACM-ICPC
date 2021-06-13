package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 플로이드 워셜 알고리즘
 * 2. 11403번 경로찾기와 다르게 최단 경로의 비용을 구하는 문제이다.
 * 예를들면, 1번 노드에서 -> 2번, 3번, 4번, 5번 ,6번을 거쳐간 비용의 총합이다. 단순히 경로찾기문제는 비용이 문제가 아니라 해당되는값이 존재하는지 안존재하는지 여부만 찾았다.
 * 3. 자기 자신의 값을 0으로 초기화하고 나머지 모든값을 (int)1e9 로 초기화하였다. 최단경로 즉, 최소비용을 구해야하므로 이렇게 초기화시켜준것이다.
 * 4. 한번 이동할때의 최소비용은 1이므로 입력시 주어진 맵을 1로 갱신하였다.
 * 5. 거쳐갈수있는 모든경로를 아래와 같이 초기화 하였다.
 * if(map[i][k] + map[k][j] < map[i][j]){
 *        map[i][j] = map[i][k] + map[k][j];
 * }
 */
public class boj_1389 {
    static int INF = (int)1e9;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int answer = INF;
        int idx = -1;
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=1; j<=n; j++){
                sum += map[i][j];
            }
            if(answer > sum){
                answer = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
