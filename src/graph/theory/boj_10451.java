package graph.theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 순열사이클을 구하는문제이다.
 * 2. 사이클이 발생하면 dfs를 수행하였을때 모든값들이 check가 되어있을것이다. 따라서, 매번 순회할때마다 체크가 안된지점만 확인을 하면 최종적으로 몇개의 사이클이 만들어지는지를 알 수 있다.
 * 테스트케이스로 3, 2, 7, 8, 1, 4, 5, 6일 경우 1~N까지의 수가 매칭이 되어 트리가 생성되는것을 알아야한다.
 */
public class boj_10451 {
    static boolean[] isChecked;
    static List<List<Integer>> graphList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            isChecked = new boolean[n+1];
            String[] input = br.readLine().split(" ");
            graphList = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graphList.add(new ArrayList<>());
            }
            for(int i=0; i<input.length; i++){
                int x = i+1;
                int y = Integer.parseInt(input[i]);
                graphList.get(x).add(y);
                graphList.get(y).add(x);
            }
            int cnt = 0;
            for(int i=1; i<=n; i++){
                if(!isChecked[i]) {
                    findParent(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
            Arrays.fill(isChecked,false);
        }
    }

    private static void findParent(int x) {
        isChecked[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isChecked[y]){
                findParent(y);
            }
        }
    }
}
