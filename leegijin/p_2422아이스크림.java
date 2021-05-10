package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p_2422아이스크림 {

    static int n, m, answer;
    static boolean map[][];
    static boolean visited[];
    static int[] iceCream;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][n];
        visited = new boolean[n];
        iceCream = new int[3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = true;
            map[b][a] = true;
        }

        answer = 0;
        dfs(0, 0);

        System.out.println(answer);
    }


    public static void dfs(int index, int depth) {
        if (depth == 3) {
            if (isPossible()) {
                answer++;
            }

            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                iceCream[depth] = i;
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }


    public static boolean isPossible() {
        if (map[iceCream[0]][iceCream[1]] || map[iceCream[0]][iceCream[2]] || map[iceCream[1]][iceCream[2]]) {
            return false;
        } else {
            return true;
        }
    }
}