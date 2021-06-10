package graph.theory;
/*
https://www.acmicpc.net/problem/1260
DFS와 BFS 분류 Silver II
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. bfs dfs 개념
 * 2. 여러개 정점을 가질경우 Collections.sort()
 * 3. 무방향 그래프
 *
 */
public class boj_1260 {
    public static boolean[] isChecked;
    public static List<List<Integer>> graphList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graphList = new ArrayList<>();
        isChecked = new boolean[n+1];

        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }
        for(int i=1; i<=n; i++){
            Collections.sort(graphList.get(i));
        }

        dfs(v);
        System.out.println();
        Arrays.fill(isChecked, false);
        bfs(v);
    }
    public static void dfs(int x){
        isChecked[x] = true;
        System.out.print(x + " ");
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isChecked[y]){
                dfs(y);
            }
        }

    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        isChecked[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(!isChecked[y]){
                    isChecked[y] = true;
                    q.add(y);
                }
            }
        }
    }
}
