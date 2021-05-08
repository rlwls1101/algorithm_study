package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p_15686치킨배달 {
    static class xy {
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer = 123456789;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;
        s = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());
        int arr[][] = new int[n][n];
        ArrayList<xy> ch = new ArrayList<>();
        ArrayList<xy> home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(s.nextToken());
                if (tmp == 2) {
                    ch.add(new xy(i, j));
                }
                if (tmp == 1) {
                    home.add(new xy(i, j));
                }
                arr[i][j] = tmp;
            }
        }
        boolean[] check = new boolean[ch.size()];
        ArrayList<xy> current = new ArrayList<>();
        dfs(arr, ch, home, check, current, m, 0);
        System.out.println(answer);
        /*
        for(int t[] :arr){
            for(int t1: t){
                System.out.print(t1);
            }
            System.out.println();
        }

         */
    }

    static void dfs(int arr[][], ArrayList<xy> ch, ArrayList<xy> home, boolean[] check, ArrayList<xy> current, int m, int start) {
        if (current.size() == m) {
            answer = Math.min(answer, distance(current, home));
            return;
        }
        for (int i = start; i < ch.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                current.add(ch.get(i));
                start = start + 1;
                dfs(arr, ch, home, check, current, m, start);
                current.remove(current.size() - 1);
                check[i] = false;
            }
        }
    }

    static int distance(ArrayList<xy> current, ArrayList<xy> home) {
        int sum = 0;
        for (xy b : home) {
            int tmp = 123456789;
            for (xy a : current) {
                tmp = Math.min(tmp, Math.abs(b.x - a.x) + Math.abs(b.y - a.y));
            }
            sum = sum + tmp;
        }
        return sum;
    }
}