public class p_네트워크 {
    public static void main(String[] args) {
        int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n= 3;
        System.out.println(solution(n,computers));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if(i==j)
                continue;

            if (computers[i][j] == 1 && !check[j]) {
                dfs(computers, j, check);
            }
        }
    }
}
