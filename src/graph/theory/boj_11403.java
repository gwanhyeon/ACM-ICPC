package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
모든정점에서 다른정점까지 모두 탐색할 수 있는지 판별하는 문제.
따라서 플로이드 워셜 알고리즘을 사용하면 모두 구할 수 있고 n의 범위가 100이하이기때문에 n^3 플로이드 워샬알고리즘을 써도 무방하다.
간략하게 말하자면, 플로이드 와샬 알고리즘은 모든 정점에서 모든 정점으로의 최단거리를 구하는 알고리즘입니다.
다익스트라 알고리즘이나 벨만 포드 알고리즘은 한 정점에서 다른 모든 정점의 최단거리를 구하는 것과 차이가 있죠.

 */

/**
 * 1. 가중치없는 방향그래프 G 플로이드워셜 N^3
 * 2. n = 100 이하
 * 3. i -> j, i -> k -> j 로 갈 수 있으면 1, 없으면 0
 * 4. 모든정점 -> 모든정점으로 가는 경우
 */
public class boj_11403{
    static boolean[] isCheck;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];
        isCheck = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
