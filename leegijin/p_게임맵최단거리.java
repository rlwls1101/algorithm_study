import java.util.*;
public class p_게임맵최단거리 {
    public static void main(String[] args) {
        int [][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    static int ans = 123456789;
    public static int solution(int[][] maps) {
        int answer = 0;
        boolean[][] check = new boolean[maps.length][maps[0].length];
        //dfs(maps, 0, 0, 0, check);
        bfs(maps,check);

        if (ans == 123456789) {
            answer = -1;
        } else {
            answer = ans;
        }
        return answer;
    }

    // n*m  m이 높이 n이 너비
    static void dfs(int[][] maps, int n, int m, int cnt, boolean[][] check) {
        int x[] = {1, 0, -1, 0};
        int y[] = {0, 1, 0, -1};
        if (m == maps.length -1&& n == maps[0].length - 1) {
            ans = Math.min(ans, cnt);
        }
        for (int i = 0; i < 4; i++) {
            int n1 = n + x[i];
            int m1 = m + y[i];
            if (m1 >= 0 && m1 < maps.length && n1 >= 0 && n1 < maps[0].length) {
                if (maps[m1][n1] == 1 && !check[m1][n1]) {
                    check[m1][n1] = true;
                    dfs(maps, n1, m1, cnt + 1, check);
                    check[m1][n1] = false;
                }
            }
        }
    }

    static class xy{
        int x;
        int y;
        int cnt;

        public xy(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static void bfs(int maps[][], boolean[][] check){
        Queue<xy> queue = new LinkedList();
        queue.add(new xy(0,0,1));
        check[0][0]=true;
        int x[] = {1, 0, -1, 0};
        int y[] = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            xy tmp =queue.poll();
            if(tmp.y==maps.length-1 && tmp.x==maps[0].length-1){
                ans = Math.min(ans, tmp.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int n1 = tmp.x+x[i];
                int m1 = tmp.y+y[i];

                if (m1 >= 0 && m1 < maps.length && n1 >= 0 && n1 < maps[0].length) {
                    if (maps[m1][n1] == 1 && !check[m1][n1]) {
                        check[m1][n1] = true;
                        queue.add(new xy(n1, m1, tmp.cnt+1));
                    }
                }
            }

        }
    }
}
