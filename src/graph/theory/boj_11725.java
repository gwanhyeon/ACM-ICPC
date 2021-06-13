package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 인접리스트로 해당되는 그래프를 연결시킨다.
 * 2. dfs로 해당되는 모든 부모의 값을 배열 갱신시킨다.
 * 예) parent[y] = x
 * 3. 최종적으로 parent에는 각 노드 2번부터 n번까지 부모의 값이 담겨져 있다.
 */
public class boj_11725 {
    static List<List<Integer>> graphList;
    static boolean[] isChecked;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graphList = new ArrayList<>();
        isChecked = new boolean[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }
        // root is 1
        findParent(1);
        for(int i=2; i<parent.length; i++){
            System.out.print(parent[i] + " ");
        }
    }

    private static void findParent(int x) {
        isChecked[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isChecked[y]){
                parent[y] = x;
                findParent(y);
            }
        }
    }
}
